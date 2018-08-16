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

## Uses

To write the key value pairs, you can easily call the save methods in the following ways
```
public class SimplePrefExample extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SimplePrefs.putInt("myid", 384);
        SimplePrefs.putString("username", "smash");
    }
}

```
Now, you are able to use the SimplePrefs anywhere in your application to save the preferences

To get the value from the key in preference, you may do the following simply

```
public class SimplePrefExample extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int myid = SimplePrefs.getInt("myid", 384);
        String myusername = SimplePrefs.getString("username");
    }
}
```

Here as you may have noticed, no need to check `contains()` and `data != null` or `non-empty` annoying conditions, since the key does not exist,
it simply returns default value internally.

## Integration

To integrate into your project; Add the JitPack repository to your build file,
Add it in your root build.gradle at the end of repositories:

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Then, add the dependency for gradle this way:

```
dependencies {
	        implementation 'com.github.farruhha:SimplePrefs:0.1.2'
	}
```

Or for the maven, in the following way:

```
repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```
Add the dependency
```
<dependency>
	    <groupId>com.github.farruhha</groupId>
	    <artifactId>SimplePrefs</artifactId>
	    <version>0.1.2</version>
	</dependency>
```

```
MIT License

Copyright (c) 2018 Farruh Habibullaev

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```



