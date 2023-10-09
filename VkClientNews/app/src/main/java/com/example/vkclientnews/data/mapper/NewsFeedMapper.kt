package com.example.vkclientnews.data.mapper

import com.example.vkclientnews.data.model.CommentsResponse
import com.example.vkclientnews.data.model.NewsFeedResponseDto
import com.example.vkclientnews.domain.entity.FeedPost
import com.example.vkclientnews.domain.entity.PostComment
import com.example.vkclientnews.domain.entity.StatisticItem
import com.example.vkclientnews.domain.entity.StatisticType
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject
import kotlin.math.absoluteValue

class NewsFeedMapper @Inject constructor(){
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
                communityId = post.communityId,
                communityName = group.name,
                publicationDate = mapTimestampToDate(post.date),
                communityImageUrl = group.imageUrl,
                contentText = post.text,
                contentImageUrl = post.attachments?.firstOrNull()?.photo?.photoUrls?.lastOrNull()?.url,
                statistics = listOf(
                    StatisticItem(type = StatisticType.LIKES, post.likes.count),
                    StatisticItem(type = StatisticType.VIEWS, post.views.count),
                    StatisticItem(type = StatisticType.SHARES, post.reposts.count),
                    StatisticItem(type = StatisticType.COMMENTS, post.comments.count),
                ),
                isLiked = post.likes.userLiked >0
            )
            result.add(feePost)

        }
        return result
    }

    fun mapResponseToPosts(
        responseComment: CommentsResponse
    ): List<PostComment> {
        val result = mutableListOf<PostComment>()
        val comments = responseComment.response.comments
        val profiles = responseComment.response.profiles
        for (comment in comments) {
            if (comment.text.isBlank()) continue
            val author =
                profiles.firstOrNull { author -> author.id == comment.authorId } ?: continue
            val postComment = PostComment(
                id = comment.id,
                authorName = "${author.firstName} ${author.lastName}",
                authorAvatarUrl = author.photoUrl,
                commentText = comment.text,
                publicationDate = mapTimestampToDate(comment.dateComment)
            )
            result.add(postComment)
        }
        return result
    }

    private fun mapTimestampToDate(timestamp:Long):String{
        val date = Date(timestamp*1000)
        return SimpleDateFormat("dd MMMM yyyy, hh:mm", Locale.getDefault()).format(date)
    }
}