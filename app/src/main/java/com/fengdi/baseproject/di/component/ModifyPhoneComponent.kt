package com.fengdi.baseproject.di.component

import com.fengdi.baseproject.di.module.ModifyPhoneModule
import com.fengdi.baseproject.mvp.ui.activity.mine.ModifyPhoneActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component
import dagger.Module

@ActivityScope
@Component(modules = [ModifyPhoneModule::class], dependencies = [AppComponent::class])
interface ModifyPhoneComponent {
    fun inject(activity: ModifyPhoneActivity)
}