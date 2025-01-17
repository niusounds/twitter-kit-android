[![](https://jitpack.io/v/niusounds/twitter-kit-android.svg)](https://jitpack.io/#niusounds/twitter-kit-android)

**This repository removes almost features except `twitter-core` from original TwitterKit. DO NOT USE THIS REPOSITORY IF YOU WANT TO USE FEATURES SUCH AS `tweet-composer`,`twitter-mopub` and `twitter-ui`.**

## How to use

Add `jitpack` maven repository to `settings.gradle`

```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven("https://jitpack.io")
    }
}
```

Add the dependency (`app/build.gradle`)

```gradle
dependencies {
    implementation 'com.github.niusounds:twitter-kit-android:4.0.1'
}
```

## How to develop

To launch sample app, environment variable `TWITTER_CONSUMER_KEY` and `TWITTER_CONSUMER_SECRET` are required. See [sample/build.gradle](https://github.com/niusounds/twitter-kit-android/blob/master/sample/build.gradle). Create your own keys in [Twitter's developer portal](https://developer.twitter.com/).

---

original README for reference

# Twitter Kit for Android

Twitter Kit is a multi-module gradle project containing several Twitter SDKs including TweetComposer, TwitterCore, and TweetUi. Twitter Kit is designed to make interacting with Twitter seamless and efficient.

## Twitter Kit Features

* Display Tweets and timelines
* Compose Tweets
* Monetize with MoPub integration
* Log in with Twitter
* Access the Twitter API

## Getting Started

* Generate your Twitter API keys through the [Twitter developer apps dashboard](https://apps.twitter.com/).
* Install Twitter Kit using instructions below.
* For extensive documentation, please see the [wiki](https://github.com/twitter/twitter-kit-android/wiki).

### Install using Bintray JCenter

Add twitter dependency to your build.gradle:
```groovy

repositories {
  jcenter()
}

dependencies {
  compile('com.twitter.sdk.android:twitter:3.3.0@aar') {
    transitive = true
  }
}

```

### Building from source

Rename samples/app/twitter.properties.sample to samples/app/twitter.properties and populate the consumer key and secret.

To build the entire project run

```
./gradlew assemble
```

Run all automated tests on device to verify.

```
./gradlew test connectedCheck
```

To run the sample app

```
./gradlew :samples:app:installDebug
```


## Contributing

The master branch of this repository contains the latest stable release of Twitter Kit. See [CONTRIBUTING.md](https://github.com/twitter/twitter-kit-android/blob/master/CONTRIBUTING.md) for more details about how to contribute.

## Code of Conduct

This, and all github.com/twitter projects, are under the [Twitter Open Source Code of Conduct](https://github.com/twitter/code-of-conduct/blob/master/code-of-conduct.md). Additionally, see the [Typelevel Code of Conduct](http://typelevel.org/conduct) for specific examples of harassing behavior that are not tolerated.

## Contact

For usage questions post on [Twitter Community](https://twittercommunity.com/tags/c/publisher/twitter/android).

Please report any bugs as [issues](https://github.com/twitter/twitter-kit-android/issues).

Follow [@TwitterDev](http://twitter.com/twitterdev) on Twitter for updates.

## License

Copyright 2017 Twitter, Inc.

Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
