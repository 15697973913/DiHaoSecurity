package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.SelectMemberModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.mine.SelectMemberActivity


/**
 * Description:
 * <p>
 * Created by YangJie on 09/19/2020 11:30
 *
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(SelectMemberModule::class), dependencies = arrayOf(AppComponent::class))
interface SelectMemberComponent {
    fun inject(activity: SelectMemberActivity)
}
