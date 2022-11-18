package com.jeber.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.os.bundleOf
import com.jeber.myapplication.ui.main.MainFragment
import com.jeber.myapplication.ui.main.SecondFragment
import com.jeber.myapplication.ui.main.ThirdFragment

class MainActivity : AppCompatActivity() {

    private lateinit var btnChangeToThirdFragment: Button
    private lateinit var btnChangeToSecondFragment: Button

//    viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnChangeToThirdFragment = findViewById(R.id.btn_change_to_third)
        btnChangeToSecondFragment = findViewById(R.id.btn_change_to_second)

//
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_top, MainFragment.newInstance())
                .commitNow()

            supportFragmentManager.beginTransaction()
                .replace(R.id.container_bottom, SecondFragment.newInstance())
                .commitNow()
        }


//     On Click =>
        btnChangeToSecondFragment.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_bottom, SecondFragment.newInstance())
                .commitNow()
        }

        btnChangeToThirdFragment.setOnClickListener {

            val randomInt = (0..300).random()
            val bundle = bundleOf("random_int" to randomInt)
            val fragment =  ThirdFragment.newInstance()
            fragment.arguments = bundle

            supportFragmentManager.beginTransaction()
                .replace(R.id.container_bottom, fragment)
                .commitNow()
        }
//
    }
}