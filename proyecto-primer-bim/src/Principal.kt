import javax.swing.*
import java.io.File
import java.io.IOException


val categorias: Array<Any> = arrayOf("Videojuegos", "Venta")
val opciones: Array<Any> = arrayOf("Insertar", "Consultar", "Modificar", "Eliminar")

    fun main(args: Array<String>) {


        do {
            val result = JOptionPane.showOptionDialog(
                null,
                "Bienvenido al catálogo de videojuegos\nSeleccione una opción",
                "Catálogo de Videojuegos",
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
                            consultarVideojuego(codJuego)
                        }
                        2 -> {
                            val codJuego =
                                JOptionPane.showInputDialog("Ingrese el Código del videojuego a modificar")
                            val nomJuego = JOptionPane.showInputDialog("Ingrese el Nombre del videojuego")
                            val precioJuego = JOptionPane.showInputDialog("Ingrese el Precio del videojuego")
                            val genJuego = JOptionPane.showInputDialog("Ingrese el Género del videojuego")
                            val clasifJuego = JOptionPane.showInputDialog("Ingrese la Clasificación del videojuego")
                            val platJuego = JOptionPane.showInputDialog("Ingrese la Plataforma del videojuego")
                            val distJuego = JOptionPane.showInputDialog("Ingrese la Distribuidora del videojuego")

                            JOptionPane.showMessageDialog(null, "Datos de Videojuego modificados")
                        }
                        3 -> {
                            val codJuego =
                                JOptionPane.showInputDialog("Ingrese el Código del videojuego a eliminar")

                            eliminarVideojuego(codJuego)
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
                            consultarVenta(codVenta)
                        }
                        2 -> {

                            val codVenta = JOptionPane.showInputDialog("Ingrese el Código de la venta a modificar")
                            val cedCliente = JOptionPane.showInputDialog("Ingrese el número de cédula del cliente")
                            val fecha = JOptionPane.showInputDialog("Ingrese la fecha de la venta")
                            val descripcion = JOptionPane.showInputDialog("Ingrese la descripción de la venta")
                            val total = JOptionPane.showInputDialog("Ingrese el total de la venta")

                            JOptionPane.showMessageDialog(null, "Datos de venta modificados")
                        }
                        3 -> {
                            val codVenta =
                                JOptionPane.showInputDialog("Ingrese el Código de la venta a eliminar")
                            eliminarVenta(codVenta)
                        }

                    }
                }

            }
        }while(result in 0..3)
    }






fun ingresarVideojuego() {
    val listaVideojuego = arrayListOf<Videojuego>()
        try {
            var juego = Videojuego("null","null",0.0,"null","null","null","null")
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
    consultarVideojuego2(codigo)?.forEach { it ->

        registro +="Código: ${it.codigoVideojuego}\n"+"Nombre: ${it.nombreVideojuego}\n"+"Precio: ${it.precio}\n" +
                "Género: ${it.genero}\n"+"Clasificación: ${it.clasificacion}\n"+"Plataforma: ${it.plataforma}\n" +
                "Distribuidora: ${it.distribuidora}\n\n"
        cont++
    }
    JOptionPane.showMessageDialog(null,registro,"Resultado consulta",1,null)

    println(registro)


}



fun consultarVideojuego2(codigo: String): List<Videojuego>?{
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
    val juegoElim = consultarVideojuego2(codigo)
    val listaVideojuego = ArrayList<Videojuego>()
    if (juegoElim != null) {
        leerContenidoVideojuego("baseVideojuegos.txt").forEach {
            if(it.codigoVideojuego != juegoElim[0].codigoVideojuego){
                listaVideojuego.add(it)
            }
        }

        var registro = ""
        var text = ""
        listaVideojuego.forEach { it ->
            registro +="Código: ${it.codigoVideojuego}\n"+"Nombre: ${it.nombreVideojuego}\n"+"Precio: ${it.precio}\n" +
                    "Género: ${it.genero}\n"+"Clasificación: ${it.clasificacion}\n"+"Plataforma: ${it.plataforma}\n" +
                    "Distribuidora: ${it.distribuidora}\n\n"
            text+="${it.codigoVideojuego},${it.nombreVideojuego},${it.precio},${it.genero},${it.clasificacion},${it.plataforma},${it.distribuidora}\n"
        }

        sobreescribirArchivo(text, "baseVideojuegos.txt")

        JOptionPane.showMessageDialog(null, "Videojuego eliminado")
        leerContenidoVideojuego("baseVideojuegos.txt")

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
        leerContenidoVideojuego("baseVentas.txt")

        JOptionPane.showMessageDialog(null, "Venta registrada")

    } catch (e: Exception){
        //JOptionPane.showMessageDialog(null, "Error al ingresar datos")
    }
}





fun consultarListaVentas() {
    val listaVenta = arrayListOf<Venta>()
    var venta: String = ""
    for (item: Venta in listaVenta) {
        venta += item.toString()
    }
    JOptionPane.showMessageDialog(null, venta)
}

fun consultarVenta(codigo: String){
    var registro = ""
    var cont = 0
    consultarVenta2(codigo)?.forEach { it ->

        registro +="Código: ${it.codigoVenta}\n"+"Cédula cliente: ${it.cedulaCliente}\n"+"Fecha de la venta: ${it.fechaVenta}\n" +
                "Descripcióm: ${it.descripcion}\n"+"Total: ${it.total}\n\n"
        cont++
    }
    JOptionPane.showMessageDialog(null,registro,"Resultado consulta",1,null)

    println(registro)


}




fun consultarVenta2(codigo: String): List<Venta>?{
    leerContenidoVenta("baseVentas.txt").forEach {
        when(codigo){
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
    val ventaElim = consultarVenta2(codigo)
    val listaVenta = ArrayList<Venta>()
    if (ventaElim != null) {
        leerContenidoVenta("baseVentas.txt").forEach {
            if(it.codigoVenta != ventaElim[0].codigoVenta){
                listaVenta.add(it)
            }
        }

        var registro = ""
        var text = ""
        listaVenta.forEach { it ->
            registro +="Código: ${it.codigoVenta}\n"+"Cédula cliente: ${it.cedulaCliente}\n"+"Fecha de la venta: ${it.fechaVenta}\n" +
                    "Descripcióm: ${it.descripcion}\n"+"Total: ${it.total}\n\n"

            text+="${it.codigoVenta},${it.cedulaCliente},${it.fechaVenta},${it.descripcion},${it.total}\n"
        }

        sobreescribirArchivo(text, "baseVentas.txt")

        JOptionPane.showMessageDialog(null, "Venta eliminada")
        leerContenidoVenta("baseVentas.txt")

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

