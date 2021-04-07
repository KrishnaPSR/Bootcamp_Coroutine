package com.example.coroutineasync

import com.example.coroutineasync.DataModel
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts")
    fun getPost(): retrofit2.Call<List<DataModel>>
}