package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.home.AddDeviceContract
import com.fengdi.baseproject.mvp.model.home.AddDeviceModel


/**
 * Description:
 * <p>
 * Created by YangJie on 09/17/2020 11:16
 *
 * ================================================
 */
@Module
//构建AddDeviceModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class AddDeviceModule(private val view: AddDeviceContract.View) {
    @ActivityScope
    @Provides
    fun provideAddDeviceView(): AddDeviceContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAddDeviceModel(model: AddDeviceModel): AddDeviceContract.Model {
        return model
    }
}
