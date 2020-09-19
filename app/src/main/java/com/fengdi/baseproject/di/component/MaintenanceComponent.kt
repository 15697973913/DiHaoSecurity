package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.MaintenanceModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.message.MaintenanceActivity


/**
 * Description:
 * <p>
 * Created by YangJie on 09/15/2020 16:47
 *
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(MaintenanceModule::class), dependencies = arrayOf(AppComponent::class))
interface MaintenanceComponent {
    fun inject(activity: MaintenanceActivity)
}
