package com.example.a4fitness_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class activity_webview_recepies : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_webview_recipes)

            val webView: WebView = findViewById(R.id.webView_recipes)
            webView.loadUrl("https://anacostache479.wixsite.com/4fitness/blog/categories/recipes")
    }
}