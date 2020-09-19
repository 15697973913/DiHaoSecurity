package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.AddGroupModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.mine.AddGroupActivity


/**
 * Description:
 * <p>
 * Created by YangJie on 09/19/2020 10:37
 *
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(AddGroupModule::class), dependencies = arrayOf(AppComponent::class))
interface AddGroupComponent {
    fun inject(activity: AddGroupActivity)
}
