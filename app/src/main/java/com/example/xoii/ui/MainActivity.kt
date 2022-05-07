package com.example.xoii.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import androidx.compose.ui.unit.dp
import com.example.xoii.components.CenterTopAppBar
import com.example.xoii.ui.tabs.EmptyTab
import com.example.xoii.ui.tabs.UploadTab
import com.example.xoii.ui.theme.XoiiTheme
import com.example.xoii.viewModels.MainViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            XoiiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(topBar = { TopBar(title = "Berlin Adlershof") }) { padding ->
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
                                    UploadTab()
                                }
                            }

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
                                    text = "Yükleme adresi sınırlarındasın"
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
                                    text = "YÜKLEME AKIŞI - 1 / 4",
                                    color = Color.White
                                )
                                Button(onClick = { /* Do something! */ },
                                    colors = ButtonDefaults.textButtonColors(
                                    backgroundColor = Color.White
                                )) {
                                    Text("YÜKLEME NOKTASINA GELDİM", color = Color.Blue)
                                }
                                }
                            }
                        }
                    }
                }
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