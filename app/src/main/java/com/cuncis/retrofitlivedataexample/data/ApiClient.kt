package com.cuncis.retrofitlivedataexample.data

import com.cuncis.retrofitlivedataexample.util.Utils
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    fun getNewsApi(): TheNewsApi {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Utils.BASE_URL)
            .build()

        return retrofit.create(TheNewsApi::class.java)
    }

}