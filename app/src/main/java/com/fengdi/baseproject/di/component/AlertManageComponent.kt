package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.AlertManageModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.message.AlertManageActivity


/**
 * Description:
 * <p>
 * Created by YangJie on 09/15/2020 15:27
 *
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(AlertManageModule::class), dependencies = arrayOf(AppComponent::class))
interface AlertManageComponent {
    fun inject(activity: AlertManageActivity)
}
