package com.example.moskovchuk_final_project.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moskovchuk_final_project.databinding.FragmentPersonageBinding


class PersonageFragment : Fragment() {

    lateinit var binding: FragmentPersonageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPersonageBinding.inflate(inflater)
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = PersonageFragment()
    }
}