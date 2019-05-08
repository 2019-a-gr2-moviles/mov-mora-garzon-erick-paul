import java.io.File
import java.io.IOException
import java.io.Serializable
import javax.swing.*

class Videojuego (
            var codigo: String,
            var nombre: String,
            var precio: String,
            var genero: String,
            var clasificacion: String,
            var plataforma: String,
            var distribuidora: String
){
    /*private val btnInsJuego: JButton? = null
    private val btnConsJuego: JButton? = null
    private val btnActJuego: JButton? = null
    private val btnElimJuego: JButton? = null
    internal var panel: JPanel? = null*/

   // companion object {
        private var listaVideojuegos = arrayListOf<Videojuego>()

        fun agregarVideojuego(codigo: String,
                              nombre: String,
                              precio: String,
                              genero: String,
                              clasificacion: String,
                              plataforma: String,
                              distribuidora: String){
            this.listaVideojuegos.add(Videojuego(codigo, nombre, precio, genero, clasificacion, plataforma, distribuidora))

            val registroVideojuego = "\n"+codigo+","+nombre+","+precio+","+genero+","+clasificacion+","+plataforma+","+distribuidora+";"


            val fileName = "src/baseVideojuegos.txt"
            val myfile = File(fileName)

            myfile.appendText(registroVideojuego)
        }
        fun eliminarVideojuego(codigo: String){
            //this.listaVideojuegos.remove(Videojuego(codigo, nombre, precio, genero, clasificacion, plataforma, distribuidora))
        }

    fun consultarVideojuego(codigo: String): ArrayList<Videojuego>{
        //this.listaVideojuegos.

        return listaVideojuegos
    }
   // }
//


}

fun a(){
    var juego = Videojuego("","","","", "", "", "")
    juego.codigo = ""
    juego.nombre = ""
    juego.precio = ""
    juego.genero = ""
    juego.clasificacion = ""
    juego.plataforma = ""
    juego.distribuidora = ""

}

