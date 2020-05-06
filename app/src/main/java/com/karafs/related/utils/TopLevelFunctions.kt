package com.karafs.related.utils

import com.karafs.related.R
import com.karafs.related.network.Result
import com.karafs.related.utils.ktx.logE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <T : Any> safeApiCall(
    call: suspend () -> Result<T>
): Result<T> {
    return withContext(Dispatchers.Main) {
        try {
            withContext(Dispatchers.IO) {
                call()
            }
        } catch (e: Exception) {
            logE(e)
            Result.Error(R.string.app_name, 0)
        }
    }
}
