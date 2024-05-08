package com.ceos.jetpackshowcase.core.retrofit.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor(private val headers: Map<String, String>) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val request = original.newBuilder()
        for ((key, value) in headers) {
            request.addHeader(key, value)
        }
        return chain.proceed(request.build())
    }

}

fun headerInterceptorWith(vararg pairs: Pair<String, String>): HeaderInterceptor {
    return HeaderInterceptor(pairs.toMap())
}
