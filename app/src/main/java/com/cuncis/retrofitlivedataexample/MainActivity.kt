package com.cuncis.retrofitlivedataexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.cuncis.retrofitlivedataexample.adapter.NewsAdapter
import com.cuncis.retrofitlivedataexample.model.Articles
import com.cuncis.retrofitlivedataexample.util.Utils.API_KEY
import com.cuncis.retrofitlivedataexample.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var articleViewModel: NewsViewModel
    lateinit var adapter: NewsAdapter
    lateinit var newsList: ArrayList<Articles>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        articleViewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        adapter = NewsAdapter(this)
        rv_news.layoutManager = LinearLayoutManager(this)
        rv_news.setHasFixedSize(true)
        rv_news.adapter = adapter

        articleViewModel.getNews("us", "business", API_KEY).observe(this, Observer {
            newsList = ArrayList<Articles>(it.articles!!)
            adapter.setNewsList(newsList)
            Log.d("_logArticles", "" + it)
        })
    }
}
