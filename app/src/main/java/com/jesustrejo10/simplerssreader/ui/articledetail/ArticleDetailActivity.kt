package com.jesustrejo10.simplerssreader.ui.articledetail

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import com.jesustrejo10.simplerssreader.R
import com.jesustrejo10.simplerssreader.ui.base.BaseActivity
import kotlinx.android.synthetic.main.article_detail_layout.*

class ArticleDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.article_detail_layout)
        manageViewComponents()
    }

    override fun manageViewComponents() {
        val url =intent.getStringExtra("URL") ?: return


        webView.settings.builtInZoomControls = false
        webView.settings.setSupportZoom(false)
        webView.settings.javaScriptCanOpenWindowsAutomatically = true
        webView.settings.allowFileAccess = true
        webView.settings.domStorageEnabled = true
        webView.settings.loadsImagesAutomatically = true
        webView.settings.javaScriptEnabled = true
        webView.settings.useWideViewPort = true
        webView.settings.loadWithOverviewMode = true
        webView.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY

        webView.webViewClient = WebViewClient()
        webView.loadUrl(url)
    }

    override fun manageObservers() {
    }
}