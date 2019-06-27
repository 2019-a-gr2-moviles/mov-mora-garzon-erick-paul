package com.example.a03_android

import java.util.*

class UsuarioEmpresa (
    val id:Int,
    var nombre: String,
    var createdAt: Long,
    var updatedAt: Long,
    var fkEmpresa: Int
) {
    var fechaCreacion: Date
    var fechaActualizacion: Date
    init {
        fechaCreacion = Date(createdAt)
        fechaActualizacion = Date(updatedAt)
    }
}