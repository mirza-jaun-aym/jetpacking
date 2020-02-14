package com.example.livedata.network

import com.example.livedata.model.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WikiApiService {

    @GET("todos/{id}")
    fun hitCountCheck(@Path("id") id: String) : Call<Post>
}