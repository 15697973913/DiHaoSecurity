package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.MineModule

import com.jess.arms.di.scope.FragmentScope
import com.fengdi.baseproject.mvp.ui.fragment.mine.MineFragment


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/07/2020 10:30
 

 * ================================================
 */
@FragmentScope
@Component(modules = arrayOf(MineModule::class), dependencies = arrayOf(AppComponent::class))
interface MineComponent {
    fun inject(fragment: MineFragment)
}
