package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.DoorLockManageModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.home.DoorLockManageActivity


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/09/2020 17:19
 

 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(DoorLockManageModule::class), dependencies = arrayOf(AppComponent::class))
interface DoorLockManageComponent {
    fun inject(activity: DoorLockManageActivity)
}
