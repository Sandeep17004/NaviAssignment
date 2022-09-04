package com.example.naviassignment.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class VerticalPaddingItemDecoration(private val verticalMargin: Int) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {

        with(outRect) {

            val isFirstPosition = parent.getChildAdapterPosition(view) == 0
            val isLastPosition =
                parent.getChildAdapterPosition(view) == (parent.adapter?.itemCount ?: 0) - 1

            top = if (isFirstPosition) verticalMargin else verticalMargin / 2
            bottom = if (isLastPosition) verticalMargin else verticalMargin / 2
        }
    }
}