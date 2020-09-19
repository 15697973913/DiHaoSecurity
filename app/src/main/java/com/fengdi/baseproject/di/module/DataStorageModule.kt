package com.fengdi.baseproject.di.module

import com.fengdi.baseproject.mvp.contract.mine.DataStorageContrace
import com.fengdi.baseproject.mvp.model.mine.DataStorageModel
import com.jess.arms.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class DataStorageModule(private val view:DataStorageContrace.View){
    @ActivityScope
    @Provides
    fun providesDataStorageView():DataStorageContrace.View{
        return view
    }


    @ActivityScope
    @Provides
    fun providesDataStorageModel(model: DataStorageModel):DataStorageContrace.Model{
        return model
    }

}