package com.danielwaiguru.presentation.add_products

import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.AdapterView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.danielwaiguru.domain.models.Product
import com.danielwaiguru.presentation.R
import com.danielwaiguru.presentation.databinding.FragmentAddInventoryBinding
import com.danielwaiguru.presentation.utils.ImageUtils
import com.danielwaiguru.presentation.utils.showToast
import com.danielwaiguru.presentation.utils.snackBar
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddInventoryFragment : Fragment(R.layout.fragment_add_inventory) {
    private var _binding: FragmentAddInventoryBinding? = null
    private val binding: FragmentAddInventoryBinding get() = _binding!!
    private val viewModel: AddProductViewModel by viewModel()
    private lateinit var productCategory: String
    private lateinit var productUnit: String
    private lateinit var imageUrl: String
    private val imagePicker = registerForActivityResult(ActivityResultContracts.GetContent()) {
        if (it == null) return@registerForActivityResult
        val inputStream = requireContext()
            .contentResolver.openInputStream(it) ?: return@registerForActivityResult
        val bitmap = BitmapFactory.decodeStream(inputStream)
        imageUrl = ImageUtils.bitMapToString(bitmap) ?: ""
        binding.productImage.setImageURI(it)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAddInventoryBinding.bind(view)
        initUi()

    }

    private fun initUi() {
        initListeners()
        observeViewState()
    }

    private fun observeViewState() {
        viewModel.onCloseEvent.observe(viewLifecycleOwner) {
            findNavController().popBackStack()
        }
        viewModel.onSaveEvent.observe(viewLifecycleOwner) {
            addProduct()
        }
        viewModel.onPickImageEvent.observe(viewLifecycleOwner) {
            chooseImage()
        }
    }
    private fun chooseImage() {
        imagePicker.launch("image/*")
    }

    private fun initListeners() {
        with(binding) {
            close.setOnClickListener {
                viewModel.onCancelClicked()
            }
            btnCancel.setOnClickListener { viewModel.onCancelClicked() }
            btnSave.setOnClickListener { viewModel.onSaveClicked() }
            spCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    adapterView: AdapterView<*>,
                    p1: View?,
                    position: Int,
                    p3: Long
                ) {
                    productCategory = adapterView.getItemAtPosition(position) as String
                }

                override fun onNothingSelected(p0: AdapterView<*>?) = Unit
            }

            spProductType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    adapterView: AdapterView<*>,
                    p1: View?,
                    position: Int,
                    p3: Long
                ) {
                    productUnit = adapterView.getItemAtPosition(position) as String
                }

                override fun onNothingSelected(p0: AdapterView<*>?) = Unit
            }
            imagePick.setOnClickListener { viewModel.onPickImageClicked() }
        }
    }
    private fun addProduct() {
        with(binding) {
            val name = etProductName.text.toString()
            val code = etProductCode.text.toString()
            val type = etProductType.text.toString()
            val manufacturer = etManufacturer.text.toString()
            val distributor = etDistributor.text.toString()
            val unitCost = etUnitCost.text.toString()
            if (validateInputs(name, code, type, manufacturer, distributor, unitCost)) {
                val product = Product(
                    name = name,
                    code = code,
                    category = productCategory,
                    type = type,
                    unit = productUnit,
                    manufacturer = manufacturer,
                    distributor = distributor,
                    vat = addVat.isChecked,
                    unitCost = unitCost,
                    retailPrice = etDistributor.text.toString(),
                    agentPrice = etAgentPrice.text.toString(),
                    wholesalePrice = etWholePrice.text.toString(),
                    image = imageUrl
                )
                viewModel.addProduct(product)
                showToast(getString(R.string.save_success))
                findNavController().popBackStack()
            }
        }
    }
    private fun validateInputs(
        name: String,
        code: String,
        type: String,
        manufacturer: String,
        distributor: String,
        unitCost: String
    ): Boolean {
        with(binding) {
            return when {
                name.isEmpty() -> {
                    etProductName.apply {
                        error = getString(R.string.empty_field_error)
                        requestFocus()
                    }
                    false
                }
                code.isEmpty() ->{
                    etProductCode.apply {
                        error = getString(R.string.empty_field_error)
                        requestFocus()
                    }
                    false
                }
                type.isEmpty() -> {
                    etProductType.apply {
                        error = getString(R.string.empty_field_error)
                        requestFocus()
                    }
                    false
                }
                manufacturer.isEmpty() -> {
                    etManufacturer.apply {
                        error = getString(R.string.empty_field_error)
                        requestFocus()
                    }
                    false
                }
                distributor.isEmpty() -> {
                    etDistributor.apply {
                        error = getString(R.string.empty_field_error)
                        requestFocus()
                    }
                    false
                }
                unitCost.isEmpty() -> {
                    etUnitCost.apply {
                        error = getString(R.string.empty_field_error)
                        requestFocus()
                    }
                    false
                }
                !::imageUrl.isInitialized -> {
                    snackBar(getString(R.string.image_error_message), Color.RED)
                    false
                }
                else -> true
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}