package com.example.madskills

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.madskills.databinding.ActivityMainBinding
import com.example.madskills.databinding.ActivityMainFragment1Binding
import com.google.android.material.bottomsheet.BottomSheetDialog


class MainFragment1 : AppCompatActivity() {

    private lateinit var binding : ActivityMainFragment1Binding
    private lateinit var bottomSheetDialog: BottomSheetDialog

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

   fun onCardViewClicked(view: View) {
        val bottomSheetDialog = BottomSheetDialog(view.context)
        val view = LayoutInflater.from(view.context).inflate(R.layout.bottom_sheet, null)
        bottomSheetDialog.setContentView(view)
        bottomSheetDialog.show()
    }
    fun onCloseButtonClicked(view: View) {
        // Закрываем BottomSheetDialog
        bottomSheetDialog.dismiss()
    }
    fun onBtnClicked(view: View) {
        val bottomSheetDialog = BottomSheetDialog(view.context)
        val view = LayoutInflater.from(view.context).inflate(R.layout.bottom_sheet_buy, null)
        bottomSheetDialog.setContentView(view)
        bottomSheetDialog.show()
    }


}