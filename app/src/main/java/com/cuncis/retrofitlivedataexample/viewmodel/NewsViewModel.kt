package com.cuncis.retrofitlivedataexample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cuncis.retrofitlivedataexample.model.ArticleResponse
import com.cuncis.retrofitlivedataexample.repository.ArticleRepository

class NewsViewModel: ViewModel() {
    private val articleRepository = ArticleRepository()

    fun getNews(country: String, category: String, apiKey: String): MutableLiveData<ArticleResponse> {
        return articleRepository.getNews(country, category, apiKey)
    }
}