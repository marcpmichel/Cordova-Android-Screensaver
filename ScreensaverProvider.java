package com.hughisaacs2.cordova.plugins.androidscreensaverplugin;

import android.annotation.TargetApi;
import android.content.Intent;
import android.service.dreams.DreamService;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import android.app.ActivityManager;
import android.os.Build;
import android.graphics.Color;
import android.content.Context;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;

@TargetApi(17)
public class ScreensaverProvider extends DreamService {
     @Override
     CordovaWebView cwv;
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        // Allow user touch
        setInteractive(true);
        // Hide system UI
        setFullscreen(true);
        // Set the dream layout

        WebView webView = new WebView(this);
        setContentView(webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setGeolocationEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAllowFileAccess(true);

        webView.loadUrl("file:///android_asset/www/screensaver.html");
    }
}
