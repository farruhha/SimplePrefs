package com.wideinc.library.simpleprefs;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.content.SharedPreferences.Editor;

import java.util.Map;

@SuppressWarnings("unused")
public final class SimplePrefs {

    private static final String DEFAULT_SUFFIX = "_simple_preferences";
    private static final String LENGTH = "#LENGTH";
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

    /**
     * instantiate basic SharedPreference class;
     * @return instance of sharedPreference;
     * @throws RuntimeException if simplePreference is not instantiated
     */
    @SuppressWarnings("WeakerAccess")
    public static SharedPreferences getPreference(){
        if (simplePreference != null){
            return simplePreference;
        }
        throw new RuntimeException("Simple Prefs instance not instantiated.Please call Builder().setContext().build() to instantiate SimplePrefs.");
    }

    /**
     * @return  a map that contains all the key value pairs saved in the preference
     * @see SharedPreferences#getAll()
     */
    public static Map<String,?> getAll(){
        return getPreference().getAll();
    }

    /**
     * Return int value for key from preference;
     * @param key name of the preference to retrieve;
     * @param defValue default value if the value does not exist;
     * @return preference value if it exists or default value;
     * @throws ClassCastException if the value exists but not int type
     * @see android.content.SharedPreferences#getInt(String, int);
     */

    public static int getInt(final String key, final int defValue){
        return getPreference().getInt(key,defValue);
    }

    /**
     * Retrieve the saved int value if the key exists or 0 if the key does not exist
     * @param key the name of preference to retrieve
     * @return retrieves the value of preference if it exists or 0
     * @throws ClassCastException if the key exists with this name but its value is not int
     * @see SharedPreferences#getInt(String, int)
     */
    public static int getInt(final String key){
        return getPreference().getInt(key,0);
    }

    /**
     * Retrieves a saved boolean value
     * @param key key of preference to retrieve
     * @param defValue value to return, if the key does not exist
     * @return preference value if it exists or defValue if it does not.
     * @throws ClassCastException if there is a preference with this name that is not a boolean.
     * @see android.content.SharedPreferences#getBoolean(String, boolean)
     */
    public static boolean getBoolean(final String key, final boolean defValue){
        return getPreference().getBoolean(key,defValue);
    }

    /** return the value of the preference if it exists, or return false;
     *
     * @param key name of the preference to return
     * @return preference value if it exists or false it does not exist
     * @throws ClassCastException if there is a preference with this name that is not a boolean.
     * @see android.content.SharedPreferences#getBoolean(String, boolean)
     */
    public static boolean getBoolean(final String key){
       return getPreference().getBoolean(key,false);
    }

    /**
     * Retrieve saved long value if it exists or defValue
     * @param key name of preference to retrieve
     * @param defValue value if the preference does not exist
     * @return preference value if it exist or defValue
     * @throws ClassCastException if there is a preference with this name that is not a long.
     * @see android.content.SharedPreferences#getLong(String, long)
     */
    public static long getLong(final String key, final int defValue){
        return getPreference().getLong(key, defValue);
    }

    /**
     * Retrieve saved long value if it exists or 0
     * @param key name of preference to retrieve
     * @return preference value if it exist or 0
     * @throws ClassCastException if there is a preference with this name that is not a long.
     * @see android.content.SharedPreferences#getLong(String, long)
     */

    public static long getLong(final String key){
        return getPreference().getLong(key,0L);
    }

    /**
     * returns the double that has been saved as long raw bits in long preference
     * @param key name of preference to retrieve
     * @param defValue value to return if the preference does not exist
     * @return double value that has been saved as long raw bits or default if the preference does not exist
     * @throws ClassCastException if there is a preference with this name that is not a long.
     * @see android.content.SharedPreferences#getLong(String, long)
     */
    public static double getDouble(final String key, final double defValue){
        return Double.longBitsToDouble(getPreference().getLong(key,Double.doubleToLongBits(defValue)));
    }

    /**
     * Retrieve the double that has been saved as long raw bits in long preference
     * return 0 if the preference does not exist
     * @param key name of preference to retrieve
     * @return double value that has been saved as long raw bits or default if the preference does not exist
     * @throws ClassCastException if there is a preference with this name that is not a long.
     * @see android.content.SharedPreferences#getLong(String, long)
     */
    public static double getDouble(final String key){
        return Double.longBitsToDouble(getPreference().getLong(key,Double.doubleToLongBits(0.0d)));
    }


    /**
     * Retrieve saved float value
     * @param key name of the preference to retrieve
     * @param defValue value to return if the preference does not exist
     * @return returns preference value if it exists or defValue if it does not exists
     * @throws ClassCastException if there is a preference with this name that is not a float.
      * @see android.content.SharedPreferences#getFloat(String, float)
     */
    public static float getFloat(final String key, final float defValue){
        return getPreference().getFloat(key, defValue);
    }

    /**
     * Retrieve saved float value if it exists or 0
     * @param key name of the preference to retrieve
     * @return return preference value or 0 if it does not exist
     * @throws ClassCastException if there is a preference with this name that is not a float.
     * @see android.content.SharedPreferences#getFloat(String, float)
     */
    public static float getFloat(final String key){
        return getPreference().getFloat(key,0.0f);
    }

    /**
     * Retrieve the saved String value
     * @param key name of the preference to retrieve
     * @param defValue value to return if the preference does not exist
     * @return saved String value or defValue if it does not exist;
     * @throws ClassCastException if there is a preference with this name that is not a String.
     * @see android.content.SharedPreferences#getString(String, String)
     */
    public static String getString(final String key, final String defValue){
        return getPreference().getString(key,defValue);
    }


    /**
     * Retrieve the saved String value
     * @param key name of the preference to retrieve
     * @return saved String value or emptyString if it does not exist;
     * @throws ClassCastException if there is a preference with this name that is not a String.
     * @see android.content.SharedPreferences#getString(String, String)
     */
    public static String getString(final String key){
        return getPreference().getString(key,"");
    }


    /**
     * Save long value for preference
     * @param key name of preference to save or modify
     * @param value new value of preference to save
     * @see android.content.SharedPreferences.Editor#putLong(String, long)
     */
    public static void putLong(final String key, final long value){
        final Editor editor = getPreference().edit();
        editor.putLong(key,value);
        editor.apply();
    }
    /**
     * Save int value for preference
     * @param key name of preference to save or modify
     * @param value new value of preference to save
     * @see android.content.SharedPreferences.Editor#putInt(String, int)
     */

    public static void putInt(final String key, final int value){
        final Editor editor = getPreference().edit();
        editor.putInt(key,value);
        editor.apply();
    }

    /**
     * Save long value as long raw bits value
     * @param key name of preference to save or modify
     * @param value new value of preference to save
     * @see android.content.SharedPreferences.Editor#putLong(String, long)
     */

    public static void putDouble(final String key, final double value){
        final Editor editor = getPreference().edit();
        editor.putLong(key, Double.doubleToLongBits(value));
        editor.apply();
    }

    /**
     * Save float value for preference
     * @param key name of preference to save or modify
     * @param value new value of preference to save
     * @see android.content.SharedPreferences.Editor#putFloat(String, float)
     */
    public static void putFloat(final String key, final float value){
        final Editor editor = getPreference().edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    /**
     * Save string value for preference
     * @param key name of preference to save or modify
     * @param value new value of preference to save
     * @see android.content.SharedPreferences.Editor#putString(String, String)
     */
    public static void putString(final String key, final String value){
        final Editor editor = getPreference().edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * Save boolean value for preference
     * @param key name of preference to save or modify
     * @param value new value of preference to save
     * @see android.content.SharedPreferences.Editor#putBoolean(String, boolean)
     */
    public static void putBoolean(final String key, final boolean value){
        final Editor editor = getPreference().edit();
        editor.putBoolean(key, value);
        editor.apply();
    }


    /**
     * Check if a value is stored for the given key
     * @param key name of the preference
     * @return {@code true} if the preference exists or {@code false};
     * @see android.content.SharedPreferences#contains(String)
     */
    public static boolean contains(final String key){
        return getPreference().contains(key);
    }


    /**
     * Removes all the saved key and value pairs from preference
     * @return editor
     * @see android.content.SharedPreferences.Editor#clear()
     */
    public static Editor clear(){
        final Editor editor = getPreference().edit().clear();
        editor.apply();
        return editor;
    }

    /**
     * Returns editor for underlying shared preference
     * @return editor
     */
    public static Editor edit(){
        return getPreference().edit();
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

        /**
         * Set whether default shared preference name should be used for filename of preference file or user defined name should be used;
         * @param isDefaultUsed if isDefaultUsed is true, default shared preference should be used usually
         *                      a specific fragment or activity package name is used for default filename;
         *
         * @return the {@link com.wideinc.library.simpleprefs.SimplePrefs.Builder} object;
         */
        @SuppressWarnings("SameValueUsed")
        public Builder setDefaultUse(boolean isDefaultUsed){
            this.isDefaultUsed = isDefaultUsed;
            return this;
        }

        /**
         * Initialize the preference instance
         * @throws RuntimeException if context is null or not set
         */

        public void build(){
            if(context == null) throw new RuntimeException("Please, set the context before initializing");
            if(TextUtils.isEmpty(prefsName)){
                prefsName = context.getPackageName();
            }
            if (isDefaultUsed){
                prefsName.concat(DEFAULT_SUFFIX);
            }
            SimplePrefs.init(context,prefsName,mode);
        }


    }
}
