package com.thefuntasty.haulersample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thefuntasty.haulersample.draggable.CommonUsageActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start_activity_button.setOnClickListener {
            startActivity(CommonUsageActivity.getStartIntent(this))
        }
    }
}
