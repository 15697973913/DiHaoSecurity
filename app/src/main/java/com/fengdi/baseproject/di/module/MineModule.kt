package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.FragmentScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.mine.MineContract
import com.fengdi.baseproject.mvp.model.mine.MineModel


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/07/2020 10:30
 

 * ================================================
 */
@Module
//构建MineModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class MineModule(private val view: MineContract.View) {
    @FragmentScope
    @Provides
    fun provideMineView(): MineContract.View {
        return this.view
    }

    @FragmentScope
    @Provides
    fun provideMineModel(model: MineModel): MineContract.Model {
        return model
    }
}
