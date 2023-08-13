package com.example.vkclientnews.domain

import com.example.vkclientnews.R

data class PostComment(
    val id: Int,
    val authorName: String = "Author",
    val authorAvatarId: Int = R.drawable.comment_author_avatar,
    val commentText:String = "Long comment text",
    val publicationDate:String = "10:18"
)