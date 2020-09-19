package com.fengdi.baseproject.di.module

import com.fengdi.baseproject.mvp.contract.mine.ModifyPassWordContract
import com.fengdi.baseproject.mvp.model.mine.ModifyPassWordModel
import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

@Module
class ModifyPassWordModule(private val view: ModifyPassWordContract.View) {

    @ActivityScope
    @Provides
    fun provideModifyPassWordView(): ModifyPassWordContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideModifyPassWordModel(model: ModifyPassWordModel): ModifyPassWordContract.Model {
        return model
    }



}