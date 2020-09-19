package com.fengdi.baseproject.di.module

import androidx.fragment.app.FragmentActivity
import com.fengdi.baseproject.mvp.contract.MainContract
import com.fengdi.baseproject.mvp.contract.UserContract
import com.fengdi.baseproject.mvp.model.MainModel
import com.jess.arms.di.scope.ActivityScope
import com.tbruyelle.rxpermissions2.RxPermissions
import dagger.Module
import dagger.Provides


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/05/2020 17:57
 

 * ================================================
 */
@Module
//构建MainModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class MainModule(private val view: MainContract.View) {
    @ActivityScope
    @Provides
    fun provideMainView(): MainContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideMainModel(model: MainModel): MainContract.Model {
        return model
    }

    @ActivityScope
    @Provides
    fun provideRxPermissions(view: MainContract.View): RxPermissions {
        return RxPermissions((view.getActivity() as FragmentActivity))
    }
}
