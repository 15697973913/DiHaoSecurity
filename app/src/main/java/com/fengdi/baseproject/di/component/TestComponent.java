package com.fengdi.baseproject.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.fengdi.baseproject.di.module.TestModule;
import com.fengdi.baseproject.mvp.contract.TestContract;

import com.jess.arms.di.scope.ActivityScope;
import com.fengdi.baseproject.mvp.ui.activity.TestActivity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 08/13/2020 17:38


 * ================================================
 */
@ActivityScope
@Component(modules = TestModule.class, dependencies = AppComponent.class)
public interface TestComponent {
    void inject(TestActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        TestComponent.Builder view(TestContract.View view);

        TestComponent.Builder appComponent(AppComponent appComponent);

        TestComponent build();
    }
}