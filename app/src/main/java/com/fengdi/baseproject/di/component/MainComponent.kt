package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.MainModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.MainActivity


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/05/2020 17:57
 

 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(MainModule::class), dependencies = arrayOf(AppComponent::class))
interface MainComponent {
    fun inject(activity: MainActivity)
}
