package com.fengdi.baseproject.mvp.ui.adapter

import android.view.View
import com.fengdi.baseproject.R
import com.fengdi.baseproject.app.entity.SmartLockBean
import com.fengdi.baseproject.app.entity.UnLockMessageBean
import com.fengdi.baseproject.mvp.ui.holder.UnLockMessageHolder
import com.jess.arms.base.BaseHolder
import com.jess.arms.base.DefaultAdapter

class UnLockMessageAdapter(locks: List<UnLockMessageBean>) : DefaultAdapter<UnLockMessageBean>(locks) {


    /**
     * 获取设置Holder
     */
    override fun getHolder(v: View, viewType: Int): BaseHolder<UnLockMessageBean> {
        return UnLockMessageHolder(v)
    }

    /**
     * 设置布局文件
     */
    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_unlock_message
    }

}