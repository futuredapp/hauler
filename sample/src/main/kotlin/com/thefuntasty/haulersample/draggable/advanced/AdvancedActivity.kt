package com.thefuntasty.haulersample.draggable.advanced

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.thefuntasty.haulersample.R
import kotlinx.android.synthetic.main.activity_advanced.*

class AdvancedActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, AdvancedActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advanced)

        advancedHaulerView.setOnDragDismissedListener { dragDirection ->
            Toast.makeText(this, "Dismissed in direction: $dragDirection", Toast.LENGTH_SHORT).show()
            finish()
        }

        ignoredAreaView.setScrollViewParent(scrollViewParent)
    }
}
