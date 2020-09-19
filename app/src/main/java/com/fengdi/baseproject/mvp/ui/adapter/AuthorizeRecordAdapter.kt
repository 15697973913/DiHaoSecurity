package com.fengdi.baseproject.mvp.ui.adapter

import android.view.View
import com.fengdi.baseproject.R
import com.fengdi.baseproject.app.entity.AuthorizeRecordBean
import com.fengdi.baseproject.mvp.ui.holder.AlertMessageHolder
import com.fengdi.baseproject.mvp.ui.holder.AuthorizeRecordHolder
import com.jess.arms.base.BaseHolder
import com.jess.arms.base.DefaultAdapter

/**
 *
 *
 *author: YangJie
 *email: 2295360491@qq.com
 *time: 2020/9/15 16:41
 * descripton: 授权记录
 *
 *
*/
class AuthorizeRecordAdapter(locks: List<AuthorizeRecordBean>) : DefaultAdapter<AuthorizeRecordBean>(locks) {


    /**
     * 获取设置Holder
     */
    override fun getHolder(v: View, viewType: Int): BaseHolder<AuthorizeRecordBean> {
        return AuthorizeRecordHolder(v)
    }

    /**
     * 设置布局文件
     */
    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_unlock_authorize
    }

}