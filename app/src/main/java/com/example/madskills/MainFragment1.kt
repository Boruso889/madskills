package com.example.madskills

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.madskills.databinding.ActivityMainBinding
import com.example.madskills.databinding.ActivityMainFragment1Binding


class MainFragment1 : AppCompatActivity() {

    private lateinit var binding : ActivityMainFragment1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainFragment1Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId) {

                R.id.Analyze -> replaceFragment(MainFragment())
                R.id.Result -> replaceFragment(ResultFragment())
                R.id.Support -> replaceFragment(SupportFragment())
                R.id.Profile -> replaceFragment(UserFragment())

                else -> {

                }


            }
true

        }





    }
    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction =   fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()

    }
}