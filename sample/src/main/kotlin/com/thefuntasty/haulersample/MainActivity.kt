package com.thefuntasty.haulersample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thefuntasty.haulersample.draggable.SimpleActivity
import com.thefuntasty.haulersample.draggable.advanced.AdvancedActivity
import com.thefuntasty.haulersample.draggable.databinding.DatabindingActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startCommonButton.setOnClickListener {
            startActivity(SimpleActivity.getStartIntent(this))
        }

        startAdvancedButton.setOnClickListener {
            startActivity(AdvancedActivity.getStartIntent(this))
        }

        startBindingButton.setOnClickListener {
            startActivity(DatabindingActivity.getStartIntent(this))
        }
    }
}
