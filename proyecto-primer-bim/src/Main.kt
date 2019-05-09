import java.awt.Dimension
import javax.swing.JFrame

fun main(args: Array<String>) {
    val frame = JFrame("Catálogo de Videojuegos")
    //frame.contentPane = Principal("dfs")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.preferredSize = Dimension(500,500)
    frame.pack()
    frame.isVisible = true


}