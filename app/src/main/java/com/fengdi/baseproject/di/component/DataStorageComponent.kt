package com.fengdi.baseproject.di.component

import com.fengdi.baseproject.di.module.DataStorageModule
import com.fengdi.baseproject.mvp.ui.activity.mine.DataStorageActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

@ActivityScope
@Component(modules = [DataStorageModule::class], dependencies = [AppComponent::class])
interface DataStorageComponent {
    fun inject(activity: DataStorageActivity)

}