<img align="right" src="images/Hauler.svg">

# Hauler

[![Maven Central](https://img.shields.io/maven-central/v/app.futured.hauler/hauler)](https://search.maven.org/artifact/app.futured.hauler/hauler/)
![minSdk:21](https://img.shields.io/badge/minSDK-21-brightgreen.svg)
[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-Hauler-brightgreen.svg?style=flat )]( https://android-arsenal.com/details/1/7359 )
![Publish Snapshot](https://github.com/futuredapp/hauler/actions/workflows/publish_snapshot.yml/badge.svg)
![License](https://img.shields.io/github/license/futuredapp/hauler?color=black)

Hauler is an Android library containing custom layout which enables to easily create swipe to dismiss `Activity`.
Implementation is based on code from project [Plaid](https://github.com/nickbutcher/plaid).

![Alt text](https://github.com/thefuntasty/hauler/blob/master/images/example.gif)

# Installation

```groovy
dependencies {
    implementation("app.futured.hauler:hauler:latestVersion")

    // optional dependency with set of Data Binding adapters
    implementation("app.futured.hauler:databinding:latestVersion")
}
```

### Snapshot installation

Add new maven repo to your top level gradle file.

```groovy
maven { url "https://oss.sonatype.org/content/repositories/snapshots" }
```

Snapshots are grouped based on major version, so for version 5.x.x use:

```groovy
implementation "app.futured.hauler:hauler:5.X.X-SNAPSHOT"
```

# Features

Hauler library comes with highly customizable `HaulerView` which provides swipe to dismiss functionality. 
It also ships with `databinding` module which contains Binding Adapters for smoother experience with Android Data Binding implementation.

# Usage
 
 Activity which is meant to be dismissed must contain `HaulerView` as a root view and `NestedScrollView` (or other `View` what supports nested scroll) 
 as its child. Make sure your `NestedScrollview`'s attribute `android:fillViewport` is set to `true` otherwise it might not behave as
 expected:

```xml
<app.futured.hauler.HaulerView
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
</app.futured.hauler.HaulerView>
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

## Customization

There are few styleable attributes you might want to use to customize your `HaulerView`:

 ```xml
<app.futured.hauler.HaulerView
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

# License

Hauler is available under the MIT license. See the [LICENSE file](LICENCE) for more information.
