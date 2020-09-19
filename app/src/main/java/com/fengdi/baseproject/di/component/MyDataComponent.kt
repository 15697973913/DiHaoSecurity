package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.MyDataModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.mine.MyDataActivity


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/11/2020 16:29


 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(MyDataModule::class), dependencies = arrayOf(AppComponent::class))
interface MyDataComponent {
    fun inject(activity: MyDataActivity)
}
