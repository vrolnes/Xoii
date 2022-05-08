package com.example.xoii.ui.tabs

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.xoii.R
import com.example.xoii.components.MapScreen
import com.example.xoii.navigation.Screen

@Composable
fun UploadTab(cargoData: List<String>, navController: NavController) {
    val image: Painter = painterResource(id = R.drawable.fileimage)

    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column(modifier = Modifier.fillMaxHeight(0.25f)) {
            Maps()
        }
        Row {
            Column(modifier = Modifier.weight(0.66f)) {
                Grids(cargoData)
            }
            Column(modifier = Modifier.weight(0.33f)) {
                ImageShower(image = image, navController)
            }
        }
    }
}

@Composable
fun Maps() {
    MapScreen()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Grids(cargoData: List<String>) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier.fillMaxHeight(),
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.uploadTabGridContentPadding))
    ) {
        items(cargoData.size) { index ->
            OutlinedTextField(cargoData[index])
        }
    }
}

@Composable
fun OutlinedTextField(label: String) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        modifier = Modifier.padding(dimensionResource(id = R.dimen.uploadTabTextFieldPadding)),
        onValueChange = { text = it },
        label = { Text(label, fontSize = 12.sp) }
    )
}

@Composable
fun ImageShower(image: Painter, navController: NavController) {
    Image(painter = image, contentDescription = "", modifier = Modifier
        .clickable {
            navController.navigate(Screen.ImageViewScreen.withArgs(R.drawable.fileimage.toString()))
        }
        .padding(top = dimensionResource(id = R.dimen.uploadTabImageShowerTopPadding)))
}