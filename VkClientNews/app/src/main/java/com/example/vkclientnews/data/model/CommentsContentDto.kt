package com.example.vkclientnews.data.model

import com.google.gson.annotations.SerializedName

data class CommentsContentDto(
    @SerializedName("count") val count: Int,
    @SerializedName("items") val comments: List<CommentDto>,
    @SerializedName("profiles") val profiles: List<ProfileDto>,
    @SerializedName("groups") val groups: List<GroupDto>,
)
