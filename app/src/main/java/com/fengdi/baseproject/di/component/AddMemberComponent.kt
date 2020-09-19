package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.AddMemberModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.mine.AddMemberActivity


/**
 * Description:
 * <p>
 * Created by YangJie on 09/19/2020 11:41
 *
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(AddMemberModule::class), dependencies = arrayOf(AppComponent::class))
interface AddMemberComponent {
    fun inject(activity: AddMemberActivity)
}
