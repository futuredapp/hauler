package com.thefuntasty.haulersample.draggable.databinding

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.thefuntasty.haulersample.R
import com.thefuntasty.haulersample.databinding.ActivityDatabindingBinding
import kotlinx.android.synthetic.main.activity_databinding.*

class DatabindingActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, DatabindingActivity::class.java)
    }

    lateinit var binding: ActivityDatabindingBinding

    private val onDragDismissListener = Runnable { finish() }
    private var state = DatabindingActivityState(true, onDragDismissListener)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityDatabindingBinding>(this, R.layout.activity_databinding)
        refreshBinding()

        dragEnabledCheck.setOnCheckedChangeListener { _, isChecked ->
            state = state.copy(isDragEnabled = isChecked)
            refreshBinding()
        }
    }

    private fun refreshBinding() {
        binding.viewState = state
        binding.executePendingBindings()
    }
}
