package com.example.vkclientnews.domain

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.example.vkclientnews.R
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize
import kotlin.random.Random

@Parcelize
data class FeedPost(
    val id: Long,
    val communityId:Long,
    val communityName: String,
    val publicationDate: String,
    val communityImageUrl: String,
    val contentText: String,
    val contentImageUrl: String?,
    val statistics: List<StatisticItem>,
    val isFovourite: Boolean
) : Parcelable {
    companion object {
        val NavigationType: NavType<FeedPost> = object : NavType<FeedPost>(false) {

            override fun get(bundle: Bundle, key: String): FeedPost? {
                return bundle.getParcelable(key)
            }

            override fun parseValue(value: String): FeedPost {
                return Gson().fromJson<FeedPost>(value, FeedPost::class.java)
            }

            override fun put(bundle: Bundle, key: String, value: FeedPost) {
                bundle.putParcelable(key, value)
            }

        }
    }
}