package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.AddDeviceModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.home.AddDeviceActivity


/**
 * Description:
 * <p>
 * Created by YangJie on 09/17/2020 11:16
 *
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(AddDeviceModule::class), dependencies = arrayOf(AppComponent::class))
interface AddDeviceComponent {
    fun inject(activity: AddDeviceActivity)
}
