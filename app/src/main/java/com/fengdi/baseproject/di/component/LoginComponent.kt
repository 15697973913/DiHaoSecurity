package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.LoginModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.login.LoginActivity



@ActivityScope
@Component(modules = arrayOf(LoginModule::class), dependencies = arrayOf(AppComponent::class))
interface LoginComponent {
    fun inject(activity: LoginActivity)

}
