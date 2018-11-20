package com.thefuntasty.haulersample.draggable

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thefuntasty.haulersample.R
import kotlinx.android.synthetic.main.activity_draggable.*

class CommonUsageActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, CommonUsageActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draggable)

        elasticDragDismissFrameLayout.setOnDragDismissedListener {
            finish()
        }
    }
}
