package pe.edu.upc.pokedex.ui.screens.pokemons

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.upc.pokedex.data.remote.Pokemon
import pe.edu.upc.pokedex.ui.theme.PokedexTheme

@Composable
fun Pokemon(pokemons: List<Pokemon>, selectPokemon: (String) -> Unit) {
    LazyColumn(){

        items(pokemons){
            PokemonItem(it, selectPokemon)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PokemonItem(pokemon: Pokemon, selectPokemon: (String) -> Unit) {
    Card(
        onClick = {
            selectPokemon(getId(pokemon.url))
        }) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
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
