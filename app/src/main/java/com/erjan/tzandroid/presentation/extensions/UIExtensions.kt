package com.erjan.tzandroid.presentation.extensions

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

fun Fragment.showToastShort(text: String) {
    if (isAdded) Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}