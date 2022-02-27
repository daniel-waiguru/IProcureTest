package com.danielwaiguru.data.di

import androidx.room.Room
import com.danielwaiguru.data.source.local.IProcureDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private val databaseModule = module {
    single {
        /**
         * provides IProcureDatabase singleton instance
         */
        Room.databaseBuilder(
            androidContext(),
            IProcureDatabase::class.java,
            "iprocure_db"
        ).fallbackToDestructiveMigration().build()
    }
    /**
     * provides ProductDao singleton instance
     */
    single { get<IProcureDatabase>().getProductDao() }
}

val dataModules = listOf(
    databaseModule
)