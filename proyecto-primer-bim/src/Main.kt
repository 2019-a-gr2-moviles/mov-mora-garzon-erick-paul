import javax.swing.JFrame

fun main() {
    val frame = JFrame("Videojuegos")
    frame.contentPane = Principal().panel
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.pack()
    frame.isVisible = true
    //frame.showEventDemo()
    frame.show()
}