package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.SettingModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.mine.SettingActivity


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/11/2020 15:56


 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(SettingModule::class), dependencies = arrayOf(AppComponent::class))
interface SettingComponent {
    fun inject(activity: SettingActivity)
}
