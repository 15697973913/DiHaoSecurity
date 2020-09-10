package com.fengdi.baseproject.mvp.ui.holder

import android.view.View
import com.fengdi.baseproject.app.entity.SmartLockBean
import com.jess.arms.base.BaseHolder
import com.jess.arms.di.component.AppComponent
import com.jess.arms.http.imageloader.ImageLoader
import com.jess.arms.utils.ArmsUtils
import com.qmuiteam.qmui.util.QMUIDisplayHelper
import kotlinx.android.synthetic.main.item_home_smart_lock.view.*

class SmartLockHolder(itemView: View) : BaseHolder<SmartLockBean>(itemView) {

    /**
     *     可以在任何可以拿到 Context 的地方, 拿到 AppComponent, 从而得到用 Dagger 管理的单例对象
     */
    private var mAppComponent: AppComponent = ArmsUtils.obtainAppComponentFromContext(itemView.context)

    /**
     * 用于加载图片的管理类, 默认使用 Glide, 使用策略模式, 可替换框架
     */
    private var mImageLoader: ImageLoader


    init {
        mImageLoader = mAppComponent.imageLoader()
    }

    override fun setData(data: SmartLockBean, position: Int) {
        itemView.tvLockName.text = data.name

//        //itemView 的 Context 就是 Activity, Glide 会自动处理并和该 Activity 的生命周期绑定
//        mImageLoader.loadImage(itemView.context,
//                ImageConfigImpl
//                        .builder()
//                        .url(data.img)
//                        .imageView(itemView.ivLockImage)
//                        .build())

        itemView.tvOnLine.isSelected = data.isOnLine == 1
        itemView.tvAuthorizedUnlock.isSelected = data.isOnLine == 1
        itemView.tvRemoteUnlock.isSelected = data.isOnLine == 1

        if (data.state == 1) {
            itemView.tvState.isSelected = true
            itemView.tvState.text = "开门"
        } else {
            itemView.tvState.isSelected = false
            itemView.tvState.text = "关门"
        }

        if (data.isOnLine == 1) {
            itemView.tvOnLine.text = "在线"
        } else {
            itemView.tvOnLine.text = "离线"
        }


        //设置阴影
        itemView.linCardView.setRadiusAndShadow(QMUIDisplayHelper.dp2px(itemView.context, 10),
                QMUIDisplayHelper.dp2px(itemView.context, 10),
                0.4f)

    }

}