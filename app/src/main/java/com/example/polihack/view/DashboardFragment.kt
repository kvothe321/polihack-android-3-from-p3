package com.example.polihack.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.polihack.R
import com.example.polihack.viewmodel.FragmentDashboardViewModel

class DashboardFragment : Fragment() {

    companion object {
        fun getInstance(): DashboardFragment {
            val fragment = DashboardFragment()
            // TODO: created like this so we can add optional parameters
            return fragment
        }
    }

    private lateinit var viewModel: FragmentDashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fragment_dashboard, container, false)
    }

}