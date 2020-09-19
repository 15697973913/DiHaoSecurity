package com.fengdi.baseproject.mvp.ui.adapter

import android.view.View
import com.fengdi.baseproject.R
import com.fengdi.baseproject.app.entity.AuthorizeManageBean
import com.fengdi.baseproject.mvp.ui.holder.AuthorizeManageHolder
import com.jess.arms.base.BaseHolder
import com.jess.arms.base.DefaultAdapter

/**
 *
 *
 *author: YangJie
 *email: 2295360491@qq.com
 *time: 2020/9/15 16:41
 * descripton: 授权管理
 *
 *
*/
class AuthorizeManageAdapter(locks: List<AuthorizeManageBean>) : DefaultAdapter<AuthorizeManageBean>(locks) {


    /**
     * 获取设置Holder
     */
    override fun getHolder(v: View, viewType: Int): BaseHolder<AuthorizeManageBean> {
        return AuthorizeManageHolder(v)
    }

    /**
     * 设置布局文件
     */
    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_authorize_manage
    }

}