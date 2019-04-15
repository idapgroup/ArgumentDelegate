Argument Delegate
============

Property binding for Android Bundle arguments. Written for simple bundle unpacking for Kotlin users.

Download
--------

[ ![latest-version](https://api.bintray.com/packages/idapgroup/argument-delegate/argument-delegate/images/download.svg?version=1.0.0) ](https://bintray.com/idapgroup/argument-delegate/argument-delegate/1.0.0/link)

```groovy
dependencies {
  implementation 'com.idapgroup:argument-delegate:latest-version'
}
```

Add `jcenter` to your root `build.gradle`

```groovy
repositories {
    jcenter()
}
```

Usage sample
-------------

```kotlin
class ExampleActivity : Activity {

    val userName: String by argumentDelegate()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // your activity setup code
        Log.d("ExampleActivity", "userName - $userName")
    }

}
```

__Remember: Bundled argument name must have the same name as property have. For current example:__

```kotlin
val bundle = Bundle().apply {
    putString("userName", "John")
}
```

Additional info
-------------

__argumentDelegate__ is an extension function for Fragment and Activity. If you want to use it 
out of the Activity/Fragment then you should implement _argumentWrapper_ block. 
Example:

```kotlin
class Example {
    private lateinit var bundle: Bundle
    private val wrapper = { a: Example -> a.bundle }
    val userName: String by argumentDelegate(wrapper)
}
```
