package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.UnLockAuthorizeModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.home.UnLockAuthorizeActivity


/**
 * Description:
 * <p>
 * Created by YangJie on 09/17/2020 17:22
 *
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(UnLockAuthorizeModule::class), dependencies = arrayOf(AppComponent::class))
interface UnLockAuthorizeComponent {
    fun inject(activity: UnLockAuthorizeActivity)
}
