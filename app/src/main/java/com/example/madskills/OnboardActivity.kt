package com.example.madskills

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.madskills.OnboardFragments.OnboardFragmentAdapter
import com.example.madskills.OnboardFragments.OnboardFragmentOne
import com.example.madskills.OnboardFragments.OnboardFragmentThree
import com.example.madskills.OnboardFragments.OnboardFragmentTwo

class OnboardActivity : AppCompatActivity() {

    private val data= mutableListOf<String>()
    private val fragmentList = ArrayList<Fragment>()
    private lateinit var viewPager: ViewPager2
   // private lateinit var btnNext: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard)
        castView()
        addToList()
        fragmentList.add(OnboardFragmentOne())
        fragmentList.add(OnboardFragmentTwo())
        fragmentList.add(OnboardFragmentThree())

        viewPager.adapter = OnboardFragmentAdapter(this, fragmentList)
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        /*btnNext.setOnClickListener {
            viewPager.apply {
                val intent = Intent(this@OnboardActivity, RegActivity::class.java)
                startActivity(intent)
                this@OnboardActivity.finish()
            }
        }*/
    }

    private fun castView(){
        viewPager = findViewById(R.id.view_pager2)
        //btnNext = findViewById(R.id.tvOBEnd)


    }
    private fun addToList() {
        for (item in 1..3 ){
            data.add("item $item")
        }
    }

}