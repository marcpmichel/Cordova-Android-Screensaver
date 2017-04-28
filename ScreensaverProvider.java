package com.hughisaacs2.cordova.plugins.androidscreensaverplugin;

import android.annotation.TargetApi;
import android.service.dreams.DreamService;
import android.webkit.WebView;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;

@TargetApi(17)
public class ScreensaverProvider extends DreamService {
     @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        // Allow user touch
        setInteractive(true);
        // Hide system UI
        setFullscreen(true);
        // Set the dream layout
        WebView webView = new WebView(this);
         
        webView.getSettings().setJavaScriptEnabled(true);
        //webView.getSettings().setGeolocationEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        //webView.getSettings().setAllowFileAccess(true);
        setContentView(webView);
        webView.loadUrl("file:///android_asset/www/screensaver.html");
    }
}
