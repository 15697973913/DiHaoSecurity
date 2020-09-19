package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.mine.ServiceCenterContract
import com.fengdi.baseproject.mvp.model.mine.ServiceCenterModel


/**
 * Description:
 * <p>
 * Created by YangJie on 09/18/2020 17:56
 *
 * ================================================
 */
@Module
//构建ServiceCenterModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class ServiceCenterModule(private val view: ServiceCenterContract.View) {
    @ActivityScope
    @Provides
    fun provideServiceCenterView(): ServiceCenterContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideServiceCenterModel(model: ServiceCenterModel): ServiceCenterContract.Model {
        return model
    }
}
