package com.matteopasotti.heropedia_compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.matteopasotti.heropedia_compose.models.Character
import com.matteopasotti.heropedia_compose.ui.components.MarvelCardCharacter
import com.matteopasotti.heropedia_compose.ui.screens.home.HomeState
import com.matteopasotti.heropedia_compose.ui.screens.home.HomeViewModel
import com.matteopasotti.heropedia_compose.ui.theme.HeropediaComposeTheme
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : ComponentActivity() {

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeropediaComposeTheme {
                val homeState by viewModel.viewState.observeAsState(initial = HomeState.Idle)
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    when(val state = homeState) {
                        is HomeState.Content -> {
                            ListCharacters(characters = state.characters)
                        }
                        is HomeState.Idle -> {}
                        is HomeState.Error -> {}
                    }
                }


            }
        }
    }
}


@Composable
fun ListCharacters(characters: List<Character>) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(characters) { character ->
            val url = character.thumbnail.path + "." +  character.thumbnail.extension
            MarvelCardCharacter(imageUrl = url, title = character.name) {

            }
        }
    }
}