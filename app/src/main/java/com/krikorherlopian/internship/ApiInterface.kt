package com.krikorherlopian.internship



import com.krikorherlopian.internship.model.Feed
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("feed-json-sample/master/feed.json")
    fun getList(): Call<Feed>
}