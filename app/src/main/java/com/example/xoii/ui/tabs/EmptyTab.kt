package com.example.xoii.ui.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.xoii.R

@Composable
fun EmptyTab() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = dimensionResource(id = R.dimen.emptyTabTopPadding)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.emptyTabVerticalSpacePadding))
    ) {
        Icon(
            imageVector = Icons.Default.Info,
            contentDescription = "",
            tint = Color.Red,
        )

        Text(
            text = stringResource(id = R.string.empty_message)
        )
    }
}