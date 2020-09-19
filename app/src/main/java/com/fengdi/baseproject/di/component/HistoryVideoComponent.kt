package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.HistoryVideoModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.home.HistoryVideoActivity


/**
 * Description:
 * <p>
 * Created by YangJie on 09/18/2020 16:40
 *
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(HistoryVideoModule::class), dependencies = arrayOf(AppComponent::class))
interface HistoryVideoComponent {
    fun inject(activity: HistoryVideoActivity)
}
