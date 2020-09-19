package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.mine.MyDataContract
import com.fengdi.baseproject.mvp.model.mine.MyDataModel


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/11/2020 16:29
 

 * ================================================
 */
@Module
//构建MyDataModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class MyDataModule(private val view: MyDataContract.View) {
    @ActivityScope
    @Provides
    fun provideMyDataView(): MyDataContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideMyDataModel(model: MyDataModel): MyDataContract.Model {
        return model
    }
}
