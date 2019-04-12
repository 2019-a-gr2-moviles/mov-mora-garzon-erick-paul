import java.util.*

fun main(args : Array<String>) {
    //Variables

    /*
    Comentario
     */

    var nombre = "Erick"
    nombre = "Paúl"

    val nombreI = "Erick"
    //nombreI = "Paúl"

    val apellido: String = "Mora"
    val edad: Int = 22
    val sueldo: Double = 1.21
    val casado: Boolean = false
    val estudiante: Boolean = true
    val hijos = null

    // Condicionales

    if(apellido == "Mora" || nombre =="Erick"){
        println("Verdadero")

    }else{
        println("Falso")
    }

    val tieneNombreYApellido = if (apellido!=null && nombre!=null) "ok" else "no"
    println(tieneNombreYApellido)
    estaJalado( 1.0)
    estaJalado( 8.0)
    estaJalado( 10.0)
    estaJalado( 0.0)
    estaJalado( 7.0)
    holaMundo("Erick")
    holaMundoAvanzado(2)
    val total = sumarDosNumeros(1, 3)
    println(total)

    //val arregloCumpleanos = Array<Int>(1, 1)

    val arregloCumpleanos: Array<Int> = arrayOf(1, 2, 3, 4)

    val arregloTodo: Array<Any> = arrayOf(1, "asd", 10.2, true)

    //arregloCumpleaños[0] = 5
    //arregloCumpleaños.set(0, 5)

    //arregloCumpleaños= arrayOf(5, 2, 3, 4)

    /*val fecha = Date()
    fecha.time = 11231231
    fecha.year = 2000
    fecha = Date(1989, 6, 10)*/

    val notas = arrayListOf(1, 2 ,3, 4, 5, 6)
    //val notas: ArrayList<Int> = arrayListOf<Int>(1,2,3,4,5,6)

    /*notas.forEach{ nota: Int ->
        println(nota)
    }*/

    //For Each -> Itera el arreglo
    notas.forEachIndexed { indice, nota ->
        println("Indice: $indice")
        println("Nota: $nota")

    }

    //Map itera y modifica el arreglo
    //Impares + 1, Pares + 2
    /*val notasDos = notas.map { nota ->
        //nota = nota + 1
        nota + 1
    }*/

    val notasDos = notas.map { nota ->
        //nota = nota + 1
        /*if(nota%2 == 0)
            nota + 2
        else
            nota + 1*/

        val modulo = nota % 2
        val esPar = 0

        when(modulo){
            esPar -> {
                nota + 1
            }
            else -> {
                nota + 2
            }
        }
    }

    notasDos.forEach {
        println("Notas 2: $it")
    }


    val respuestaFilter = notas
        .filter {//filtra el arreglo
        //it > 2
        //it < 5 && it > 2
        it in 3..4
    }.map {//Mutar o cambiar el arreglo
        it * 2
    }

    respuestaFilter.forEach { println(it) }

    //buscar un elemento
    val novias = arrayListOf(1,2,2,3,4,5)

    val respuestaNovia = novias.any{
        it == 3
    }

    println(respuestaNovia) // true
    println(respuestaNovia) // false

    val tazos = arrayListOf(1,2,3,4,5,6,7)

    val respuestaTazos = tazos.all {
        it>1
    }

    println(respuestaTazos) // falso


    val totalTazos = tazos.reduce { valorAcumulado, tazo ->
        valorAcumulado + tazo
    }
    println(totalTazos)

}

fun estaJalado(nota:Double):Unit{
    when (nota){

        7.0 ->{
            println("Pasaste con las justas")
        }
        10.0 ->{
            println("Genial :D felicitaciones")

        }
        0.0 ->{
            println("Dios mio que vago!")

        }
        else ->{
            println("Tu nota es: $nota")
            println("Tu nota es: ${nota}")
        }

    }

}

fun holaMundo(mensaje: String):Unit{
    println("Mensaje: $mensaje.")
}


fun holaMundoAvanzado(mensaje: Any):Unit{
    println("Mensaje: $mensaje.")
}

fun sumarDosNumeros(numUno: Int, numDos: Int): Int{
    return numUno+numDos
}





