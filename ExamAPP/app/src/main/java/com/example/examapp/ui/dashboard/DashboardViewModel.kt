package com.example.examapp.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _bookings = MutableLiveData<MutableMap<String, Int>>(mutableMapOf(
        "Concert 1" to 0,
        "Concert 2" to 0,
        "Concert 3" to 0
    ))
    val bookings: LiveData<MutableMap<String, Int>> = _bookings

    fun bookTicket(concert: String) {
        val currentBookings = _bookings.value ?: mutableMapOf()
        currentBookings[concert] = (currentBookings[concert] ?: 0) + 1
        _bookings.value = currentBookings
    }
}