package com.thefuntasty.hauler

fun HaulerView.setOnDragDismissedListener(onDragDismissedListener: (DragDirection) -> Unit) {
    this.setOnDragDismissedListener(object : OnDragDismissedListener {
        override fun onDismissed(dragDirection: DragDirection) {
            onDragDismissedListener.invoke(dragDirection)
        }
    })
}
