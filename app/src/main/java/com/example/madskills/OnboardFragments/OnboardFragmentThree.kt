package com.example.madskills.OnboardFragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.madskills.R
import com.example.madskills.RegActivity

class OnboardFragmentThree : Fragment() {
    private lateinit var bind: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.activity_onboard_fragment_three, container, false)
        /*activity?.let{
            val intent = Intent (it, RegActivity::class.java)
            it.startActivity(intent)
        }
        }
*/
    }

}
