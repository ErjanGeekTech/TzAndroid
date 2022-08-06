package com.erjan.tzandroid.presentation.extensions

import android.content.pm.PackageManager
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import java.util.ArrayList

fun Fragment.hasPermissionCheckAndRequest(
    requestPermissionLauncher: ActivityResultLauncher<String>,
    permission: String,
): Boolean =
    if (checkSelfPermission(permission)) {
        true
    } else {
        shouldShowRequestPermissionRationale(permission)
        requestPermissionLauncher.launch(permission)
        false
    }

fun Fragment.checkSelfPermission(
    permission: String,
) = ContextCompat.checkSelfPermission(
    requireContext(),
    permission
) == PackageManager.PERMISSION_GRANTED