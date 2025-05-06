package com.example.examapp.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    private val _comments = listOf("Great concert!", "Loved the music!", "Amazing experience!")
    private val _selectedComment = MutableLiveData<String>("Selected: None")
    val selectedComment: LiveData<String> = _selectedComment

    fun selectComment(index: Int) {
        if (index in _comments.indices) {
            _selectedComment.value = "Selected: ${_comments[index]}"
        }
    }
}