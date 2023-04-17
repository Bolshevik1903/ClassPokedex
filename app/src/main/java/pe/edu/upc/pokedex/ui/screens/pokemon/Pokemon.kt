package pe.edu.upc.pokedex.ui.screens.pokemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import pe.edu.upc.pokedex.R
import pe.edu.upc.pokedex.data.remote.Pokemon

@Composable
fun Pokemon(pokemon: Pokemon){
    val frontDefault = pokemon.sprites.front_default
    Column {
        Text(text = "Name: ${pokemon.name}")
        Text(text = "Weight: ${pokemon.weight}")
        Text(text = "Height: ${pokemon.height}")
        AsyncImage(
            model = "${pokemon.sprites.front_default}",
            contentDescription = "Pokemon's sprite",
            modifier = Modifier.size(250.dp)
        )
        //Image(painter = rememberAsyncImagePainter(pokemon.sprites.front_default), contentDescription =  "Pokemon's sprite")
    }
}