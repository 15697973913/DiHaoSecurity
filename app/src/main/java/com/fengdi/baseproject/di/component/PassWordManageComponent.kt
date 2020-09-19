package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.PassWordManageModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.home.PassWordManageActivity


/**
 * Description:
 * <p>
 * Created by YangJie on 09/18/2020 14:29
 *
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(PassWordManageModule::class), dependencies = arrayOf(AppComponent::class))
interface PassWordManageComponent {
    fun inject(activity: PassWordManageActivity)
}
