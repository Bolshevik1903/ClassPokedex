package pe.edu.upc.pokedex.data.remote

import com.google.gson.annotations.SerializedName

data class Pokemon(
    val name: String,
    val height: Int,
    val weight: Int,
    val url: String,
    val sprites: Sprites
)

data class PokemonResponse(
    @SerializedName("results")
    val pokemons: ArrayList<Pokemon>
)

data class Sprites(
    val front_default: String
)