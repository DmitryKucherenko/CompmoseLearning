package com.example.vkclientnews.data.mapper

import com.example.vkclientnews.data.model.NewsFeedResponseDto
import com.example.vkclientnews.domain.FeedPost
import com.example.vkclientnews.domain.StatisticItem
import com.example.vkclientnews.domain.StatisticType
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.absoluteValue

class NewsFeedMapper {
    fun mapResponseToPosts(
        responseDto: NewsFeedResponseDto
    ): List<FeedPost> {
        val result = mutableListOf<FeedPost>()
        val posts = responseDto.newsFeedContentDto.posts
        val groups = responseDto.newsFeedContentDto.groups
        for (post in posts) {
            val group = groups.find {
                it.id == post.communityId.absoluteValue
            } ?: break
            val feePost = FeedPost(
                id = post.id,
                communityName = group.name,
                publicationDate = mapTimestampToDate(post.date*1000),
                communityImageUrl = group.imageUrl,
                contentText = post.text,
                contentImageUrl = post.attachments?.firstOrNull()?.photo?.photoUrls?.lastOrNull()?.url,
                statistics = listOf(
                    StatisticItem(type = StatisticType.LIKES, post.likes.count),
                    StatisticItem(type = StatisticType.VIEWS, post.views.count),
                    StatisticItem(type = StatisticType.SHARES, post.reposts.count),
                    StatisticItem(type = StatisticType.COMMENTS, post.comments.count),
                )
            )
            result.add(feePost)

        }
        return result
    }

    private fun mapTimestampToDate(timestamp:Long):String{
        val date = Date(timestamp)
        return SimpleDateFormat("dd MMMM yyyy, hh:mm", Locale.getDefault()).format(date)
    }
}