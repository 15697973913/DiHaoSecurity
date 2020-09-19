package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.home.DeviceGroupContract
import com.fengdi.baseproject.mvp.model.home.DeviceGroupModel


/**
 * Description:
 * <p>
 * Created by YangJie on 09/18/2020 15:26
 *
 * ================================================
 */
@Module
//构建DeviceGroupModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class DeviceGroupModule(private val view: DeviceGroupContract.View) {
    @ActivityScope
    @Provides
    fun provideDeviceGroupView(): DeviceGroupContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideDeviceGroupModel(model: DeviceGroupModel): DeviceGroupContract.Model {
        return model
    }
}
