package com.fengdi.baseproject.mvp.ui.holder

import android.view.View
import com.fengdi.baseproject.app.entity.AuthorizeRecordBean
import com.fengdi.baseproject.app.entity.SmartLockBean
import com.fengdi.baseproject.app.entity.UnLockMessageBean
import com.jess.arms.base.BaseHolder
import com.jess.arms.di.component.AppComponent
import com.jess.arms.http.imageloader.ImageLoader
import com.jess.arms.utils.ArmsUtils
import com.qmuiteam.qmui.util.QMUIDisplayHelper
import kotlinx.android.synthetic.main.item_home_smart_lock.view.*

class AuthorizeRecordHolder(itemView: View) : BaseHolder<AuthorizeRecordBean>(itemView) {

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

    override fun setData(data: AuthorizeRecordBean, position: Int) {

    }

}