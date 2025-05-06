package com.example.examapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _accountInfo = MutableLiveData<String>("Account: User123\nEmail: user123@example.com")
    val accountInfo: LiveData<String> = _accountInfo

    fun updateAccountInfo(newInfo: String) {
        _accountInfo.value = newInfo
    }
}