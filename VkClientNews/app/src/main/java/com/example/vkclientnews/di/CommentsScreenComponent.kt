package com.example.vkclientnews.di

import android.view.View
import com.example.vkclientnews.domain.entity.FeedPost
import com.example.vkclientnews.presentation.ViewModelFactory
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent

@Subcomponent(
    modules = [
        CommentsViewModelModule::class
    ]
)
interface CommentsScreenComponent {

    fun getViewModelFactory():ViewModelFactory

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance feedPost: FeedPost
        ): CommentsScreenComponent
    }
}