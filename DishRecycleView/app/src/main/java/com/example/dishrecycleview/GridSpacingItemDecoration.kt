package com.example.dishrecycleview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GridSpacingItemDecoration(
    private val spanCount: Int,   // 每行多少列
    private val spacing: Int,     // 间隔大小 (px)
    private val includeEdge: Boolean // 是否包含边缘
):RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view) // item 索引
        val column = position % spanCount // 当前是第几列

        if (includeEdge) {
            // 包含边缘
            outRect.left = spacing - column * spacing / spanCount
            outRect.right = (column + 1) * spacing / spanCount

            if (position < spanCount) { // 第一行
                outRect.top = spacing
            }
            outRect.bottom = spacing // 每行底部
        } else {
            // 不包含边缘
            outRect.left = column * spacing / spanCount
            outRect.right = spacing - (column + 1) * spacing / spanCount
            if (position >= spanCount) {
                outRect.top = spacing
            }
        }
    }
}