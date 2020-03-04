package net.azarquiel.retrofitcajonbindig.api
import kotlinx.coroutines.Deferred
import net.azarquiel.retrofitcajonbindig.model.Respuesta
import net.azarquiel.retrofitcajonbindig.model.Usuario
import retrofit2.Response
import retrofit2.http.*

interface BarService {
    // idbar en la url
    @GET("bar/{idbar}")
    fun getDataBar(@Path("idbar") idbar: Int): Deferred<Response<Respuesta>>

    @GET("bar")
    fun getDataBares(): Deferred<Response<Respuesta>>


    // nick y pass como variables en la url?nick=paco&pass=paco
    @GET("usuario")
    fun getDataUsuarioPorNickPass(
        @Query("nick") nick: String,
        @Query("pass") pass: String): Deferred<Response<Respuesta>>

    // post con objeto en json
    @POST("usuario")
    fun saveUsuario(@Body usuario: Usuario): Deferred<Response<Respuesta>>

    // post con variables sueltas
    @FormUrlEncoded
    @POST("bar/{idbar}/puntos")
    fun savePuntos(@Path("idbar") idbar: Int,
                   @Field("idusuario") idusuario: Int,
                   @Field("puntos") puntos: Int): Deferred<Response<Respuesta>>

    @FormUrlEncoded
    @POST("bar")
    fun saveBar(@Field("nombrebar") nombrebar: String,
                   @Field("direccion") direccion: String,
                   @Field("municipio") municipio: String,
                   @Field("provincia") provincia: String
                   ): Deferred<Response<Respuesta>>


// ……..   resto de métodos de la interfaz ………..

}