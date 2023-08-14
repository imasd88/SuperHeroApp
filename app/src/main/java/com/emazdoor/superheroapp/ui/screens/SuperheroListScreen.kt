package com.emazdoor.superheroapp.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.findNavController
import com.emazdoor.superheroapp.R
import com.emazdoor.superheroapp.model.Superhero
import com.emazdoor.superheroapp.ui.components.SearchView
import com.emazdoor.superheroapp.ui.components.SuperHeroItemView
import com.emazdoor.superheroapp.ui.theme.SuperHeroAppTheme
import com.emazdoor.superheroapp.viewmodel.SuperheroViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SuperheroListScreen : Fragment() {

    private val viewModel: SuperheroViewModel by hiltNavGraphViewModels(R.id.nav_graph)//by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                viewModel.fetchSuperHeroes()
                SuperHeroAppTheme {
                    MainContent(this)
                }
            }
        }
    }

    @Composable
    fun MainContent(composeView: ComposeView) {
        val superheroList = viewModel.superheroesState.collectAsState().value

        Column {
            SearchView(context = composeView.context) { viewModel.getSearchedSuperHeroes(it) }
            if (superheroList.isEmpty()) {
                SuperHeroEmptyList()
            } else {
                SuperHeroList(superheroList = superheroList, composeView = composeView)
            }
        }
    }

    @Composable
    fun SuperHeroEmptyList(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = Color.LightGray)
        ) {
            Text(
                text = "No superheros found",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .semantics {
                        contentDescription = "No superheros found"
                    }
            )
        }
    }

    @Composable
    fun SuperHeroList(superheroList: List<Superhero>, composeView: ComposeView) {
        LazyColumn() {
            items(superheroList) { superHero ->
                SuperHeroItemView(superHero, onClick = { superHeroId ->
                    composeView.findNavController().navigate(
                        SuperheroListScreenDirections.actionSuperheroListScreenToSuperheroDetailScreen(
                            superHeroId
                        )
                    )

                })
            }
        }
    }
}