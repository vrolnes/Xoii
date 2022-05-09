package com.example.xoii.components

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalImageViewer(images: List<Uri>){
    HorizontalPager(count = images.size) { page ->
        Image(
            painter = rememberImagePainter(
                data = Uri.parse(images[page].toString())),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(0.20f),
            contentScale = ContentScale.FillBounds
        )
        
    }
}