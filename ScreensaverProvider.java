package com.hughisaacs2.cordova.plugins.androidscreensaverplugin;

import android.annotation.TargetApi;
import android.service.dreams.DreamService;
import android.webkit.WebView;
import android.content.Intent;

@TargetApi(19)
public class ScreensaverProvider extends DreamService {
     @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setInteractive(true); // Allow user touch
        // Hide system UI
        setFullscreen(true);
        // Set the dream layout
        WebView webView = new WebView(this);
         
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        setContentView(webView);
        webView.loadUrl("file:///android_asset/www/screensaver.html");
    }

    public void onDreamingStarted() {
		// start main activity
		Intent intentDream = new Intent(Intent.ACTION_MAIN);
		intentDream.setClassName("com.deepidoo.dream", "com.deepidoo.dream.MainActivity");
		startActivity(intentDream);
		finish(); // terminates the Dream
    }
}
