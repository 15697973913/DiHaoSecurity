package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.GeneratePassWordModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.GeneratePassWordActivity


/**
 * Description:
 * <p>
 * Created by YangJie on 09/19/2020 14:29
 *
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(GeneratePassWordModule::class), dependencies = arrayOf(AppComponent::class))
interface GeneratePassWordComponent {
    fun inject(activity: GeneratePassWordActivity)
}
