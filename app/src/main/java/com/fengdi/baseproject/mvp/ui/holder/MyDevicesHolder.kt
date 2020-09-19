package com.fengdi.baseproject.mvp.ui.holder

import android.view.View
import com.fengdi.baseproject.R
import com.fengdi.baseproject.app.entity.MyDevicesBean
import com.jess.arms.base.BaseHolder
import com.qmuiteam.qmui.util.QMUIDisplayHelper
import kotlinx.android.synthetic.main.item_home_smart_lock.view.*
import kotlinx.android.synthetic.main.item_home_smart_lock.view.linCardView
import kotlinx.android.synthetic.main.item_home_smart_lock.view.tvOnLine
import kotlinx.android.synthetic.main.item_mydevices.view.*

class MyDevicesHolder(itemView: View) : BaseHolder<MyDevicesBean>(itemView) {
    override fun setData(data: MyDevicesBean, position: Int) {

        //设置阴影
        itemView.linCardView.setRadiusAndShadow(QMUIDisplayHelper.dp2px(itemView.context, 10),
                QMUIDisplayHelper.dp2px(itemView.context, 10),
                0.4f)

        itemView.tvDeviceName.text = data.name
        itemView.tvGroup.text = itemView.resources.getString(R.string.str_group_s_m, data.group)
        itemView.tvDeviceId.text = itemView.resources.getString(R.string.str_deviceid_s_m, data.id)


        if (data.isOnLine == 1) {
            itemView.tvOnLine.text = "在线"
            itemView.tvOnLine.isSelected = true
        } else {
            itemView.tvOnLine.text = "离线"
            itemView.tvOnLine.isSelected = false
        }
    }
}