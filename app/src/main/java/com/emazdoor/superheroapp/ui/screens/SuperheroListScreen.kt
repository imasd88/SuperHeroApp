package com.emazdoor.superheroapp.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.findNavController
import com.emazdoor.superheroapp.R
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
                    val tempList = viewModel.superheroesState.collectAsState().value
                    var textValue by remember { mutableStateOf(TextFieldValue()) }
                    Column() {
                        BasicTextField(
                            value = textValue,
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            onValueChange = {
                                textValue = it
                                viewModel.getSearchedSuperHeroes(it.text)
                            }
                        )
                        LazyColumn() {
                            items(tempList) {
                                SuperHeroItemView(it, onClick = {
                                    findNavController().navigate(
                                        SuperheroListScreenDirections.actionSuperheroListScreenToSuperheroDetailScreen(
                                            it
                                        )
                                    )
                                })
                            }
                        }
                    }
                }
            }
        }
    }
}