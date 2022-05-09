package com.example.xoii.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.xoii.R
import com.example.xoii.components.CenterTopAppBar
import com.example.xoii.ui.tabs.EmptyTab
import com.example.xoii.ui.tabs.UploadTab
import com.example.xoii.ui.theme.XoiiTheme
import com.example.xoii.viewModels.MainViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import gun0912.tedimagepicker.builder.TedImagePicker
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreenComposable(mainViewModel: MainViewModel, navController: NavController) {
    XoiiTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Scaffold(topBar = { TopBar(title = stringResource(id = R.string.topBarTitle)) }) { padding ->
                val pages = remember {
                    mainViewModel.getTabs()
                }

                Column(
                    Modifier
                        .fillMaxWidth()
                ) {

                    val coroutineScope = rememberCoroutineScope()

                    // Remember a PagerState
                    val pagerState = rememberPagerState()

                    ScrollableTabRow(
                        // Our selected tab is our current page
                        selectedTabIndex = pagerState.currentPage,
                        indicator = { tabPositions ->
                            TabRowDefaults.Indicator(
                                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
                            )
                        }
                    ) {
                        // Add tabs for all of our pages
                        pages.forEachIndexed { index, icon ->
                            Tab(
                                icon = {
                                    Icon(
                                        imageVector = icon as ImageVector,
                                        contentDescription = "",
                                        tint = Color.White
                                    )
                                },
                                selected = pagerState.currentPage == index,
                                onClick = {
                                    // Animate to the selected page when clicked
                                    coroutineScope.launch {
                                        pagerState.animateScrollToPage(index)
                                    }
                                }
                            )
                        }
                    }

                    HorizontalPager(
                        count = pages.size,
                        state = pagerState,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize()
                    ) { page ->
                        // Our content for each page
                        if (page != 1) {
                            EmptyTab()
                        } else {
                            UploadTab(mainViewModel.getCargoData(), navController)
                        }
                    }
                    BottomLayout()
                }
            }
        }
    }

}

@Composable
fun BottomLayout(){
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Icon(
            imageVector = Icons.Default.Place,
            contentDescription = "",
            tint = Color.Green,
        )
        Text(
            text = stringResource(id = R.string.loadingBoundry)
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue)
            .padding(top = 16.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.loadingFlow),
            color = Color.White
        )
        Button(
            onClick = {
                TedImagePicker.with(context = context)
                    .startMultiImage { uriList ->
                    uriList.forEach{
                        print(it.toString())
                    }

                    }
                      },
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.White
            )
        ) {
            Text(stringResource(id = R.string.arrivedText), color = Color.Blue)
        }
    }
}

@Composable
fun TopBar(title: String) {
    CenterTopAppBar(
        modifier = Modifier,
        title = {
            Text(title, maxLines = 2)
        },
        navigationIcon = {
            IconButton(onClick = {/* TODO Implement when back screens added */ }) {
                Icon(Icons.Filled.ArrowBack, "backIcon")
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "Share",
                    tint = Color.White
                )
            }
        })
}