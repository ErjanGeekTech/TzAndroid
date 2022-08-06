package com.erjan.domain.usecases

import com.erjan.domain.repositories.GalleryRepository
import javax.inject.Inject

class GetPhotosFromGalleryUseCase @Inject constructor(private val repository: GalleryRepository) {

    operator fun invoke() = repository.getPhotosFromGallery()
}