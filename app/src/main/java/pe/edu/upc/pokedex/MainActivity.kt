package pe.edu.upc.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.upc.pokedex.data.remote.Pokemon
import pe.edu.upc.pokedex.data.remote.PokemonClient
import pe.edu.upc.pokedex.data.remote.PokemonResponse
import pe.edu.upc.pokedex.ui.screens.pokemon.Pokemon
import pe.edu.upc.pokedex.ui.theme.PokedexTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    var pokemons : List<Pokemon> by mutableStateOf(listOf())
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                // A surface container using the 'background' color from the theme
                loadPokemon()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Pokemon(pokemons = pokemons!!)
                }
            }
        }
    }

    private fun loadPokemon() {
        val pokemonInterface = PokemonClient.build()
        val getPokemons = pokemonInterface.getPokemons()

        getPokemons.enqueue(object: Callback<PokemonResponse> {
            override fun onResponse(
                call: Call<PokemonResponse>,
                response: Response<PokemonResponse>
            ) {
                if(response.isSuccessful) {
                    pokemons = response.body()?.pokemons!!
                }
            }

            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PokedexTheme {
        Greeting("Android")
    }
}