package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.MyGroupModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.mine.MyGroupActivity


/**
 * Description:
 * <p>
 * Created by YangJie on 09/18/2020 17:15
 *
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(MyGroupModule::class), dependencies = arrayOf(AppComponent::class))
interface MyGroupComponent {
    fun inject(activity: MyGroupActivity)
}
