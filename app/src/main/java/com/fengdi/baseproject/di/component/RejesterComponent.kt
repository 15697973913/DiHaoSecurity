package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.RejesterModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.login.RejesterActivity


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/11/2020 14:22


 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(RejesterModule::class), dependencies = arrayOf(AppComponent::class))
interface RejesterComponent {
    fun inject(activity: RejesterActivity)
}
