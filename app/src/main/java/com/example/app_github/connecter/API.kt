package com.example.app_github.connecter

import com.example.app_github.model.IssueModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("issues")
    fun getIssue(@Query("state") state:String,@Query("sort") sort:String,@Query("direction") direction:String) : Call<List<IssueModel>>
}