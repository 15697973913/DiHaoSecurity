package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.ServiceCenterModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.mine.ServiceCenterActivity


/**
 * Description:
 * <p>
 * Created by YangJie on 09/18/2020 17:56
 *
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(ServiceCenterModule::class), dependencies = arrayOf(AppComponent::class))
interface ServiceCenterComponent {
    fun inject(activity: ServiceCenterActivity)
}
