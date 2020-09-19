package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.MonitorDetailModule

import com.jess.arms.di.scope.FragmentScope
import com.fengdi.baseproject.mvp.ui.fragment.home.MonitorDetailFragment


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/10/2020 10:17
 

 * ================================================
 */
@FragmentScope
@Component(modules = arrayOf(MonitorDetailModule::class), dependencies = arrayOf(AppComponent::class))
interface MonitorDetailComponent {
    fun inject(fragment: MonitorDetailFragment)
}
