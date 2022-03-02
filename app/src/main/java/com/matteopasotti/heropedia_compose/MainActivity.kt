package com.matteopasotti.heropedia_compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.matteopasotti.heropedia_compose.models.Character
import com.matteopasotti.heropedia_compose.ui.components.*
import com.matteopasotti.heropedia_compose.ui.screens.home.HomeState
import com.matteopasotti.heropedia_compose.ui.screens.home.HomeViewModel
import com.matteopasotti.heropedia_compose.ui.theme.HeropediaComposeTheme
import kotlinx.coroutines.flow.Flow
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : ComponentActivity() {

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeropediaComposeTheme {
                Scaffold(
                    topBar = {
                        HomeAppBar(
                            title = "Heropedia", isDarkTheme = isSystemInDarkTheme()
                        ) {}
                    }
                ) {
                    ListCharacters(characters = viewModel.characters)
                }

            }
        }
    }
}


@Composable
fun ListCharacters(characters: Flow<PagingData<Character>>) {
    val lazyCharacterItems: LazyPagingItems<Character> = characters.collectAsLazyPagingItems()

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(lazyCharacterItems) { character ->
            val url = character!!.thumbnail.path + "." + character.thumbnail.extension
            MarvelCardCharacterWithTitle(imageUrl = url, title = character!!.name) {}
        }

        lazyCharacterItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    // data is loading for the first time
                    item { LoadingView(modifier = Modifier.fillParentMaxSize()) }
                }

                loadState.append is LoadState.Loading -> {
                    // for constituent loads, show a loading item in the LazyColumn
                    item { LoadingItem() }
                }

                loadState.refresh is LoadState.Error -> {
                    val e = lazyCharacterItems.loadState.refresh as LoadState.Error
                    item {
                        ErrorItem(
                            message = e.error.localizedMessage!!,
                            modifier = Modifier.fillParentMaxSize(),
                            onClickRetry = { retry() }
                        )
                    }
                }
                loadState.append is LoadState.Error -> {
                    val e = lazyCharacterItems.loadState.append as LoadState.Error
                    item {
                        ErrorItem(
                            message = e.error.localizedMessage!!,
                            onClickRetry = { retry() }
                        )
                    }
                }
            }
        }
    }
}