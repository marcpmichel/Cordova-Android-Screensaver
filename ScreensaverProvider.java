package com.hughisaacs2.cordova.plugins.androidscreensaverplugin;

import android.annotation.TargetApi;
import android.service.dreams.DreamService;
import android.webkit.WebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.*;

@TargetApi(17)
public class ScreensaverProvider extends DreamService implements CordovaInterface {
     @Override
     CordovaWebView cwv;
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        // Allow user touch
        setInteractive(true);
        // Hide system UI
        setFullscreen(true);
        // Set the dream layout
	
        setContentView(R.layout.cordova_screen_saver);
        cwv = (CordovaWebView) findViewById(R.id.CordovaScreenSaverWebView);

        String screenSaverIndex = preferences.getString("ScreenSaverIndex", "index.html");
        cwv.loadUrl(screenSaverIndex);
    }
}
