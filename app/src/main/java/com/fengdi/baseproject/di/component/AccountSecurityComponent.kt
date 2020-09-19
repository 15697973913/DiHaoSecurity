package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.AccountSecurityModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.mine.AccountSecurityActivity


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/11/2020 17:46


 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(AccountSecurityModule::class), dependencies = arrayOf(AppComponent::class))
interface AccountSecurityComponent {
    fun inject(activity: AccountSecurityActivity)
}
