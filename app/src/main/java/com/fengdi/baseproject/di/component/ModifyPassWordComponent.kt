package com.fengdi.baseproject.di.component

import com.fengdi.baseproject.di.module.ModifyPassWordModule
import com.fengdi.baseproject.mvp.ui.activity.mine.ModifyPassWordActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

@ActivityScope
@Component(modules = [ModifyPassWordModule::class], dependencies = [AppComponent::class])
interface ModifyPassWordComponent {
    fun inject(activity: ModifyPassWordActivity)
}