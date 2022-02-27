package com.danielwaiguru.presentation.utils

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun Fragment.snackBar(message: String, backTint: Int? = null, duration: Int = Snackbar.LENGTH_SHORT) {
    val snackbar = Snackbar.make(requireView(), message, duration)
    if (backTint != null) snackbar.setBackgroundTint(backTint)
    snackbar.show()
}
fun Fragment.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(requireContext(), message, duration).show()
}