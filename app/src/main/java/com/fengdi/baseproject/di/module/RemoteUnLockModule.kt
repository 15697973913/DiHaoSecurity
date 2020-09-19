package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.home.RemoteUnLockContract
import com.fengdi.baseproject.mvp.model.home.RemoteUnLockModel


/**
 * Description:
 * <p>
 * Created by YangJie on 09/17/2020 18:48
 *
 * ================================================
 */
@Module
//构建RemoteUnLockModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class RemoteUnLockModule(private val view: RemoteUnLockContract.View) {
    @ActivityScope
    @Provides
    fun provideRemoteUnLockView(): RemoteUnLockContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideRemoteUnLockModel(model: RemoteUnLockModel): RemoteUnLockContract.Model {
        return model
    }
}
