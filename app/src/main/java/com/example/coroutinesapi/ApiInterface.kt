package com.example.coroutinesapi

import com.example.coroutinesapi.DataModel
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts")
    fun getPost(): retrofit2.Call<List<DataModel>>
}