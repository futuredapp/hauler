package app.futured.haulersample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.futured.haulersample.draggable.SimpleActivity
import app.futured.haulersample.draggable.SimpleJavaActivity
import app.futured.haulersample.draggable.advanced.AdvancedActivity
import app.futured.haulersample.draggable.databinding.DatabindingActivity
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

        startJavaCommonButton.setOnClickListener {
            startActivity(SimpleJavaActivity.getStartIntent(this))
        }
    }
}
