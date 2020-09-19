package com.fengdi.baseproject.mvp.model.message

import android.app.Application
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel

import com.jess.arms.di.scope.FragmentScope
import javax.inject.Inject

import com.fengdi.baseproject.mvp.contract.message.MessageContract


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/07/2020 15:12


 * ================================================
 */
@FragmentScope
class MessageModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), MessageContract.Model {
    @Inject
    lateinit var mGson: Gson;

    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy();
    }
}
