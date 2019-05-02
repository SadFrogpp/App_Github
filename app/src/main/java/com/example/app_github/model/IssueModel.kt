package com.example.app_github.model

import com.example.app_github.model.UserModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class IssueModel(
    @SerializedName("title")
    val title: String,
    @SerializedName("user")
    val user: UserModel,
    @SerializedName("comments")
    val comments: Int,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("html_url")
    val url: String
)