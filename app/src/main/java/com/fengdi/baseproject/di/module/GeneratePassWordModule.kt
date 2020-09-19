package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.GeneratePassWordContract
import com.fengdi.baseproject.mvp.model.GeneratePassWordModel


/**
 * Description:
 * <p>
 * Created by YangJie on 09/19/2020 14:29
 *
 * ================================================
 */
@Module
//构建GeneratePassWordModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class GeneratePassWordModule(private val view: GeneratePassWordContract.View) {
    @ActivityScope
    @Provides
    fun provideGeneratePassWordView(): GeneratePassWordContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideGeneratePassWordModel(model: GeneratePassWordModel): GeneratePassWordContract.Model {
        return model
    }
}
