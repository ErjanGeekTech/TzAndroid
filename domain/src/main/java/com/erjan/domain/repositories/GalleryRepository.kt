package com.erjan.domain.repositories

import com.erjan.domain.Either
import kotlinx.coroutines.flow.Flow

interface GalleryRepository {

    fun getPhotosFromGallery(): Flow<Either<String, List<String>>>
}