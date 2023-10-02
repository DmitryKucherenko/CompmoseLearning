package com.example.vkclientnews.data.model

import com.google.gson.annotations.SerializedName

data class CommentsResponse(
    @SerializedName("response") val response: CommentsContentDto
)
