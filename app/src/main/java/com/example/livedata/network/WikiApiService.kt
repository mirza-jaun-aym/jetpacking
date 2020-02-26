package com.example.livedata.network

import com.example.livedata.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface WikiApiService {

    @GET("todos")
    fun hitCountCheck() : Call<List<Post>>
}