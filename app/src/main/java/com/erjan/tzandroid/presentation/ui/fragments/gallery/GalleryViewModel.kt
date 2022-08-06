package com.erjan.tzandroid.presentation.ui.fragments.gallery

import com.erjan.domain.usecases.GetPhotosFromGalleryUseCase
import com.erjan.tzandroid.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(private val getPhotosFromGalleryUseCase: GetPhotosFromGalleryUseCase) :
    BaseViewModel() {

    private val _photosState = mutableUIStateFlow<List<String>>()
    val photosState = _photosState.asStateFlow()

    fun getPhotosFromGallery() {
        getPhotosFromGalleryUseCase().collectRequest(_photosState)
    }
}