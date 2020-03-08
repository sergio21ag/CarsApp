package net.azarquiel.carsapp.model

import java.io.Serializable

data class Coche(
    var idcoche: Int,
    var modelo: String,
    var kilometros: String,
    var ano: String,
    var precio: String,
    var combustible: String,
    var potencia: String
): Serializable

data class Usuario (
    var idusuario: Int,
    var nick: String,
    var pass: String
):Serializable

data class Favoritos (
    var idcoche: Int,
    var idusuario: Int
)

data class Modelo (
    var modelo: String
)

data class Respuesta (
    val coche: Coche,
    val modelo: List<Modelo>,
    val coches: List<Coche>,
    val usuario: Usuario,
    val favoritos: Favoritos
)