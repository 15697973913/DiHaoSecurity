package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.RemoteUnLockModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.home.RemoteUnLockActivity


/**
 * Description:
 * <p>
 * Created by YangJie on 09/17/2020 18:48
 *
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(RemoteUnLockModule::class), dependencies = arrayOf(AppComponent::class))
interface RemoteUnLockComponent {
    fun inject(activity: RemoteUnLockActivity)
}
