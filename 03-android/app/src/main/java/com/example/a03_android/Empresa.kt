package com.example.a03_android

import java.util.*
import kotlin.collections.ArrayList

class Empresa(
    val id:Int,
    var nombre: String,
    var createdAt: Long,
    var updatedAt: Long/*,
    var usuariosDeEmpresa: ArrayList<UsuarioEmpresa>*/
) {
    var fechaCreacion: Date
    var fechaActualizacion: Date
    init {
        fechaCreacion = Date(createdAt)
        fechaActualizacion = Date(updatedAt)
    }
}