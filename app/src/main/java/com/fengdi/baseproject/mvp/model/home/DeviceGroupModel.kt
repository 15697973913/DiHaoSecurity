package com.fengdi.baseproject.mvp.model.home

import android.app.Application
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel

import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

import com.fengdi.baseproject.mvp.contract.home.DeviceGroupContract


/**
 * Description:
 * <p>
 * Created by YangJie on 09/18/2020 15:26
 *
 * ================================================
 */
@ActivityScope
class DeviceGroupModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), DeviceGroupContract.Model {
    @Inject
    lateinit var mGson: Gson;

    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy();
    }
}
