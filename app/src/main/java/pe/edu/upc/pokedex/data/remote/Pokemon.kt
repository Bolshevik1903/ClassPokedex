package pe.edu.upc.pokedex.data.remote

import com.google.gson.annotations.SerializedName

data class Pokemon(
    val name: String
)

data class PokemonResponse(
    @SerializedName("results")
    val pokemons: ArrayList<Pokemon>
)