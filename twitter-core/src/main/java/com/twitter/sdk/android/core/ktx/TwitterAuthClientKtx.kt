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

/**
 * Requests authorization.
 * Do not forget to override `Activity.onActivityResult`
 * and pass arguments to [TwitterAuthClient.onActivityResult].
 *
 * @param activity The {@link android.app.Activity} context to use for the authorization flow.
 */
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