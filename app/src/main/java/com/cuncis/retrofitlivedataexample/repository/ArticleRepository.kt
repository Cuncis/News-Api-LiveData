package com.cuncis.retrofitlivedataexample.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.cuncis.retrofitlivedataexample.data.ApiClient
import com.cuncis.retrofitlivedataexample.data.TheNewsApi
import com.cuncis.retrofitlivedataexample.model.ArticleResponse
import com.cuncis.retrofitlivedataexample.model.Articles
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class ArticleRepository {

    private var newsApi: TheNewsApi = ApiClient.getNewsApi()

    fun getNews(country: String, category: String, apiKey: String): MutableLiveData<ArticleResponse> {
        var newsApiList = MutableLiveData<ArticleResponse>()
        val call = newsApi.getNewsList(country, category, apiKey)
        call.enqueue(object : Callback<ArticleResponse> {
            override fun onResponse(call: Call<ArticleResponse>, response: Response<ArticleResponse>) {
                if (response.isSuccessful) {
                    Log.d("_logArticle", "onResponse: " + response.body()?.articles)
                    newsApiList.value = response.body()
                } else {
                    try {
                        Log.d("_logArticle", "Error1: " + response.message())
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call<ArticleResponse>, t: Throwable) {
                Log.d("_logArticle", "Error2: " + t.message)
            }
        })

        return newsApiList
    }
}