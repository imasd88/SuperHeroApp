package com.emazdoor.superheroapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.emazdoor.superheroapp.mock.MockData
import com.emazdoor.superheroapp.model.Superhero
import com.emazdoor.superheroapp.ui.components.SuperHeroItemView
import com.emazdoor.superheroapp.ui.theme.SuperHeroAppTheme
import com.emazdoor.superheroapp.viewmodel.SuperheroViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel : SuperheroViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fetchSuperHeroes()
        setContent {
            SuperHeroAppTheme {
                print("ASD ${viewModel.superheroesState.collectAsState().value}")
                val tempList = viewModel.superheroesState.collectAsState().value
                LazyColumn(){
                    items(tempList){
                        SuperHeroItemView(it)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val stateList = remember{ mutableStateListOf<Superhero>() }
    stateList.add(MockData.getMockData()[0])
    SuperHeroAppTheme {
        LazyColumn(){
           items(stateList){
               SuperHeroItemView(it)
           }

        }
    }
}