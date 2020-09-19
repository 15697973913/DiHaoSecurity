package com.fengdi.baseproject.mvp.ui.adapter

import android.view.View
import com.fengdi.baseproject.R
import com.fengdi.baseproject.app.entity.AlertMessageBean
import com.fengdi.baseproject.app.entity.MaintenanceMeassageBean
import com.fengdi.baseproject.mvp.ui.holder.AlertMessageHolder
import com.fengdi.baseproject.mvp.ui.holder.MaintenanceMessageHolder
import com.jess.arms.base.BaseHolder
import com.jess.arms.base.DefaultAdapter

/**
 *
 *
 *author: YangJie
 *email: 2295360491@qq.com
 *time: 2020/9/15 16:41
 * descripton: 报警消息
 *
 *
 */
class MaintenanceMessageAdapter(locks: List<MaintenanceMeassageBean>) : DefaultAdapter<MaintenanceMeassageBean>(locks) {


    /**
     * 获取设置Holder
     */
    override fun getHolder(v: View, viewType: Int): BaseHolder<MaintenanceMeassageBean> {
        return MaintenanceMessageHolder(v)
    }

    /**
     * 设置布局文件
     */
    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_maintenance_message
    }

}