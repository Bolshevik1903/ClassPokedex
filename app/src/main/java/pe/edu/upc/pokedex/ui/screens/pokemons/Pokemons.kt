package pe.edu.upc.pokedex.ui.screens.pokemons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import pe.edu.upc.pokedex.data.remote.Pokemon
import pe.edu.upc.pokedex.ui.theme.PokedexTheme

@Composable
fun Pokemon(pokemons: List<Pokemon>, selectPokemon: (String) -> Unit) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {

        itemsIndexed(pokemons){index, item ->
            PokemonItem(item, index){
                selectPokemon("${index + 1}")
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PokemonItem(pokemon: Pokemon, index: Int, selectPokemon: (String) -> Unit) {
    Card(
        elevation = 2.dp,
        onClick = {
            selectPokemon(getId(pokemon.url))
        }) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${index + 1}.png",
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            Text(text = pokemon.name)
        }
    }
}

fun getId(url: String): String {
    val URL = url
    val arr = URL.split("/")
    val id = arr[arr.size - 2]
    return id
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PokemonPreview() {
    PokedexTheme {

    }
}