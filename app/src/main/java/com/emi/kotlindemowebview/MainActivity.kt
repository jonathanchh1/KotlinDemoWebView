package com.emi.kotlindemowebview

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_main.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import javax.xml.parsers.DocumentBuilder


class MainActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webview : WebView = findViewById(R.id.webView)
        val websetting = webview.settings
         websetting.javaScriptEnabled = true
        webview.loadUrl(getString(R.string.website_domain))
        webview.webViewClient = ViewClient(this)
        WebView.setWebContentsDebuggingEnabled(false)

    }



    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if(keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()){
            webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}