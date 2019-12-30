package com.cuncis.retrofitlivedataexample.data

import com.cuncis.retrofitlivedataexample.model.ArticleResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TheNewsApi {

    @GET("v2/top-headlines")
    fun getNewsList(@Query("country") country: String,
                    @Query("category") category: String,
                    @Query("apiKey") apiKey: String)
            : Call<ArticleResponse>

}