package pe.edu.upc.pokedex.data.remote

import retrofit2.Call
import retrofit2.http.GET

//Una interface solo declara los metodos
interface PokemonInterface {
    @GET("pokemon")
    fun getPokemons(): Call<PokemonResponse>
}