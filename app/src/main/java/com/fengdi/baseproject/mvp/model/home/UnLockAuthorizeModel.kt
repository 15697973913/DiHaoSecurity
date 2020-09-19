package com.fengdi.baseproject.mvp.model.home

import android.app.Application
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel

import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

import com.fengdi.baseproject.mvp.contract.home.UnLockAuthorizeContract


/**
 * Description:
 * <p>
 * Created by YangJie on 09/17/2020 17:22
 *
 * ================================================
 */
@ActivityScope
class UnLockAuthorizeModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), UnLockAuthorizeContract.Model {
    @Inject
    lateinit var mGson: Gson;

    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy();
    }
}
