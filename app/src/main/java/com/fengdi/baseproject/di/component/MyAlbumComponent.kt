package com.fengdi.baseproject.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.fengdi.baseproject.di.module.MyAlbumModule

import com.jess.arms.di.scope.ActivityScope
import com.fengdi.baseproject.mvp.ui.activity.message.MyAlbumActivity


/**
 * Description:
 * <p>
 * Created by YangJie on 09/16/2020 16:11
 *
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(MyAlbumModule::class), dependencies = arrayOf(AppComponent::class))
interface MyAlbumComponent {
    fun inject(activity: MyAlbumActivity)
}
