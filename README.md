# ImageGallery 
---------
<!--[![Build Status](https://api.travis-ci.org/ChristianLJ/MaterialEditText.svg)](https://travis-ci.org/ChristianLJ/MaterialEditText)-->
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square)](https://opensource.org/licenses/Apache2)

ImageGallery is an image gallery for Android. With this image gallery you can easly add a gallery to your app. 
The gallery accepts a `List\<String\>` and uses Picasso to load them.

ImageGallery is licensed under the friendly [Apache2 licence].

### Documentation
Various documentation is available:

#### Default config:
```groovy
android {
    compileSdkVersion 25
    buildToolsVersion "25.0.1"
    defaultConfig {
        minSdkVersion 17
        targetSdkVersion 25
    }
}
```
##### Supported languages:
- Danish
- English

#### Screenshots:
On the way...
<!--![Screenshot 1](https://raw.githubusercontent.com/ChristianLJ/MultipleImagePicker/master/documentation/s1.png?w=290)
![Screenshot 2](https://raw.githubusercontent.com/ChristianLJ/MultipleImagePicker/master/documentation/s2.png?w=290)
![Screenshot 3](https://raw.githubusercontent.com/ChristianLJ/MultipleImagePicker/master/documentation/s3.png?w=290)-->

### Example:
Use the gallery the following way:
```java
...
```

Add the view to your app:
```xml
...
```

### Releases
[Release 0.1] is the current latest release. This release is considered stable.


**Gradle configuration:**

Add the following to your build.gradle:
```groovy
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}

...

dependencies {
    ...
    compile 'com.github.ChristianLJ:ImageGallery:0.1'
    ...
}
```


### Support
Please use GitHub issues and Pull Requests for support.


### History
Issue tracking and active development is at GitHub.
