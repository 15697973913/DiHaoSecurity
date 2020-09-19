package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.login.RejesterContract
import com.fengdi.baseproject.mvp.model.login.RejesterModel


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/11/2020 14:22


 * ================================================
 */
@Module
//构建RejesterModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class RejesterModule(private val view: RejesterContract.View) {
    @ActivityScope
    @Provides
    fun provideRejesterView(): RejesterContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideRejesterModel(model: RejesterModel): RejesterContract.Model {
        return model
    }
}
