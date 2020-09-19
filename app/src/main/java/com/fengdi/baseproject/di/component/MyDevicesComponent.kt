package com.fengdi.baseproject.di.component

import com.fengdi.baseproject.di.module.MyDevicesModule
import com.fengdi.baseproject.mvp.ui.activity.mine.MyDevicesActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component
import dagger.Module

@ActivityScope
@Component(modules = [MyDevicesModule::class], dependencies = [AppComponent::class])
interface MyDevicesComponent {

    fun inject(activity: MyDevicesActivity)

}