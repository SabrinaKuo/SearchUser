package com.example.sabrina.searchuser.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.sabrina.searchuser.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, SearchFragment()).commit()
    }
}
