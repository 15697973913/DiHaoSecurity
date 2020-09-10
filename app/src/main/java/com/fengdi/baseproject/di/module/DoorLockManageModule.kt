package com.fengdi.baseproject.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.fengdi.baseproject.mvp.contract.home.DoorLockManageContract
import com.fengdi.baseproject.mvp.model.home.DoorLockManageModel


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/09/2020 17:19
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Module
//构建DoorLockManageModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class DoorLockManageModule(private val view: DoorLockManageContract.View) {
    @ActivityScope
    @Provides
    fun provideDoorLockManageView(): DoorLockManageContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideDoorLockManageModel(model: DoorLockManageModel): DoorLockManageContract.Model {
        return model
    }
}
