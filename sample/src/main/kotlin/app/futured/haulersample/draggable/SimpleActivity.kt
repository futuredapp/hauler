package app.futured.haulersample.draggable

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import app.futured.hauler.setOnDragActivityListener
import app.futured.hauler.setOnDragDismissedListener
import app.futured.haulersample.R
import kotlinx.android.synthetic.main.activity_simple.*

class SimpleActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, SimpleActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)

        commonHaulerView.setOnDragDismissedListener {
            finish()
        }

        commonHaulerView.setOnDragActivityListener { elasticOffset, rawOffset ->
            Log.d("SimpleActivity", "elasticOffset: $elasticOffset, rawOffset: $rawOffset")
        }
    }
}
