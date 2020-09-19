package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.MonitorManageModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.home.MonitorManageActivity


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/10/2020 11:36
 

 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(MonitorManageModule::class), dependencies = arrayOf(AppComponent::class))
interface MonitorManageComponent {
    fun inject(activity: MonitorManageActivity)
}
