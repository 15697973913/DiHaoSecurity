package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.FragmentScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.home.DoorLockDetailContract
import com.fengdi.baseproject.mvp.model.home.DoorLockDetailModel


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/09/2020 17:15
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Module
 //构建DoorLockDetailModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class DoorLockDetailModule(private val view:DoorLockDetailContract.View) {
    @FragmentScope
    @Provides
    fun provideDoorLockDetailView():DoorLockDetailContract.View{
        return this.view
    }

    @FragmentScope
    @Provides
    fun provideDoorLockDetailModel(model:DoorLockDetailModel):DoorLockDetailContract.Model{
        return model
    }
}
