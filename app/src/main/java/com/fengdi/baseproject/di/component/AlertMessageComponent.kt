package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.AlertMessageModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.home.AlertMessageActivity


/**
 * Description:
 * <p>
 * Created by YangJie on 09/18/2020 18:30
 *
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(AlertMessageModule::class), dependencies = arrayOf(AppComponent::class))
interface AlertMessageComponent {
    fun inject(activity: AlertMessageActivity)
}
