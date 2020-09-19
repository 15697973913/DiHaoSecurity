package com.fengdi.baseproject.mvp.model.home

import android.app.Application
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel

import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

import com.fengdi.baseproject.mvp.contract.home.HistoryVideoContract


/**
 * Description:
 * <p>
 * Created by YangJie on 09/18/2020 16:40
 *
 * ================================================
 */
@ActivityScope
class HistoryVideoModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), HistoryVideoContract.Model {
    @Inject
    lateinit var mGson: Gson;

    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy();
    }
}
