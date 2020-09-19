package com.fengdi.baseproject.di.module

import com.fengdi.baseproject.mvp.contract.mine.ModifyPhoneContract
import com.fengdi.baseproject.mvp.model.mine.ModifyPhoneModel
import com.jess.arms.di.scope.ActivityScope
import dagger.Module
import dagger.Provides


@Module
class ModifyPhoneModule(private val view: ModifyPhoneContract.View) {

    @ActivityScope
    @Provides
    fun provideModifyPhoneView(): ModifyPhoneContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideModifyPhoneModel(model: ModifyPhoneModel): ModifyPhoneContract.Model {
        return model
    }

}