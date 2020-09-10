package com.fengdi.baseproject.mvp.ui.adapter

import android.view.View
import android.widget.AdapterView
import com.fengdi.baseproject.R
import com.fengdi.baseproject.app.entity.MonitorBean
import com.fengdi.baseproject.mvp.ui.holder.MonitorHolder
import com.jess.arms.base.BaseHolder
import com.jess.arms.base.DefaultAdapter

class MonitorAdapter(monitors: List<MonitorBean>) : DefaultAdapter<MonitorBean>(monitors) {

    /**
     * 获取设置Holder
     */
    override fun getHolder(v: View, viewType: Int): BaseHolder<MonitorBean> {

        return MonitorHolder(v)
    }

    /**
     * 设置布局文件
     */
    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_home_monitor
    }

}