package com.danielwaiguru.data.base

import com.danielwaiguru.data.utils.KoinTestRule
import org.junit.Rule
import org.koin.test.KoinTest


abstract class BaseKoinTest: KoinTest {
    @get:Rule
    val koinTestRule = KoinTestRule()
}