package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.DeviceGroupModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.home.DeviceGroupActivity


/**
 * Description:
 * <p>
 * Created by YangJie on 09/18/2020 15:26
 *
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(DeviceGroupModule::class), dependencies = arrayOf(AppComponent::class))
interface DeviceGroupComponent {
    fun inject(activity: DeviceGroupActivity)
}
