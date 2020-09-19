package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.home.UnLockAuthorizeContract
import com.fengdi.baseproject.mvp.model.home.UnLockAuthorizeModel


/**
 * Description:
 * <p>
 * Created by YangJie on 09/17/2020 17:22
 *
 * ================================================
 */
@Module
//构建UnLockAuthorizeModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class UnLockAuthorizeModule(private val view: UnLockAuthorizeContract.View) {
    @ActivityScope
    @Provides
    fun provideUnLockAuthorizeView(): UnLockAuthorizeContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideUnLockAuthorizeModel(model: UnLockAuthorizeModel): UnLockAuthorizeContract.Model {
        return model
    }
}
