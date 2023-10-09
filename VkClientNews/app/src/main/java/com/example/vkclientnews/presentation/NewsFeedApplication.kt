package com.example.vkclientnews.presentation

import android.app.Application
import com.example.vkclientnews.di.ApplicationComponent
import com.example.vkclientnews.di.DaggerApplicationComponent
import com.example.vkclientnews.domain.entity.FeedPost

class NewsFeedApplication: Application() {
    val component:ApplicationComponent by lazy{
              DaggerApplicationComponent.factory().create(
                  this,
                  FeedPost(0,0,",","","","","", listOf(),false)
              )
    }
}