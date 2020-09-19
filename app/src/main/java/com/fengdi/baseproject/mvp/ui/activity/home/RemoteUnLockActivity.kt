package com.fengdi.baseproject.mvp.ui.activity.home

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.fengdi.baseproject.R
import com.fengdi.baseproject.app.entity.RemoteUnLockBean
import com.fengdi.baseproject.di.component.DaggerRemoteUnLockComponent
import com.fengdi.baseproject.di.module.RemoteUnLockModule
import com.fengdi.baseproject.mvp.contract.home.RemoteUnLockContract
import com.fengdi.baseproject.mvp.presenter.home.RemoteUnLockPresenter
import com.fengdi.baseproject.mvp.ui.adapter.RemoteUnLockAdapter
import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils
import com.qmuiteam.qmui.skin.QMUISkinManager
import com.qmuiteam.qmui.widget.dialog.QMUIDialog
import com.qmuiteam.qmui.widget.dialog.QMUIDialog.MessageDialogBuilder
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction
import kotlinx.android.synthetic.main.activity_remote_un_lock.*
import kotlinx.android.synthetic.main.activity_un_lock_authorize.rcyAuthorizeRecord


/**
 * Description:远程开锁界面
 * <p>
 * Created by YangJie on 09/17/2020 18:48
 *
 * ================================================
 */
/**
 * 如果没presenter
 * 你可以这样写
 *
 * @ActivityScope(請注意命名空間) class NullObjectPresenterByActivity
 * @Inject constructor() : IPresenter {
 * override fun onStart() {
 * }
 *
 * override fun onDestroy() {
 * }
 * }
 */
class RemoteUnLockActivity : BaseActivity<RemoteUnLockPresenter>(), RemoteUnLockContract.View {

    var remoteUnLockList = mutableListOf<RemoteUnLockBean>()

    var remoteUnLockAdapter = RemoteUnLockAdapter(remoteUnLockList)

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerRemoteUnLockComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .remoteUnLockModule(RemoteUnLockModule(this))
                .build()
                .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_remote_un_lock //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        remoteUnLockList.add(RemoteUnLockBean("哈哈哈", 1, 1, "aaa", 0))
        remoteUnLockList.add(RemoteUnLockBean("哈哈哈", 1, 1, "aaa", 0))
        remoteUnLockList.add(RemoteUnLockBean("哈哈哈", 1, 1, "aaa", 0))
        remoteUnLockList.add(RemoteUnLockBean("哈哈哈", 1, 1, "aaa", 0))
        remoteUnLockList.add(RemoteUnLockBean("哈哈哈", 1, 1, "aaa", 0))
        remoteUnLockList.add(RemoteUnLockBean("哈哈哈", 1, 1, "aaa", 0))
        remoteUnLockList.add(RemoteUnLockBean("哈哈哈", 1, 1, "aaa", 0))
        remoteUnLockList.add(RemoteUnLockBean("哈哈哈", 1, 1, "aaa", 0))
        rcyAuthorizeRecord.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rcyAuthorizeRecord.adapter = remoteUnLockAdapter

        tvUnLock.setOnClickListener {
            MessageDialogBuilder(this)
                    .setTitle("温馨提示")
                    .setMessage("确定开锁吗？")
                    .setSkinManager(QMUISkinManager.defaultInstance(this))
                    .addAction("取消") { dialog, index -> dialog.dismiss() }
                    .addAction(0, "确定", QMUIDialogAction.ACTION_PROP_NEGATIVE) { dialog, index ->
                        Toast.makeText(this, "开锁成功", Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                    }
                    .create(R.style.QMUI_Dialog).show()
        }
        tvRefuse.setOnClickListener {
            MessageDialogBuilder(this)
                    .setTitle("温馨提示")
                    .setMessage("确定要拒绝吗？")
                    .setSkinManager(QMUISkinManager.defaultInstance(this))
                    .addAction("取消") { dialog, index -> dialog.dismiss() }
                    .addAction(0, "确定", QMUIDialogAction.ACTION_PROP_NEGATIVE) { dialog, index ->
                        Toast.makeText(this, "拒绝成功", Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                    }
                    .create(R.style.QMUI_Dialog).show()
        }
        callPolice.setOnClickListener {
            MessageDialogBuilder(this)
                    .setTitle("温馨提示")
                    .setMessage("确定要报警吗？")
                    .setSkinManager(QMUISkinManager.defaultInstance(this))
                    .addAction("取消") { dialog, index -> dialog.dismiss() }
                    .addAction(0, "确定", QMUIDialogAction.ACTION_PROP_NEGATIVE) { dialog, index ->
                        Toast.makeText(this, "报警成功", Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                    }
                    .create(R.style.QMUI_Dialog).show()
        }
        btViewVideo.setOnClickListener {
            //查看视频
            launchActivity(Intent(this, VideoPlayerActivity::class.java))
        }
    }


    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showMessage(message: String) {
        ArmsUtils.snackbarText(message)
    }

    override fun launchActivity(intent: Intent) {
        ArmsUtils.startActivity(intent)
    }

    override fun killMyself() {
        finish()
    }
}
