package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.MyVideoModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.message.MyVideoActivity


/**
 * Description:
 * <p>
 * Created by YangJie on 09/16/2020 16:18
 *
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(MyVideoModule::class), dependencies = arrayOf(AppComponent::class))
interface MyVideoComponent {
    fun inject(activity: MyVideoActivity)
}
