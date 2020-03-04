package net.azarquiel.carsapp.model

import java.io.Serializable

data class Coche(
    var idbar: Int,
    var nombrebar: String,
    var nombrelogo: String,
    var direccion: String,
    var latitud: String,
    var longitud: String,
    var municipio: String,
    var provincia: String,
    var codigopostal: String,
    var telefono: String,
    var descripcion: String,
    var especialidad: String,
    var recomendacion: String,
    var web: String,
    var twitter: String,
    var facebook: String,
    var google: String,
    var tripadvisor: String,
    var valormedio: String
): Serializable

data class Usuario (
    var idusuario: Int,
    var nick: String,
    var pass: String
):Serializable


data class Puntos (
    var id: Int,
    var idusuario: Int,
    var idbar: Int,
    var puntos: Int
)

data class Provincia (
    var provincia: String
)

