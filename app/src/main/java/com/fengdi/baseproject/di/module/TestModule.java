package com.fengdi.baseproject.di.module;

import androidx.fragment.app.FragmentActivity;

import com.fengdi.baseproject.mvp.contract.UserContract;
import com.jess.arms.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.fengdi.baseproject.mvp.contract.TestContract;
import com.fengdi.baseproject.mvp.model.TestModel;
import com.tbruyelle.rxpermissions2.RxPermissions;


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 08/13/2020 17:38


 * ================================================
 */
@Module
public abstract class TestModule {

    @Binds
    abstract TestContract.Model bindTestModel(TestModel model);

    @ActivityScope
    @Provides
    static RxPermissions provideRxPermissions(TestContract.View view) {
        return new RxPermissions((FragmentActivity) view.getActivity());
    }
}