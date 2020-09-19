package com.fengdi.baseproject.mvp.ui.fragment

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.fengdi.baseproject.R
import kotlinx.android.synthetic.main.fragment_test2.*


class Test2Fragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //设置缓存
        //LOAD_CACHE_ONLY: 不使用网络，只读取本地缓存数据。
        //
        //LOAD_DEFAULT: 根据cache-control决定是否从网络上取数据。
        //
        //LOAD_CACHE_NORMAL: API level 17中已经废弃，从API level 11开始作用同LOAD_DEFAULT模式
        //
        //LOAD_NO_CACHE: 不使用缓存，只从网络获取数据。
        //
        //LOAD_CACHE_ELSE_NETWORK，只要本地有，无论是否过期，或者no-cache，都使用缓存中的数据。本地没有缓存时才从网络上获取。
        //
        webShop.settings.cacheMode = WebSettings.LOAD_DEFAULT;

        //访问网页
        webShop.loadUrl("https://qmuiteam.com/android/documents")
        //系统默认会通过手机浏览器打开网页，为了能够直接通过WebView显示网页，则必须设置
        webShop.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                //使用WebView加载显示url
                view.loadUrl(url)
                //返回true
                return true
            }
        }

    }

}