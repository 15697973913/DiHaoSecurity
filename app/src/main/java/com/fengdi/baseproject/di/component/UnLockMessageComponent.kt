package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.UnLockMessageModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.message.UnLockMessageActivity


/**
 * Description:
 * <p>
 * Created by YangJie on 09/15/2020 14:25
 *
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(UnLockMessageModule::class), dependencies = arrayOf(AppComponent::class))
interface UnLockMessageComponent {
    fun inject(activity: UnLockMessageActivity)
}
