package com.fengdi.baseproject.mvp.ui.fragment.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.fengdi.baseproject.R
import com.fengdi.baseproject.app.callback.MyOnItemClickListener
import com.fengdi.baseproject.di.component.DaggerHomeComponent
import com.fengdi.baseproject.di.module.HomeModule
import com.fengdi.baseproject.mvp.contract.home.HomeContract
import com.fengdi.baseproject.app.entity.MonitorBean
import com.fengdi.baseproject.app.entity.SmartLockBean
import com.fengdi.baseproject.mvp.presenter.home.HomePresenter
import com.fengdi.baseproject.mvp.ui.activity.home.DoorLockManageActivity
import com.fengdi.baseproject.mvp.ui.activity.home.MonitorManageActivity
import com.fengdi.baseproject.mvp.ui.activity.home.VideoPlayerActivity
import com.fengdi.baseproject.mvp.ui.adapter.MonitorAdapter
import com.fengdi.baseproject.mvp.ui.adapter.SmartLockAdapter
import com.jess.arms.base.BaseFragment
import com.jess.arms.base.DefaultAdapter
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils
import com.qmuiteam.qmui.layout.QMUIFrameLayout
import com.qmuiteam.qmui.skin.QMUISkinManager
import com.qmuiteam.qmui.util.QMUIDisplayHelper
import com.qmuiteam.qmui.widget.popup.QMUIFullScreenPopup
import com.qmuiteam.qmui.widget.popup.QMUIPopups
import kotlinx.android.synthetic.main.dialog_device_manage.view.*
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/07/2020 16:27
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
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
class HomeFragment : BaseFragment<HomePresenter>(), HomeContract.View {

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager


    /**
     * 智能锁列表
     */
    @Inject
    lateinit var smartLockList: MutableList<SmartLockBean>

    /**
     * 监控设备列表
     */
    @Inject
    lateinit var monitorList: MutableList<MonitorBean>


    /**
     * 智能锁Adapter
     */
    @Inject
    lateinit var smartLockAdapter: SmartLockAdapter


    /**
     * 监控Adapter
     */
    @Inject
    lateinit var monitorAdapter: MonitorAdapter



    private lateinit var popup: QMUIFullScreenPopup

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }


    override fun setupFragmentComponent(appComponent: AppComponent) {
        DaggerHomeComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .homeModule(HomeModule(this))
                .build()
                .inject(this)
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    override fun initData(savedInstanceState: Bundle?) {
        smartLockList.add(SmartLockBean("厨房", 1, 212, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1599546968539&di=9c5e2a6706ce8a50972f43efd3f2c950&imgtype=0&src=http%3A%2F%2Fgoods.tiaodao.com%2Fimage%2Fcache%2Fcatalog%2F20170330%2F112-2048x2048.jpg", 1))
        smartLockList.add(SmartLockBean("厕所", 0, 2212, "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3617443108,3467474169&fm=26&gp=0.jpg", 1))
        smartLockList.add(SmartLockBean("公司", 0, 2152, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1599547002796&di=11762fdfc28bb0940941c61312b12b89&imgtype=0&src=http%3A%2F%2Fimg1.imgtn.bdimg.com%2Fit%2Fu%3D2222959491%2C4153852580%26fm%3D214%26gp%3D0.jpg", 0))

        rcySmartLock.layoutManager = linearLayoutManager

        rcySmartLock.adapter = smartLockAdapter
        smartLockAdapter.setOnItemClickListener { view, viewType, data, position ->
            //跳转到播放界面
            launchActivity(Intent(requireActivity(), DoorLockManageActivity::class.java))
        }


        monitorList.add(MonitorBean(1, 1, "厨房", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1599546968539&di=9c5e2a6706ce8a50972f43efd3f2c950&imgtype=0&src=http%3A%2F%2Fgoods.tiaodao.com%2Fimage%2Fcache%2Fcatalog%2F20170330%2F112-2048x2048.jpg"))
        monitorList.add(MonitorBean(2, 1, "厕所", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3617443108,3467474169&fm=26&gp=0.jpg"))
        monitorList.add(MonitorBean(3, 0, "公司", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1599547002796&di=11762fdfc28bb0940941c61312b12b89&imgtype=0&src=http%3A%2F%2Fimg1.imgtn.bdimg.com%2Fit%2Fu%3D2222959491%2C4153852580%26fm%3D214%26gp%3D0.jpg"))

        rcyMonitor.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rcyMonitor.adapter = monitorAdapter.also {
            it.setOnItemClickListener { view, viewType, data, position ->
                when (view.id) {
                    R.id.ivMore -> {
                        showDevideManagePopup()
                    }
                    else -> {
                        //跳转到播放界面
                        launchActivity(Intent(requireActivity(), VideoPlayerActivity::class.java))
                    }
                }
            }
        }


        gbDeviceType.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rbSmartLock -> {
                    rcySmartLock.visibility = View.VISIBLE
                    rcyMonitor.visibility = View.GONE
                }
                R.id.rbMonitor -> {
                    rcySmartLock.visibility = View.GONE
                    rcyMonitor.visibility = View.VISIBLE
                }
            }
        }
    }

    //显示设备管理对话框
    fun showDevideManagePopup() {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_device_manage, null, false)

        val frameLayout = QMUIFrameLayout(context)
        //设置圆角
        frameLayout.radius = QMUIDisplayHelper.dp2px(context, 12)

        dialogView.tvDeviceDetail.setOnClickListener {
            //调整到设备详情对话框
            launchActivity(Intent(requireActivity(), MonitorManageActivity::class.java))

            popup.dismiss()
        }

        //设置宽高
        val lp = FrameLayout.LayoutParams(QMUIDisplayHelper.dp2px(context, 350), QMUIDisplayHelper.dp2px(context, 200))
        frameLayout.addView(dialogView, lp)

        //创建PopupWindow
        popup = QMUIPopups.fullScreenPopup(context)
                .addView(frameLayout)
                .closeBtn(false)
                .skinManager(QMUISkinManager.defaultInstance(context))
                .onBlankClick {
                    popup.dismiss()
                }

        popup.show(view)

    }

    /**
     * 设置数据
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
