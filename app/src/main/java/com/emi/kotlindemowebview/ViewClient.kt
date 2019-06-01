package com.emi.kotlindemowebview

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.webkit.WebView
import android.webkit.WebViewClient




class ViewClient(private var context: Context) : WebViewClient(){

    override fun shouldOverrideUrlLoading(view: WebView?, url : String): Boolean {
        if(Uri.parse(url).host == context.getString(R.string.website_domain)){
            return false
        }

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
        return true
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
    }
}


