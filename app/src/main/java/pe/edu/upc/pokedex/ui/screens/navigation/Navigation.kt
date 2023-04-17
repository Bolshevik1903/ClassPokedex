package pe.edu.upc.pokedex.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pe.edu.upc.pokedex.data.remote.Pokemon
import pe.edu.upc.pokedex.data.remote.PokemonClient
import pe.edu.upc.pokedex.data.remote.PokemonResponse
import pe.edu.upc.pokedex.data.remote.Sprites
import pe.edu.upc.pokedex.ui.screens.pokemons.Pokemon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun Navigation() {
    val navControlller = rememberNavController()
    NavHost(navController = navControlller, startDestination = "pokemons") {
        composable(route = "pokemons") {

            //var pokemons by remember { mutableListOf<Pokemon>()}
            var pokemons = remember { mutableStateOf(emptyList<Pokemon>()) }

            val pokemonInterface = PokemonClient.build()
            val getPokemons = pokemonInterface.getPokemons()

            getPokemons.enqueue(object: Callback<PokemonResponse> {
                override fun onResponse(
                    call: Call<PokemonResponse>,
                    response: Response<PokemonResponse>
                ) {
                    if(response.isSuccessful) {
                        pokemons.value = response.body()?.pokemons!!
                    }
                }

                override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })

            Pokemon(pokemons = pokemons.value) {
                navControlller.navigate("pokemon/$it")
            }
        }
        
        composable(
            route = "pokemon/{index}",
            arguments = listOf(navArgument("index"){type= NavType.StringType})
        ) {
            val index = it.arguments?.getString("index") as String

            var pokemon = remember { mutableStateOf(Pokemon("",0,0,"",Sprites("")))}

            val pokemonInterface = PokemonClient.build()
            val getPokemon = pokemonInterface.getPokemon(index)

            getPokemon.enqueue(object: Callback<Pokemon> {
                override fun onResponse(
                    call: Call<Pokemon>,
                    response: Response<Pokemon>
                ) {
                    if(response.isSuccessful) {
                        pokemon.value = response.body()!!
                    }
                }

                override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })

            pe.edu.upc.pokedex.ui.screens.pokemon.Pokemon(pokemon = pokemon.value)
        }
    }
}