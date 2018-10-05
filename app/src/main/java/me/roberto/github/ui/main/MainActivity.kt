package me.roberto.github.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.roberto.github.R

class MainActivity : AppCompatActivity() {


    //All of the content is on MainFrangment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }

}
