package com.thefuntasty.haulersample.draggable

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thefuntasty.hauler.ElasticDragDismissFrameLayout
import com.thefuntasty.haulersample.R
import kotlinx.android.synthetic.main.activity_daraggable.*

class DraggableActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, DraggableActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daraggable)
        elasticDragDismissFrameLayout.apply {
            isDragEnabled(true)
            setOnDragDismissedListener(object: ElasticDragDismissFrameLayout.OnDismissListener{
                override fun dismiss() {
                    this@DraggableActivity.finish()
                }
            })
        }

        lockable_scroll_view.isScrollable(true)
    }
}
