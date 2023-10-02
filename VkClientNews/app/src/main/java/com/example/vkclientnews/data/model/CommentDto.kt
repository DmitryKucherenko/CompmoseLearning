package com.example.vkclientnews.data.model

import com.google.gson.annotations.SerializedName

data class CommentDto(
    @SerializedName("id") val id: Long,
    @SerializedName("from_id") val authorId: Int,
    @SerializedName("text") val text: String,
    @SerializedName("date") val dateComment: Long,
)


