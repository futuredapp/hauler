[![Download](https://api.bintray.com/packages/thefuntastyops/hauler/core/images/download.svg) ](https://bintray.com/thefuntastyops/hauler/core/_latestVersion)
![minSdk:21](https://img.shields.io/badge/minSDK-21-brightgreen.svg)
[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-Hauler-brightgreen.svg?style=flat )]( https://android-arsenal.com/details/1/7359 )
![Check Master](https://github.com/futuredapp/hauler/workflows/Check%20Master/badge.svg?branch=master)
![](https://raw.githubusercontent.com/thefuntasty/hauler/master/images/logo_stretch.png)

Hauler
======

Hauler is a library containing custom layout which enables to easily create swipe to dismiss `Activity`.
Implementation is based on code from project [Plaid](https://github.com/nickbutcher/plaid).

![Alt text](https://github.com/thefuntasty/hauler/blob/master/images/example.gif)

How to use
----------
 
 Activity which is meant to be dismissed must contain `HaulerView` as a root view and `NestedScrollView` (or other `View` what supports nested scroll) 
 as its child. Make sure your `NestedScrollview`'s attribute `android:fillViewport` is set to `true` otherwise it might not behave as
 expected:

```xml
<com.thefuntasty.hauler.HaulerView
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:id="@+id/haulerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

    <androidx.core.widget.NestedScrollView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:fillViewport="true">
            
            <!-- your layout-->
            
    </androidx.core.widget.NestedScrollView>
</com.thefuntasty.hauler.HaulerView>           
```

Secondly, define translucent floating Theme and assign it to the Activity you want to give dismiss ability:

 ```xml
<style name="AppTheme.Draggable" parent="Theme.AppCompat.Light.NoActionBar">
        <item name="android:colorBackgroundCacheHint">@null</item>
        <item name="android:windowContentOverlay">@null</item>
        <item name="android:windowIsFloating">false</item>
        <item name="android:windowIsTranslucent">true</item>
        <item name="android:windowNoTitle">true</item>
        <item name="android:windowBackground">@color/dark_gray</item>
</style>
```

```xml
<activity
        android:name=".draggable.SimpleUsageActivity"
        android:theme="@style/AppTheme.Draggable"/>
```
Set `onDragDismissListener` to react properly to user dismiss request. Example implementation might look like this:
```kotlin
    override fun onCreate(savedInstanceState: Bundle?) {
        // ...

        haulerView.setOnDragDismissedListener {
            finish() // finish activity when dismissed
        }
    }
```

Customization
-------------

There are few styleable attributes you might want to use to customize your `HaulerView`:

 ```xml
<com.thefuntasty.hauler.HaulerView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:dragDismissDistance="112dp"
        app:dragDismissFraction="0.9"
        app:dragElasticity="0.7"
        app:dragDismissScale="0.95"/>
```

| Attribute name | Type | Default value | Description|
| -------------- | ---- | ------------- | ---------- |
| `app:dragDismissDistance` | dimen | 100dp | Distance which should be `View` swiped to consider Activity as dismissed |
| `app:dragDismissFraction` | float | unspecified | `<0;1>` - Fraction of `View`'s height we should reach swiping to consider Activity as dismissed |
| `app:dragElasticity` | float | 0.8 | `<0;1>` - Toughness of swipe. Higher value indicates more rigid feeling  |
| `app:dragDismissScale` | float | 0.95 | `<0;1>` - Scale factor of `View` while performing swipe action |
| `app:dragUpEnabled` | boolean | false | Flag indicating if drag up dismiss gesture is enabled |
| `app:fadeSystemBars` | boolean | true | Flag indicating if system bars (status & navigation) fades while dismiss is in progress |

Attributes `dragDismissDistance` and `dragDismissFraction` are exclusive. Do not use them together.

Download
--------
[![Download](https://api.bintray.com/packages/thefuntastyops/hauler/core/images/download.svg) ](https://bintray.com/thefuntastyops/hauler/core/_latestVersion)
`module/build.gradle`:
```groovy
dependencies {
    implementation("com.thefuntasty.hauler:core:latestVersion")

    // optional dependency with set of Data Binding adapters
    implementation("com.thefuntasty.hauler:core:databinding:latestVersion")
}
```
