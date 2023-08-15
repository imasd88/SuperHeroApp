package com.emazdoor.superheroapp.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.findNavController
import com.emazdoor.superheroapp.R
import com.emazdoor.superheroapp.ui.components.CircularBackground
import com.emazdoor.superheroapp.ui.components.Header
import com.emazdoor.superheroapp.ui.components.ImageArt
import com.emazdoor.superheroapp.ui.components.fallbackAlbumArtDrawable
import com.emazdoor.superheroapp.ui.theme.SuperHeroAppTheme
import com.emazdoor.superheroapp.viewmodel.SuperheroViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SuperheroDetailScreen : Fragment() {

    private val viewModel: SuperheroViewModel by hiltNavGraphViewModels(R.id.nav_graph)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            val superHeroId = arguments?.getInt("superHeroId")
            superHeroId?.let { id ->
                viewModel.getTheSuperHero(id)
            }
            setContent {
                val superhero = viewModel.superheroesState.collectAsState().value.first()
                SuperHeroAppTheme {
                    Column {
                        Header(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(64.dp)
                        ) {
                            it.apply {
                                Text(
                                    text = "< ${superhero.name}",
                                    Modifier.align(Alignment.CenterStart).clickable {
                                        findNavController().popBackStack()
                                    }
                                )
                                Text(
                                    text = "${superhero.biography.fullName}",
                                    Modifier.align(Alignment.Center)
                                )
                            }
                        }
                        CircularBackground(
                            modifier = Modifier
                                .aspectRatio(1f)
                                .padding(24.dp), elevation = 8.dp
                        )
                        {
                            ImageArt(
                                url = superhero.images.lg,
                                modifier = Modifier.height(100.dp),
                                fallback = fallbackAlbumArtDrawable(),
                                contentDescription = "${superhero.name} Image"
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewSuperheroDetailScreen() {
    SuperHeroAppTheme {
        Column {
            Header(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
            ) {
                it.apply {
                    Text(text = "< Marvel", Modifier.align(Alignment.CenterStart))
                    Text(
                        text = "Hello, world!", Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }
}