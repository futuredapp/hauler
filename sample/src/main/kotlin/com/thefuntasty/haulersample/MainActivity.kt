package com.thefuntasty.haulersample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thefuntasty.haulersample.draggable.AdvancedUsageActivity
import com.thefuntasty.haulersample.draggable.SimpleUsageActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startCommonButton.setOnClickListener {
            startActivity(SimpleUsageActivity.getStartIntent(this))
        }

        startAdvancedButton.setOnClickListener {
            startActivity(AdvancedUsageActivity.getStartIntent(this))
        }
    }
}
