package com.fengdi.baseproject.mvp.ui.adapter

import android.view.View
import com.fengdi.baseproject.R
import com.fengdi.baseproject.app.entity.SmartLockBean
import com.fengdi.baseproject.mvp.ui.holder.SmartLockHolder
import com.jess.arms.base.BaseHolder
import com.jess.arms.base.DefaultAdapter

class SmartLockAdapter(locks: List<SmartLockBean>) : DefaultAdapter<SmartLockBean>(locks) {


    /**
     * 获取设置Holder
     */
    override fun getHolder(v: View, viewType: Int): BaseHolder<SmartLockBean> {
        return SmartLockHolder(v)
    }

    /**
     * 设置布局文件
     */
    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_home_smart_lock
    }

}