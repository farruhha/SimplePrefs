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
        int myid = SimplePrefs.getInt("myid", 384);
        String myusername = SimplePrefs.getString("username");
    }
}
