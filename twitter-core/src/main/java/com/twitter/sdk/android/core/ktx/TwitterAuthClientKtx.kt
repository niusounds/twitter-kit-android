package com.twitter.sdk.android.core.ktx

import android.app.Activity
import com.twitter.sdk.android.core.Callback
import com.twitter.sdk.android.core.Result
import com.twitter.sdk.android.core.TwitterException
import com.twitter.sdk.android.core.TwitterSession
import com.twitter.sdk.android.core.identity.TwitterAuthClient
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

suspend fun TwitterAuthClient.authorize(activity: Activity): TwitterSession =
    suspendCoroutine { continuation ->
        authorize(activity, object : Callback<TwitterSession>() {
            override fun success(result: Result<TwitterSession>) {
                continuation.resume(result.data)
            }

            override fun failure(exception: TwitterException) {
                continuation.resumeWithException(exception)
            }
        })
    }