package com.fengdi.baseproject.mvp.ui.holder

import android.view.View
import android.widget.AdapterView
import com.fengdi.baseproject.app.callback.MyOnItemClickListener
import com.fengdi.baseproject.app.entity.MonitorBean
import com.jess.arms.base.BaseHolder
import com.jess.arms.di.component.AppComponent
import com.jess.arms.http.imageloader.ImageLoader
import com.jess.arms.utils.ArmsUtils
import com.qmuiteam.qmui.util.QMUIDisplayHelper
import kotlinx.android.synthetic.main.item_home_monitor.view.*

class MonitorHolder(view: View) : BaseHolder<MonitorBean>(view) {


    /**
     *     可以在任何可以拿到 Context 的地方, 拿到 AppComponent, 从而得到用 Dagger 管理的单例对象
     */
    private var mAppComponent: AppComponent = ArmsUtils.obtainAppComponentFromContext(view.context)

    /**
     * 用于加载图片的管理类, 默认使用 Glide, 使用策略模式, 可替换框架
     */
    private var mImageLoader: ImageLoader

    init {
        mImageLoader = mAppComponent.imageLoader()
    }


    override fun setData(data: MonitorBean, position: Int) {
        //itemView 的 Context 就是 Activity, Glide 会自动处理并和该 Activity 的生命周期绑定
//        mImageLoader.loadImage(itemView.context,
//                ImageConfigImpl
//                        .builder()
//                        .url(data.img)
//                        .imageView(itemView.ivImage)
//                        .build())

        itemView.tvName.text = data.name
        if (data.isOnLine == 1) {
            itemView.tvOnLine.text = "在线"
            itemView.tvOnLine.isSelected = true
        } else {
            itemView.tvOnLine.text = "离线"
            itemView.tvOnLine.isSelected = false
        }

        //设置阴影
        itemView.linCardView.setRadiusAndShadow(QMUIDisplayHelper.dp2px(itemView.context, 10),
                QMUIDisplayHelper.dp2px(itemView.context, 10),
                0.4f)

        itemView.ivMore.setOnClickListener { v ->
            run {
                mOnViewClickListener.onViewClick(v, position)
            }
        }
    }


}