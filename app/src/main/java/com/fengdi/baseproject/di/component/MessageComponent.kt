package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.MessageModule

import com.jess.arms.di.scope.FragmentScope
import com.fengdi.baseproject.mvp.ui.fragment.message.MessageFragment


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/07/2020 15:12
 

 * ================================================
 */
@FragmentScope
@Component(modules = arrayOf(MessageModule::class), dependencies = arrayOf(AppComponent::class))
interface MessageComponent {
    fun inject(fragment: MessageFragment)
}
