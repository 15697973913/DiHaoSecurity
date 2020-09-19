package com.fengdi.baseproject.mvp.ui.adapter

import android.view.View
import com.fengdi.baseproject.R
import com.fengdi.baseproject.app.entity.RemoteUnLockBean
import com.fengdi.baseproject.app.entity.UnLockRecoardBean
import com.fengdi.baseproject.mvp.ui.holder.AlertMessageHolder
import com.fengdi.baseproject.mvp.ui.holder.AuthorizeRecordHolder
import com.fengdi.baseproject.mvp.ui.holder.RemoteUnLockHolder
import com.fengdi.baseproject.mvp.ui.holder.UnLockRecordHolder
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
class UnLockRecordAdapter(locks: List<UnLockRecoardBean>) : DefaultAdapter<UnLockRecoardBean>(locks) {


    /**
     * 获取设置Holder
     */
    override fun getHolder(v: View, viewType: Int): BaseHolder<UnLockRecoardBean> {
        return UnLockRecordHolder(v)
    }

    /**
     * 设置布局文件
     */
    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_unlocking_record
    }

}