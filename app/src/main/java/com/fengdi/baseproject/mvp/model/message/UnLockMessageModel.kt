package com.fengdi.baseproject.mvp.model.message

import android.app.Application
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel

import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

import com.fengdi.baseproject.mvp.contract.message.UnLockMessageContract


/**
 * Description:
 * <p>
 * Created by YangJie on 09/15/2020 14:25
 *
 * ================================================
 */
@ActivityScope
class UnLockMessageModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), UnLockMessageContract.Model {
    @Inject
    lateinit var mGson: Gson;

    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy();
    }
}
