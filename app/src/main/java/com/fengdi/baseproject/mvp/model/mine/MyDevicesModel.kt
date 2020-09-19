package com.fengdi.baseproject.mvp.model.mine

import android.app.Application
import com.bumptech.glide.RequestManager
import com.fengdi.baseproject.mvp.contract.mine.MyDevicesContrace
import com.google.gson.Gson
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import javax.inject.Inject


@ActivityScope
class MyDevicesModel
@Inject
constructor(repositoryManager: IRepositoryManager):
        BaseModel(repositoryManager), MyDevicesContrace.Model{

    @Inject
    lateinit var mGson: Gson;

    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy();
    }

}