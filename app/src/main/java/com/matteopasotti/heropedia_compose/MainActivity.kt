package com.matteopasotti.heropedia_compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
                    Greeting("Android")
                }

                when(val state = homeState) {
                    is HomeState.Content -> {
                        (state as HomeState.Content).characters
                        Log.d("HH", "HH")
                    }
                    is HomeState.Idle -> {}
                    is HomeState.Error -> {}
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HeropediaComposeTheme {
        Greeting("Android")
    }
}