package com.example.a7minutesworkoutapp

import android.app.Application

class WorkoutApp: Application() {
    val db:HistoryDatabase by lazy {
        HistoryDatabase.getInstance(this)
    }
}