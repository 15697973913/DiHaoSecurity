package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.home.DoorLockSettingContract
import com.fengdi.baseproject.mvp.model.home.DoorLockSettingModel


/**
 * Description:
 * <p>
 * Created by YangJie on 09/18/2020 16:01
 *
 * ================================================
 */
@Module
//构建DoorLockSettingModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class DoorLockSettingModule(private val view: DoorLockSettingContract.View) {
    @ActivityScope
    @Provides
    fun provideDoorLockSettingView(): DoorLockSettingContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideDoorLockSettingModel(model: DoorLockSettingModel): DoorLockSettingContract.Model {
        return model
    }
}
