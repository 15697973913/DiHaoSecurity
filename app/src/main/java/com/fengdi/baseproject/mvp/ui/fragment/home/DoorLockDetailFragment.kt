package com.fengdi.baseproject.mvp.ui.fragment.home

import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.jess.arms.base.BaseFragment
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.fengdi.baseproject.di.component.DaggerDoorLockDetailComponent
import com.fengdi.baseproject.di.module.DoorLockDetailModule
import com.fengdi.baseproject.mvp.contract.home.DoorLockDetailContract
import com.fengdi.baseproject.mvp.presenter.home.DoorLockDetailPresenter

import com.fengdi.baseproject.R
import com.fengdi.baseproject.app.entity.UnLockRecoardBean
import com.fengdi.baseproject.mvp.ui.activity.home.*
import com.fengdi.baseproject.mvp.ui.adapter.RemoteUnLockAdapter
import com.fengdi.baseproject.mvp.ui.adapter.UnLockRecordAdapter
import kotlinx.android.synthetic.main.activity_un_lock_authorize.*
import kotlinx.android.synthetic.main.fragment_door_lock_detail.*


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/09/2020 17:15


 * ================================================
 */
/**
 * 如果没presenter
 * 你可以这样写
 *
 * @FragmentScope(請注意命名空間) class NullObjectPresenterByFragment
 * @Inject constructor() : IPresenter {
 * override fun onStart() {
 * }
 *
 * override fun onDestroy() {
 * }
 * }
 */
class DoorLockDetailFragment : BaseFragment<DoorLockDetailPresenter>(), DoorLockDetailContract.View {
    companion object {
        fun newInstance(): DoorLockDetailFragment {
            val fragment = DoorLockDetailFragment()
            return fragment
        }
    }

    var remoteUnLockList = mutableListOf<UnLockRecoardBean>()

    var remoteUnLockAdapter = UnLockRecordAdapter(remoteUnLockList)


    override fun setupFragmentComponent(appComponent: AppComponent) {
        DaggerDoorLockDetailComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .doorLockDetailModule(DoorLockDetailModule(this))
                .build()
                .inject(this)
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_door_lock_detail, container, false);
    }

    override fun initData(savedInstanceState: Bundle?) {
        remoteUnLockList.add(UnLockRecoardBean("哈哈哈", 1, 1, "aaa", 0))
        remoteUnLockList.add(UnLockRecoardBean("哈哈哈", 1, 1, "aaa", 0))
        remoteUnLockList.add(UnLockRecoardBean("哈哈哈", 1, 1, "aaa", 0))
        remoteUnLockList.add(UnLockRecoardBean("哈哈哈", 1, 1, "aaa", 0))
        remoteUnLockList.add(UnLockRecoardBean("哈哈哈", 1, 1, "aaa", 0))
        remoteUnLockList.add(UnLockRecoardBean("哈哈哈", 1, 1, "aaa", 0))
        remoteUnLockList.add(UnLockRecoardBean("哈哈哈", 1, 1, "aaa", 0))
        remoteUnLockList.add(UnLockRecoardBean("哈哈哈", 1, 1, "aaa", 0))
        rcyUnLockRecord.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rcyUnLockRecord.adapter = remoteUnLockAdapter

        tvLiveVideo.setOnClickListener {
            //实时视频
            launchActivity(Intent(requireActivity(), VideoPlayerActivity::class.java))
        }


        tvUnlockAuthorize.setOnClickListener {
            //开锁授权
            launchActivity(Intent(requireActivity(), UnLockAuthorizeActivity::class.java))
        }


        tvRemoteUnlocking.setOnClickListener {
            //远程开锁
            launchActivity(Intent(requireActivity(), RemoteUnLockActivity::class.java))
        }

        tvPasswordManage.setOnClickListener {
            //密码管理
            launchActivity(Intent(requireActivity(), PassWordManageActivity::class.java))
        }

        tvAuthorizeManage.setOnClickListener {
            //密码管理
            launchActivity(Intent(requireActivity(), AuthorizeManageActivity::class.java))
        }

        tvDeviceGrouping.setOnClickListener {
            //设备分组
            launchActivity(Intent(requireActivity(), DeviceGroupActivity::class.java))
        }

        tvDoorLockSetting.setOnClickListener {
            //门锁设置
            launchActivity(Intent(requireActivity(), DoorLockSettingActivity::class.java))
        }




        tvHistoryVideo.setOnClickListener {
            //历史视频
            launchActivity(Intent(requireActivity(), HistoryVideoActivity::class.java))
        }


    }

    /**
     * 通过此方法可以使 Fragment 能够与外界做一些交互和通信, 比如说外部的 Activity 想让自己持有的某个 Fragment 对象执行一些方法,
     * 建议在有多个需要与外界交互的方法时, 统一传 {@link Message}, 通过 what 字段来区分不同的方法, 在 {@link #setData(Object)}
     * 方法中就可以 {@code switch} 做不同的操作, 这样就可以用统一的入口方法做多个不同的操作, 可以起到分发的作用
     * <p>
     * 调用此方法时请注意调用时 Fragment 的生命周期, 如果调用 {@link #setData(Object)} 方法时 {@link Fragment#onCreate(Bundle)} 还没执行
     * 但在 {@link #setData(Object)} 里却调用了 Presenter 的方法, 是会报空的, 因为 Dagger 注入是在 {@link Fragment#onCreate(Bundle)} 方法中执行的
     * 然后才创建的 Presenter, 如果要做一些初始化操作,可以不必让外部调用 {@link #setData(Object)}, 在 {@link #initData(Bundle)} 中初始化就可以了
     * <p>
     * Example usage:
     * <pre>
     *fun setData(data:Any) {
     *   if(data is Message){
     *       when (data.what) {
     *           0-> {
     *               //根据what 做你想做的事情
     *           }
     *           else -> {
     *           }
     *       }
     *   }
     *}
     *
     *
     *
     *
     *
     * // call setData(Object):
     * val data = Message();
     * data.what = 0;
     * data.arg1 = 1;
     * fragment.setData(data);
     * </pre>
     *
     * @param data 当不需要参数时 {@code data} 可以为 {@code null}
     */
    override fun setData(data: Any?) {

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

    }
}
