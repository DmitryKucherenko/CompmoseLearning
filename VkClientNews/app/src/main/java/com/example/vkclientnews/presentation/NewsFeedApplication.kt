package com.example.vkclientnews.presentation

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.vkclientnews.di.ApplicationComponent
import com.example.vkclientnews.di.DaggerApplicationComponent
import com.example.vkclientnews.domain.entity.FeedPost

class NewsFeedApplication: Application() {
    val component:ApplicationComponent by lazy{
              DaggerApplicationComponent.factory().create(
                  this
              )
    }
}

@Composable
fun getApplicationComponent():ApplicationComponent{
    return (LocalContext.current.applicationContext as NewsFeedApplication).component
}