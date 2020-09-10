package com.fengdi.baseproject.app.callback

import android.view.View

interface MyOnItemClickListener<T> {
    /**
     * item 被点击
     *
     * @param view     被点击的 [View]
     * @param viewType 布局类型
     * @param data     数据
     * @param position 在 RecyclerView 中的位置
     */
    fun onItemClick(view: View, viewType: Int, data: T, position: Int)
}