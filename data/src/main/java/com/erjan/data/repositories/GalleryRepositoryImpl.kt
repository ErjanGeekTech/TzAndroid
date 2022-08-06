package com.erjan.data.repositories

import android.content.Context
import android.provider.MediaStore
import com.erjan.data.repositories.base.BaseRepository
import com.erjan.domain.repositories.GalleryRepository
import javax.inject.Inject

class GalleryRepositoryImpl @Inject constructor(private val context: Context) : BaseRepository(),
    GalleryRepository {

    override fun getPhotosFromGallery() = doRequest {
        val photos = arrayListOf<String>()
        val cursor = context.contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, arrayOf(
            MediaStore.MediaColumns.DATA,
            MediaStore.Images.Media.BUCKET_DISPLAY_NAME
        ), null, null, null)

        val columnIndexData = cursor?.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA)
        while (cursor?.moveToNext() == true) {
            columnIndexData?.let {
                photos.add(cursor.getString(columnIndexData))
            }
        }
        photos
    }
}