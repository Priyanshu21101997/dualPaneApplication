package com.example.dualpaneapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import android.content.Intent
import android.widget.FrameLayout
import android.widget.ListView


class MainActivity : AppCompatActivity() , FirstFragment.OnOptionClickListener{

    private var isTwoPane = false
    private val fm: FragmentManager = supportFragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val firstFragment = FirstFragment()

        if(findViewById<FrameLayout>(R.id.detailContainer)!=null){
            isTwoPane = true
        }

        fm.beginTransaction().add(R.id.container,firstFragment).commit()
    }

    override fun onOptionSelected(option: String?) {
        val displaySettingsFragment = DisplaySettingsFragment()
        val storageSettingsFragment = StorageSettingsFragment()
        if(isTwoPane){
            when(option) {
                "display"->fm.beginTransaction()
                    .replace(R.id.detailContainer, displaySettingsFragment).commit()
                "storage"->fm.beginTransaction()
                    .replace(R.id.detailContainer, storageSettingsFragment).commit()
            }
        }
        else {
            val intent = Intent(this, SettingDetailActivity::class.java)
            intent.putExtra("EXTRA_SETTING_OPTION", option)
            startActivity(intent)
        }
    }
}