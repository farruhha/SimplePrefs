package com.wideinc.library.simpleprefs;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;

@SuppressWarnings("unused")
public final class SimplePrefs {

    private static SharedPreferences simplePreference;

    /**
     * Initialize the SimplePrefs using init method to save the preferences for this application
     * @param context application context to get preference for SharedPreference;
     * @param prefsName  uniquely identifiable name to your app. An easy way to do this is prefix the file name with your application ID.
     *                   it is used to name the shared preference file internally;
     * @param mode a mode to grant access for preference, MODE_PRIVATE, MODE_WORLD_READABLE or MODE_WORLD_WRITABLE;
     *             The MODE_WORLD_READABLE and MODE_WORLD_WRITABLE have been depreciated since API level 17;
     *             Starting with Android 7.0 (API level 24), Android throws a SecurityException if you use them;
     *             If your app needs to share private files with other apps,
     *             it may use a FileProvider with the FLAG_GRANT_READ_URI_PERMISSION
     */

    private static void init(Context context, String prefsName, int mode){
        simplePreference = context.getSharedPreferences(prefsName, mode);
    }

    public static SharedPreferences getPreference(){
        if (simplePreference != null){
            return simplePreference;
        }
        throw new RuntimeException("Simple Prefs instance not instantiated.Please call Builder().setContext().build() to instantiate SimplePrefs.");
    }


    public static final class Builder{
        private String prefsName;
        private int mode = Context.MODE_PRIVATE;
        private Context context;
        private boolean isDefaultUsed = false;

        /**
         * Set the filename of SimplePrefs name. It is packagename.xml by default but it can
         * be modified for various reasons;
         * @param prefsName a unique filename to describe the filename for shared preference;
         * @return the {@link com.wideinc.library.simpleprefs.SimplePrefs.Builder} object;
         */

        public Builder setPrefsName(String prefsName){
            this.prefsName = prefsName;
            return this;
        }

        /**
         * Set the context to initialize and get the reference for SharedPreference;
         * @param context an application context;
         * @return the {@link com.wideinc.library.simpleprefs.SimplePrefs.Builder} object;
         */

        public Builder setContext(Context context){
            this.context = context;
            return this;
        }

        /**
         * Set the mode for SharedPreference instance
         * @param mode an operate mode, use 0 or {@link Context#MODE_PRIVATE} to create a private filename.xml
         *             or {@link Context#MODE_WORLD_READABLE},{@link Context#MODE_WORLD_WRITEABLE} to create a public filename.xml which is accessible by other apps.
         *             However, the MODE_WORLD_READABLE and MODE_WORLD_WRITABLE have been depreciated since API level 17;
         * @see Context#getSharedPreferences(String, int)
         * @return the {@link com.wideinc.library.simpleprefs.SimplePrefs.Builder} object;
         */

        public Builder setMode(int mode){
            if (mode == ContextWrapper.MODE_PRIVATE || mode == ContextWrapper.MODE_WORLD_READABLE
                    || mode == ContextWrapper.MODE_WORLD_WRITEABLE || mode == ContextWrapper.MODE_MULTI_PROCESS){
                this.mode = mode;
            }else throw new RuntimeException("SharedPrefs mode can be set to ContextWrapper.MODE_PRIVATE, ContextWrapper.MODE_WORLD_READABLE, ContextWrapper.MODE_WRITABLE, ContextWrapper.MULTI-PROCESS");
            return this;
        }
        
    }
}
