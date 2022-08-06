package com.erjan.tzandroid.di

import com.erjan.data.repositories.CandidateRepositoryImpl
import com.erjan.data.repositories.GalleryRepositoryImpl
import com.erjan.domain.repositories.CandidateRepository
import com.erjan.domain.repositories.GalleryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun bindCandidateRepository(repositoryImpl: CandidateRepositoryImpl): CandidateRepository

    @Binds
    abstract fun bindGalleryRepository(repositoryImpl: GalleryRepositoryImpl): GalleryRepository
}