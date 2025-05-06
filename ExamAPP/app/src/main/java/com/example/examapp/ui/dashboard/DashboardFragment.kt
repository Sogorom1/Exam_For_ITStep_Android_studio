package com.example.examapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.examapp.R

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var concert1Tickets: TextView
    private lateinit var concert2Tickets: TextView
    private lateinit var concert3Tickets: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        concert1Tickets = root.findViewById(R.id.concert1_tickets)
        concert2Tickets = root.findViewById(R.id.concert2_tickets)
        concert3Tickets = root.findViewById(R.id.concert3_tickets)

        dashboardViewModel.bookings.observe(viewLifecycleOwner) { bookings ->
            concert1Tickets.text = "Tickets: ${bookings["Concert 1"] ?: 0}"
            concert2Tickets.text = "Tickets: ${bookings["Concert 2"] ?: 0}"
            concert3Tickets.text = "Tickets: ${bookings["Concert 3"] ?: 0}"
        }

        root.findViewById<Button>(R.id.book_concert1).setOnClickListener {
            dashboardViewModel.bookTicket("Concert 1")
        }
        root.findViewById<Button>(R.id.book_concert2).setOnClickListener {
            dashboardViewModel.bookTicket("Concert 2")
        }
        root.findViewById<Button>(R.id.book_concert3).setOnClickListener {
            dashboardViewModel.bookTicket("Concert 3")
        }

        return root
    }
}