package com.jeber.myapplication.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.jeber.myapplication.R

class ThirdFragment : Fragment() {

    companion object {
        fun newInstance() = ThirdFragment()
    }
    lateinit var tvNumber: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvNumber = view.findViewById(R.id.textView_number)

        val randomInt = requireArguments().getInt("random_int")
        tvNumber.text = randomInt.toString()
        Log.d("ThirdFragment::", randomInt.toString())
    }

}