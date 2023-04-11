package pe.edu.upc.pokedex.ui.screens.pokemon

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.upc.pokedex.Greeting
import pe.edu.upc.pokedex.ui.theme.PokedexTheme

@Composable
fun Pokemon() {
    LazyColumn(){
        val pokemons = arrayListOf<String>("Bagon","Shelgon", "Salamence")
        items(pokemons){
            PokemonItem(it)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PokemonItem(pokemon: String) {
    Card(onClick = { /*TODO*/ }) {
        Row() {
            Text(text = pokemon)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PokemonPreview() {
    PokedexTheme {
        Pokemon()
    }
}
