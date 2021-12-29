package com.twitter.sdk.android.core.ktx

import android.content.Context
import com.twitter.sdk.android.core.Twitter
import com.twitter.sdk.android.core.TwitterConfig

fun initializeTwitter(context: Context, config: TwitterConfig.Builder.() -> Unit = {}) =
    Twitter.initialize(twitterConfig(context, config))


fun twitterConfig(context: Context, config: TwitterConfig.Builder.() -> Unit): TwitterConfig =
    TwitterConfig.Builder(context).apply(config).build()