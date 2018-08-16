# SimplePrefs

A small library for better management of preference in Android. It provides simple
read and write APIs. Using SimplePrefs library, you can initialize it inside the activities and fragments easily.

(#1 reason I have created this library is that in android, instantiating the sharedpreference class and creating editor for
writing the preference is overhead, and always causes headache for me. So, I have created this library to improve my productivity)

## Initialization

To initialize SimplePrefs, you can easily do the following:

```
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
```