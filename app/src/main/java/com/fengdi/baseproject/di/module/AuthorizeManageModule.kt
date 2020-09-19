package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.home.AuthorizeManageContract
import com.fengdi.baseproject.mvp.model.home.AuthorizeManageModel


/**
 * Description:
 * <p>
 * Created by YangJie on 09/18/2020 14:50
 *
 * ================================================
 */
@Module
//构建AuthorizeManageModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class AuthorizeManageModule(private val view: AuthorizeManageContract.View) {
    @ActivityScope
    @Provides
    fun provideAuthorizeManageView(): AuthorizeManageContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAuthorizeManageModel(model: AuthorizeManageModel): AuthorizeManageContract.Model {
        return model
    }
}
