class Videojuego (
    var codigoVideojuego: String,
    var nombreVideojuego: String,
    var precio: Double,
    var genero: String,
    var clasificacion: String,
    var plataforma: String,
    var distribuidora: String
){

    //private var listaVideojuegos = arrayListOf<Videojuego>()


    override fun toString(): String {
        return "Videojuego(codigoVideojuego='$codigoVideojuego', nombreVideojuego='$nombreVideojuego', precio='$precio', genero='$genero', clasificacion='$clasificacion', plataforma='$plataforma', distribuidora='$distribuidora')"
    }

    fun registroVideojuego(): String{
        return "\n"+codigoVideojuego+","+nombreVideojuego+","+precio+","+genero+","+clasificacion+","+plataforma+","+distribuidora
    }

}



