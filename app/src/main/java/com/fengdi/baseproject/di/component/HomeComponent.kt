package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.HomeModule

import com.jess.arms.di.scope.FragmentScope
import com.fengdi.baseproject.mvp.ui.fragment.home.HomeFragment


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/07/2020 16:27
 

 * ================================================
 */
@FragmentScope
@Component(modules = arrayOf(HomeModule::class), dependencies = arrayOf(AppComponent::class))
interface HomeComponent {
    fun inject(fragment: HomeFragment)
}
