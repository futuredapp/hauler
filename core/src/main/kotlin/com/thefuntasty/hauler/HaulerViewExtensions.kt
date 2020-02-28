package com.thefuntasty.hauler

fun HaulerView.setOnDragDismissedListener(onDragDismissedListener: (DragDirection) -> Unit) {
    this.setOnDragDismissedListener(object : OnDragDismissedListener {
        override fun onDismissed(dragDirection: DragDirection) {
            onDragDismissedListener.invoke(dragDirection)
        }
    })
}

fun HaulerView.setOnDragActivityListener(onDragActivityListener: (elasticOffsetPixels: Float, rawOffset: Float) -> Unit) {
    this.setOnDragActivityListener(object : OnDragActivityListener {
        override fun onDrag(elasticOffsetPixels: Float, rawOffset: Float) {
            onDragActivityListener.invoke(elasticOffsetPixels, rawOffset)
        }
    })
}
