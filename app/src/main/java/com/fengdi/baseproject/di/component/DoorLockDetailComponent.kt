package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.DoorLockDetailModule

import com.jess.arms.di.scope.FragmentScope
import com.fengdi.baseproject.mvp.ui.fragment.home.DoorLockDetailFragment


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/09/2020 17:15
 

 * ================================================
 */
@FragmentScope
@Component(modules = arrayOf(DoorLockDetailModule::class),dependencies = arrayOf(AppComponent::class))
interface DoorLockDetailComponent {
    fun inject(fragment:DoorLockDetailFragment)
}
