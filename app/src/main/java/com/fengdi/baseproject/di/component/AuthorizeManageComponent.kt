package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.AuthorizeManageModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.home.AuthorizeManageActivity


/**
 * Description:
 * <p>
 * Created by YangJie on 09/18/2020 14:50
 *
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(AuthorizeManageModule::class), dependencies = arrayOf(AppComponent::class))
interface AuthorizeManageComponent {
    fun inject(activity: AuthorizeManageActivity)
}
