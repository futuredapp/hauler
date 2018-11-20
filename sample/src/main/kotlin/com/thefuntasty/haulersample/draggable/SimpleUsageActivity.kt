package com.thefuntasty.haulersample.draggable

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thefuntasty.haulersample.R
import kotlinx.android.synthetic.main.activity_simple_usage.*

class SimpleUsageActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, SimpleUsageActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_usage)

        commonHaulerView.setOnDragDismissedListener {
            finish()
        }
    }
}
