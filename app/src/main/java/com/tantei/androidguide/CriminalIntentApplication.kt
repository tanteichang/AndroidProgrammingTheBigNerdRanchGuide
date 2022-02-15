package com.tantei.androidguide

import android.app.Application
import android.util.Log

private const val TAG = "CriminalIntentApplication"

class CriminalIntentApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        CrimeRepository.initialize(this)
    }
}