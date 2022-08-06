package com.erjan.tzandroid.di

import android.content.Context
import com.erjan.data.repositories.CandidateRepositoryImpl
import com.erjan.data.repositories.GalleryRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoriesProvidesModule {

    @Provides
    fun provideGalleryRepositoryImpl(@ApplicationContext context: Context) =
        GalleryRepositoryImpl(context)

    @Provides
    fun provideCandidateRepositoryImpl(@ApplicationContext context: Context) =
        CandidateRepositoryImpl(context)
}