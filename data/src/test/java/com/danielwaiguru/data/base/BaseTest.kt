package com.danielwaiguru.data.base

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.danielwaiguru.data.source.local.IProcureDatabase
import com.danielwaiguru.data.source.local.ProductDao
import com.github.testcoroutinesrule.TestCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule

abstract class BaseTest: BaseKoinTest() {
    @get: Rule
    val rule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()
    lateinit var productDao: ProductDao
    private lateinit var db: IProcureDatabase
    @Before
    open fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, IProcureDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        productDao = db.getProductDao()
    }
    @After
    open fun tearDownDb() {
        db.clearAllTables()
        db.close()
    }
}