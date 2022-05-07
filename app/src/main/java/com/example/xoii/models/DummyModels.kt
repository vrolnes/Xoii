package com.example.xoii.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

class DummyModels {

    fun getTabs(): List<ImageVector> {
        return listOf(Icons.Default.Info, Icons.Default.KeyboardArrowUp, Icons.Default.List, Icons.Default.KeyboardArrowDown)
    }
}