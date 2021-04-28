package app.futured.haulersample.draggable.databinding

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import app.futured.hauler.DragDirection
import app.futured.haulersample.R
import app.futured.haulersample.databinding.ActivityDatabindingBinding
import kotlinx.android.synthetic.main.activity_databinding.*

class DatabindingActivity : AppCompatActivity(), DatabindingActivityView {
    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, DatabindingActivity::class.java)
    }

    lateinit var binding: ActivityDatabindingBinding

    private var state = DatabindingActivityState(true)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding)
        refreshBinding()

        dragEnabledCheck.setOnCheckedChangeListener { _, isChecked ->
            state = state.copy(isDragEnabled = isChecked)
            refreshBinding()
        }
    }

    private fun refreshBinding() {
        binding.viewState = state
        binding.view = this
        binding.executePendingBindings()
    }

    override fun onDragDismissed(dragDirection: DragDirection) {
        finish()
    }
}
