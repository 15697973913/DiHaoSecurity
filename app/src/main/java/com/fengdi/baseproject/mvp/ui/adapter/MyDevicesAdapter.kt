package com.fengdi.baseproject.mvp.ui.adapter

import android.view.View
import com.fengdi.baseproject.R
import com.fengdi.baseproject.app.entity.MyDevicesBean
import com.fengdi.baseproject.mvp.ui.holder.MyDevicesHolder
import com.jess.arms.base.BaseHolder
import com.jess.arms.base.DefaultAdapter

class MyDevicesAdapter(devices: List<MyDevicesBean>) : DefaultAdapter<MyDevicesBean>(devices) {
    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_mydevices
    }

    override fun getHolder(v: View, viewType: Int): BaseHolder<MyDevicesBean> {
        return MyDevicesHolder(v)
    }
}