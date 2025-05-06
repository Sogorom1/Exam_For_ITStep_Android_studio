package com.example.examapp.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.examapp.R

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    private val comments = listOf("Great concert!", "Loved the music!", "Amazing experience!")
    private lateinit var selectedComment: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        notificationsViewModel = ViewModelProvider(this).get(NotificationsViewModel::class.java)

        val commentSpinner: Spinner = root.findViewById(R.id.comment_spinner)
        selectedComment = root.findViewById(R.id.selected_comment)

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, comments)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        commentSpinner.adapter = adapter

        notificationsViewModel.selectedComment.observe(viewLifecycleOwner) { comment ->
            selectedComment.text = comment
        }

        root.findViewById<Button>(R.id.submit_comment).setOnClickListener {
            notificationsViewModel.selectComment(commentSpinner.selectedItemPosition)
        }

        return root
    }
}