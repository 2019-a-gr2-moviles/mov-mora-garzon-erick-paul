import javax.swing.*
import java.io.File
import java.io.IOException

val categorias: Array<Any> = arrayOf("Videojuegos", "Venta")
val opciones: Array<Any> = arrayOf("Insertar", "Consultar", "Modificar", "Eliminar")

    fun main(args: Array<String>) {
        do {
            val result = JOptionPane.showOptionDialog(
                null,
                "Bienvenido a la tienda de videojuegos\nSeleccione una opción",
                "Tienda de Videojuegos",
                1,
                1,
                null,
                categorias,
                null
            )
            when (result) {
                0 -> {
                    val result2 = JOptionPane.showOptionDialog(
                        null,
                        "Seleccione una opción",
                        "Videojuegos",
                        1,
                        1,
                        null,
                        opciones,
                        null
                    )
                    when (result2) {
                        0 -> {
                            ingresarVideojuego()
                        }
                        1 -> {
                            val codJuego = JOptionPane.showInputDialog("Ingrese el Código del videojuego a buscar")
                            if(codJuego!=null) {
                                consultarVideojuego(codJuego)
                            }
                        }
                        2 -> {
                            val codJuego =
                                JOptionPane.showInputDialog("Ingrese el Código del videojuego a modificar")

                            if(codJuego!=null) {
                                modificarVideojuego(codJuego)
                            }
                        }
                        3 -> {
                            val codJuego =
                                JOptionPane.showInputDialog("Ingrese el Código del videojuego a eliminar")
                            if(codJuego!=null) {
                                if(consultarVideojuegoExiste(codJuego)!=null){
                                    eliminarVideojuego(codJuego)
                                    JOptionPane.showMessageDialog(null, "Videojuego eliminado")
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "Videojuego no encontrado")
                                }
                            }

                        }

                    }
                }
                1 -> {
                    val result2 = JOptionPane.showOptionDialog(
                        null,
                        "Seleccione una opción",
                        "Venta",
                        1,
                        1,
                        null,
                        opciones,
                        null
                    )
                    when (result2) {
                        0 -> {
                            ingresarVenta()
                        }
                        1 -> {
                            val codVenta = JOptionPane.showInputDialog("Ingrese el Código de la venta a buscar")
                            if(codVenta!=null) {
                                consultarVenta(codVenta)
                            }
                        }
                        2 -> {
                            val codVenta = JOptionPane.showInputDialog("Ingrese el Código de la venta a modificar")

                            if(codVenta!=null) {
                                modificarVenta(codVenta)
                            }
                        }
                        3 -> {
                            val codVenta =
                                JOptionPane.showInputDialog("Ingrese el Código de la venta a eliminar")
                            if(codVenta!=null) {
                                if(consultarVentaExiste(codVenta)!=null){
                                    eliminarVenta(codVenta)
                                    JOptionPane.showMessageDialog(null, "Venta eliminada")
                                }
                                else{
                                JOptionPane.showMessageDialog(null, "Venta no encontrada")
                                }
                            }
                        }
                    }
                }
            }
        }while(result in 0..3)
    }






fun ingresarVideojuego() {
    val listaVideojuego = arrayListOf<Videojuego>()
        try {
            val juego = Videojuego("null","null",0.0,"null","null","null","null")
            juego.codigoVideojuego = JOptionPane.showInputDialog("Ingrese el Código del videojuego")
            juego.nombreVideojuego = JOptionPane.showInputDialog("Ingrese el Nombre del videojuego")
            juego.precio = (JOptionPane.showInputDialog("Ingrese el Precio del videojuego")).toDouble()
            juego.genero = JOptionPane.showInputDialog("Ingrese el Género del videojuego")
            juego.clasificacion = JOptionPane.showInputDialog("Ingrese la Clasificación del videojuego")
            juego.plataforma = JOptionPane.showInputDialog("Ingrese la Plataforma del videojuego")
            juego.distribuidora = JOptionPane.showInputDialog("Ingrese la Distribuidora del videojuego")

            leerContenidoVideojuego("baseVideojuegos.txt")
            println(juego.toString())
            listaVideojuego.add(juego)
            escribirArchivo(juego.registroVideojuego(),"baseVideojuegos.txt")
            leerContenidoVideojuego("baseVideojuegos.txt")

            JOptionPane.showMessageDialog(null, "Videojuego registrado")

        } catch (e: Exception){
            JOptionPane.showMessageDialog(null, "Error al ingresar datos")
        }
}







fun consultarListaVideojuegos() {
    val listaVideojuego = arrayListOf<Videojuego>()
    var juego: String = ""
    for (item: Videojuego in listaVideojuego) {
        juego += item.toString()
    }
    JOptionPane.showMessageDialog(null, juego)
}

fun consultarVideojuego(codigo: String){
    var registro = ""
    var cont = 0
    val listaVideojuego = consultarVideojuegoExiste(codigo)
    if(listaVideojuego!=null){
        listaVideojuego.forEach {
            registro +="Código: ${it.codigoVideojuego}\n"+"Nombre: ${it.nombreVideojuego}\n"+"Precio: ${it.precio}\n" +
                "Género: ${it.genero}\n"+"Clasificación: ${it.clasificacion}\n"+"Plataforma: ${it.plataforma}\n" +
                "Distribuidora: ${it.distribuidora}\n\n"
            cont++
        }
    JOptionPane.showMessageDialog(null,registro,"Resultado consulta",1,null)
    println(registro)
    }
    else{
        JOptionPane.showMessageDialog(null, "Videojuego no encontrado")
    }


}



fun consultarVideojuegoExiste(codigo: String): List<Videojuego>?{
    leerContenidoVideojuego("baseVideojuegos.txt").forEach {
        when(codigo){
            it.codigoVideojuego -> {
                return leerContenidoVideojuego("baseVideojuegos.txt").filter { juego ->
                    juego.codigoVideojuego == codigo
                }
            }
        }
    }
    return null
}



fun eliminarVideojuego(codigo: String){
    val juegoElim = consultarVideojuegoExiste(codigo)
    val listaVideojuego = ArrayList<Videojuego>()
    if (juegoElim != null) {
        leerContenidoVideojuego("baseVideojuegos.txt").forEach {
            if(it.codigoVideojuego != juegoElim[0].codigoVideojuego){
                listaVideojuego.add(it)
            }
        }

        var text = ""
        listaVideojuego.forEach {
            text+="${it.codigoVideojuego},${it.nombreVideojuego},${it.precio},${it.genero},${it.clasificacion},${it.plataforma},${it.distribuidora}\n"
        }

        sobreescribirArchivo(text, "baseVideojuegos.txt")
        leerContenidoVideojuego("baseVideojuegos.txt")
    }
    else{
        JOptionPane.showMessageDialog(null,"Videojuego no encontrado")
    }
}


fun modificarVideojuego(codigo: String){

    val listaVideojuego = consultarVideojuegoExiste(codigo)
    var text = ""

    if (listaVideojuego != null) {
        eliminarVideojuego(codigo)

        listaVideojuego[0].nombreVideojuego = JOptionPane.showInputDialog("Ingrese el Nombre del videojuego")
        listaVideojuego[0].precio = (JOptionPane.showInputDialog("Ingrese el Precio del videojuego")).toDouble()
        listaVideojuego[0].genero = JOptionPane.showInputDialog("Ingrese el Género del videojuego")
        listaVideojuego[0].clasificacion = JOptionPane.showInputDialog("Ingrese la Clasificación del videojuego")
        listaVideojuego[0].plataforma = JOptionPane.showInputDialog("Ingrese la Plataforma del videojuego")
        listaVideojuego[0].distribuidora = JOptionPane.showInputDialog("Ingrese la Distribuidora del videojuego")

        listaVideojuego.forEach {
            text+="${it.codigoVideojuego},${it.nombreVideojuego},${it.precio},${it.genero},${it.clasificacion},${it.plataforma},${it.distribuidora}\n"
        }

        escribirArchivo(text, "baseVideojuegos.txt")
        leerContenidoVideojuego("baseVideojuegos.txt")

        JOptionPane.showMessageDialog(null, "Datos de Videojuego modificados")
    }
    else{
        JOptionPane.showMessageDialog(null,"Videojuego no encontrado")
    }
}



fun ingresarVenta() {
    val listaVenta = arrayListOf<Venta>()
    try {
        var venta = Venta("null","null","null","null",0.0)
        venta.codigoVenta = JOptionPane.showInputDialog("Ingrese el Código de la venta")
        venta.cedulaCliente = JOptionPane.showInputDialog("Ingrese el número de cédula del cliente")
        venta.fechaVenta = JOptionPane.showInputDialog("Ingrese la fecha de la venta")
        venta.descripcion = JOptionPane.showInputDialog("Ingrese la descripción de la venta")
        venta.total = (JOptionPane.showInputDialog("Ingrese el total de la venta")).toDouble()


        leerContenidoVenta("baseVentas.txt")
        println(venta.toString())
        listaVenta.add(venta)
        escribirArchivo(venta.registroVenta(),"baseVentas.txt")
        leerContenidoVenta("baseVentas.txt")

        JOptionPane.showMessageDialog(null, "Venta registrada")

    } catch (e: Exception){
        JOptionPane.showMessageDialog(null, "Error al ingresar datos")
    }
}





fun consultarListaVentas() {
    val listaVenta = arrayListOf<Venta>()
    var venta = ""
    for (item: Venta in listaVenta) {
        venta += item.toString()
    }
    JOptionPane.showMessageDialog(null, venta)
}

fun consultarVenta(codigo: String){
    var registro = ""
    var cont = 0
    val listaVenta = consultarVentaExiste(codigo)
    if(listaVenta!=null){

    listaVenta.forEach {
        registro +="Código: ${it.codigoVenta}\n"+"Cédula cliente: ${it.cedulaCliente}\n"+"Fecha de la venta: ${it.fechaVenta}\n" +
                "Descripción: ${it.descripcion}\n"+"Total: ${it.total}\n\n"
        cont++
    }
    JOptionPane.showMessageDialog(null,registro,"Resultado consulta",1,null)

    //println(registro)
    }
    else{
        JOptionPane.showMessageDialog(null, "Venta no encontrada")
    }

}




fun consultarVentaExiste(codigo: String): List<Venta>?{
    leerContenidoVenta("baseVentas.txt").forEach {
        when (codigo) {
            it.codigoVenta -> {
                return leerContenidoVenta("baseVentas.txt").filter { venta ->
                    venta.codigoVenta == codigo
                }
            }
        }
    }
    return null
}




fun eliminarVenta(codigo: String){
    val ventaElim = consultarVentaExiste(codigo)
    val listaVenta = ArrayList<Venta>()
    if (ventaElim != null) {
        leerContenidoVenta("baseVentas.txt").forEach {
            if(it.codigoVenta != ventaElim[0].codigoVenta){
                listaVenta.add(it)
            }
        }

        var text = ""
        listaVenta.forEach {
            text+="${it.codigoVenta},${it.cedulaCliente},${it.fechaVenta},${it.descripcion},${it.total}\n"
        }

        sobreescribirArchivo(text, "baseVentas.txt")
        leerContenidoVenta("baseVentas.txt")
    }
    else{
        JOptionPane.showMessageDialog(null,"Venta no encontrada")
    }
}


fun modificarVenta(codigo: String){

    val listaVenta = consultarVentaExiste(codigo)
    var text = ""

    if (listaVenta != null) {
        eliminarVenta(codigo)

        listaVenta[0].cedulaCliente = JOptionPane.showInputDialog("Ingrese el número de cédula del cliente")
        listaVenta[0].fechaVenta = JOptionPane.showInputDialog("Ingrese la fecha de la venta")
        listaVenta[0].descripcion = JOptionPane.showInputDialog("Ingrese la descripción de la venta")
        listaVenta[0].total = (JOptionPane.showInputDialog("Ingrese el total de la venta")).toDouble()

        listaVenta.forEach {
            text+="${it.codigoVenta},${it.cedulaCliente},${it.fechaVenta},${it.descripcion},${it.total}\n"
        }

        escribirArchivo(text, "baseVentas.txt")
        leerContenidoVenta("baseVentas.txt")

        JOptionPane.showMessageDialog(null, "Datos de venta modificados")
    }
    else{
        JOptionPane.showMessageDialog(null,"Venta no encontrada")
    }
}












fun leerContenidoVideojuego(archivo:String): ArrayList<Videojuego> {
    val fileName = "src/"+archivo
    val listaVideojuego = arrayListOf<Videojuego>()

    val lines: List<String> = File(fileName).readLines()
    try {
        lines.forEach {
                line -> println(line)
            val juego = line.split(",")
            val registroVideojuego = Videojuego(juego[0],juego[1],juego[2].toDouble(),juego[3],juego[4],juego[5],juego[6])
            listaVideojuego.add(registroVideojuego)
        }
    } catch (e: IOException) {
        JOptionPane.showMessageDialog(null, "Error al leer el archivo")

    }
    return listaVideojuego
}

fun leerContenidoVenta(archivo:String): ArrayList<Venta> {
    val fileName = "src/"+archivo
    val listaVentas = arrayListOf<Venta>()

    val lines: List<String> = File(fileName).readLines()
    try {
        lines.forEach {
                line -> println(line)
            val venta = line.split(",")
            val registroVenta = Venta(venta[0],venta[1],venta[2],venta[3],venta[4].toDouble())
            listaVentas.add(registroVenta)
        }
    } catch (e: IOException) {
        JOptionPane.showMessageDialog(null, "Error al leer el archivo")

    }
    return listaVentas
}

fun escribirArchivo(args:String, archivo:String) {
    //val fileName = "src/baseVideojuegos.txt"
    val fileName = "src/"+archivo

    val myfile = File(fileName)
    try {
        myfile.appendText(args)
    } catch (e: IOException) {
        JOptionPane.showMessageDialog(null, "Error al escribir el archivo")

    }
}

fun sobreescribirArchivo(args:String, archivo:String) {
    //val fileName = "src/baseVideojuegos.txt"
    val fileName = "src/"+archivo

    val myfile = File(fileName)
    try {
        myfile.writeText(args)
    } catch (e: IOException) {
        JOptionPane.showMessageDialog(null, "Error al escribir el archivo")

    }
}

