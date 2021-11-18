package com.example.dualpaneapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class SettingDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val EXTRA_SETTING_OPTION:String= "option";


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_detail)

        val option:String? = intent.getStringExtra(EXTRA_SETTING_OPTION)
        val fragmentManager: FragmentManager = supportFragmentManager
        val displaySettingFragment = DisplaySettingsFragment()

        fragmentManager.beginTransaction().add(R.id.settingsContainer,displaySettingFragment)
            .commit()


    }
}