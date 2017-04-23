package com.hughisaacs2.cordova.plugins.androidscreensaverplugin;

import android.annotation.TargetApi;
import android.service.dreams.DreamService;
import android.webkit.WebView;
import org.apache.cordova.*;

@TargetApi(17)
public class ScreensaverProvider extends DreamService {
     @Override
     CordovaWebView cwv;
    public void onAttachedToWindow() {
        //super.onAttachedToWindow();
        // Allow user touch
        //setInteractive(true);
        // Hide system UI
        //setFullscreen(true);
        // Set the dream layout
        //WebView webView = new WebView(this);
        //setContentView(webView);
        //webView.loadUrl("file:///android_asset/www/screensaver.html");
         
        super.onAttachedToWindow();
        // Allow user touch
        setInteractive(true);
        // Hide system UI
        setFullscreen(true);
        // Set the dream layout
		cwv webview = new CordovaWebView(this);
		org.apache.cordova.Config.init(this);
        setContentView(cwv);
        cwv.loadUrl(Config.getStartUrl());
    }
}
