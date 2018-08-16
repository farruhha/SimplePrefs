package com.wideinc.library.simpleprefs;

import android.app.Activity;
import android.content.ContextWrapper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SimplePrefExample extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new SimplePrefs.Builder()
                .setPrefsName("myapppreference")
                .setContext(this)
                .setMode(MODE_PRIVATE)
                .setDefaultUse(false)
                .build();
    }
}
