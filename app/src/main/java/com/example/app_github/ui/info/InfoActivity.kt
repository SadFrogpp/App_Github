package com.example.app_github.ui.info

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebViewClient
import com.example.app_github.R
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        with(viewWeb){
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
        }
        intent?.extras?.getString("url")?.let {
            viewWeb.loadUrl(it)
        }
    }
}

