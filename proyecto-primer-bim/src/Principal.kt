import javax.swing.*
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class Principal {
    val panel: JPanel ?= JPanel()
    private val btnVideojuego: JButton ?= JButton()
    private val btnVentas: JButton ?= JButton()

    init {
        btnVideojuego!!.addActionListener {
            JOptionPane.showMessageDialog(null, "mensaje")

        }
        btnVentas!!.addActionListener {
            val frameInsertar = Ventas()
            //frameInsertar.showEventDemo()
            frameInsertar.show()}
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val frame = JFrame("Principal")
            frame.contentPane = Principal().panel
            frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            frame.pack()
            frame.isVisible = true
        }
    }
}
