package net.azarquiel.carsapp.api
import kotlinx.coroutines.Deferred
import net.azarquiel.carsapp.model.Usuario
import net.azarquiel.carsapp.model.Respuesta
import retrofit2.Response
import retrofit2.http.*

interface CarService {
    // idcoche en la url
    @GET("coches/{idcoche}")
    fun getDataCar(@Path("idcoche") idcoche: Int): Deferred<Response<Respuesta>>

    @GET("coche")
    fun getDataCar(): Deferred<Response<Respuesta>>


    // nick y pass como variables en la url?nick=admin&pass=admin
    @GET("usuario")
    fun getDataUsuarioPorNickPass(
        @Query("nick") nick: String,
        @Query("pass") pass: String): Deferred<Response<Respuesta>>

    // post con objeto en json
    @POST("usuario")
    fun saveUsuario(@Body usuario: Usuario): Deferred<Response<Respuesta>>

    // post con variables sueltas
    @FormUrlEncoded
    @POST("coche/{idcoche}/favoritos")
    fun savePuntos(@Path("idcoche") idbar: Int,
                   @Field("idusuario") idusuario: Int,
                   @Field("favoritos") favoritos: Int): Deferred<Response<Respuesta>>

    @FormUrlEncoded
    @POST("coche")
    fun saveCar(@Field("modelo") modelo: String,
                   @Field("kilometros") kilometros: String,
                   @Field("ano") ano: String,
                   @Field("precio") precio: String,
                   @Field("combustible") combustible: String,
                   @Field("potencia") potencia: String
                   ): Deferred<Response<Respuesta>>


// ……..   resto de métodos de la interfaz ………..

}