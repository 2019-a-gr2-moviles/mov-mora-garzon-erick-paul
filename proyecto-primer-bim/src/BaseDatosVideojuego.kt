import java.io.File
import java.io.Serializable

class BaseDatosVideojuego:Serializable{

    /*companion object {
        var videojuegos: ArrayList<Videojuego>
        fun agregarVideojuego(videojuego:Int){
            this.videojuegos.add(videojuego)
        }
        fun eliminarVideojuego(videojuego:Int){
            this.videojuegos.remove(videojuego)
        }


    }*/

    fun leerContenido(/*args: Array<String>*/) {
    val fileName = "src/baseVideojuegos.txt"

        val lines: List<String> = File(fileName).readLines()

        lines.forEach { line -> println(line) }
    }
}