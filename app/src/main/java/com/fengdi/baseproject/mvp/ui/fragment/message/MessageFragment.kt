package com.fengdi.baseproject.mvp.ui.fragment.message

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.jess.arms.base.BaseFragment
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.fengdi.baseproject.di.component.DaggerMessageComponent
import com.fengdi.baseproject.di.module.MessageModule
import com.fengdi.baseproject.mvp.contract.message.MessageContract
import com.fengdi.baseproject.mvp.presenter.message.MessagePresenter

import com.fengdi.baseproject.R
import com.fengdi.baseproject.mvp.ui.activity.message.*
import kotlinx.android.synthetic.main.fragment_message.*


/**
 * ================================================
 * Description:
 * <p>
 * Created by Yangjie on 09/07/2020 15:12


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
class MessageFragment : BaseFragment<MessagePresenter>(), MessageContract.View {
    companion object {
        fun newInstance(): MessageFragment {
            val fragment = MessageFragment()
            return fragment
        }
    }


    override fun setupFragmentComponent(appComponent: AppComponent) {
        DaggerMessageComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .messageModule(MessageModule(this))
                .build()
                .inject(this)
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    override fun initData(savedInstanceState: Bundle?) {
        linUnLockManage.setOnClickListener {
            //开锁消息
            launchActivity(Intent(requireActivity(), UnLockMessageActivity::class.java))
        }

        linAlertManage.setOnClickListener {
            //报警消息
            launchActivity(Intent(requireActivity(), AlertManageActivity::class.java))
        }

        linMaintenance.setOnClickListener {
//            维保消息
            launchActivity(Intent(requireActivity(), MaintenanceActivity::class.java))
        }

        linMyAlbum.setOnClickListener {
            //我的相册
            launchActivity(Intent(requireActivity(), MyAlbumActivity::class.java))
        }

        linMyVideo.setOnClickListener {
            //我的视频
            launchActivity(Intent(requireActivity(), MyVideoActivity::class.java))
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
