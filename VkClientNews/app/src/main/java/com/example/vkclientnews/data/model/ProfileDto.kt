package com.example.vkclientnews.data.model

import com.google.gson.annotations.SerializedName

data class ProfileDto (
    @SerializedName("id") val id: Int,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("date") val dateComment: Int,
    @SerializedName("photo_200") val photoUrl: String
)
