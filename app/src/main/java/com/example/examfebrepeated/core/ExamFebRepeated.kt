package com.example.examfebrepeated.core

import android.app.Application
import com.example.examfebrepeated.core.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.ksp.generated.module

class ExamFebRepeated : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ExamFebRepeated)
            modules(AppModule().module)
        }
    }
}