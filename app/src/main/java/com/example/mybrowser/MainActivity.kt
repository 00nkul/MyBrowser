package com.example.mybrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.URLUtil
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var myWebView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnSearch :Button = findViewById(R.id.btnSearch)
        var btnBack :Button = findViewById(R.id.btnBack)
        var btnYoutube :Button = findViewById(R.id.btnYoutube)
        var btnInsta :Button = findViewById(R.id.btnInsta)
        var btnFb :Button = findViewById(R.id.btnFb)
        var btnTwitter :Button = findViewById(R.id.btnTwitter)
        var btnHome :Button = findViewById(R.id.btnHome)

        var etUrl :EditText = findViewById(R.id.tvInputURL)
        myWebView = findViewById(R.id.webview)

        myWebView.webViewClient = WebViewClient()

        btnSearch.setOnClickListener{
            val url:String = etUrl.text.toString()

            if (URLUtil.isValidUrl(url)){
                myWebView.loadUrl(url)
            }
            else{
                myWebView.loadUrl("https://www.google.com/search?q=$url")
            }
        }

        btnFb.setOnClickListener{
                myWebView.loadUrl("https://www.facebook.com")
            etUrl.setText("https://www.facebook.com")

        }
        btnInsta.setOnClickListener{
            myWebView.loadUrl("https://www.instagram.com")
            etUrl.setText("https://www.instagram.com")

        }

        btnTwitter.setOnClickListener{
            myWebView.loadUrl("https://www.twitter.com")
            etUrl.setText("https://www.twitter.com")

        }

        btnYoutube.setOnClickListener{
            myWebView.loadUrl("https://www.youtube.com")
            etUrl.setText("https://www.youtube.com")

        }

        btnHome.setOnClickListener{
            myWebView.loadUrl("https://www.google.com")
            etUrl.setText("https://www.google.com")

        }

        btnBack.setOnClickListener{
            onBackPressed()
        }
        myWebView.settings.javaScriptEnabled = true
    }

    override fun onBackPressed() {
        if (myWebView.canGoBack()){
            myWebView.goBack()
        }
        else{
            super.onBackPressed()
        }
    }
}