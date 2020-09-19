package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.DoorLockSettingModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.home.DoorLockSettingActivity


/**
 * Description:
 * <p>
 * Created by YangJie on 09/18/2020 16:01
 *
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(DoorLockSettingModule::class), dependencies = arrayOf(AppComponent::class))
interface DoorLockSettingComponent {
    fun inject(activity: DoorLockSettingActivity)
}
