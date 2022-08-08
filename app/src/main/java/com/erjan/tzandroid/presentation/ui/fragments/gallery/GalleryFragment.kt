package com.erjan.tzandroid.presentation.ui.fragments.gallery

import android.Manifest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.erjan.tzandroid.R
import com.erjan.tzandroid.databinding.FragmentGalleryBinding
import com.erjan.tzandroid.presentation.base.BaseFragment
import com.erjan.tzandroid.presentation.extensions.hasPermissionCheckAndRequest
import com.erjan.tzandroid.presentation.extensions.showToastShort
import com.erjan.tzandroid.presentation.ui.adapters.GalleryAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryFragment :
    BaseFragment<GalleryViewModel, FragmentGalleryBinding>(R.layout.fragment_gallery) {

    override val viewModel: GalleryViewModel by viewModels()
    override val binding by viewBinding(FragmentGalleryBinding::bind)
    private val galleryAdapter = GalleryAdapter()

    private val requestReadExternalStoragePermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        when {
            isGranted -> {
                viewModel.getPhotosFromGallery()
            }
            !shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE) -> {
                showToastShort("No permissions")
            }

        }
    }

    override fun initialize() {
        binding.recyclerGallery.adapter = galleryAdapter
    }

    override fun setupRequests() {
        if (hasPermissionCheckAndRequest(
                requestReadExternalStoragePermissionLauncher,
                Manifest.permission.READ_EXTERNAL_STORAGE,
            )
        ) {
            viewModel.getPhotosFromGallery()
        }
    }

    override fun setupSubscribes() {
        subscribeToPhotosGallery()
    }

    private fun subscribeToPhotosGallery() {
        viewModel.photosState.collectUIState(
            onSuccess = {
                galleryAdapter.submitList(it)
            }
        )
    }
}