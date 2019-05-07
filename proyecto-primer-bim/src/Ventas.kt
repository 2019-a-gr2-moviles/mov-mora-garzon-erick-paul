import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.*
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JButton
import javax.swing.SwingConstants.LEADING

class Ventas(title: String) : JFrame(){
    /*private val btnInsVenta: JButton? = null
    private val btnConsVenta: JButton? = null
    private val btnActVenta: JButton? = null
    private val btnElimVenta: JButton? = null
    val panel: JPanel? = JPanel()
*/
    init {
        createUI(title)
    }

    private fun createUI(title: String) {
        val btnVideojuego = JButton("Videojuegos")
        val btnVentas = JButton("Ventas")


        val stdBtn = arrayOf<JButton>(btnVideojuego, btnVentas)

        val buttons = stdBtn.map {
            JButton(it.text).apply {

                minimumSize = Dimension(150, 80)
                //background = it
                isOpaque = true
            }
        }

        btnVideojuego.addActionListener {
            JOptionPane.showMessageDialog(null, "mensaje")

        }
        btnVentas.addActionListener {
            //Ventas(title).main()
            //frameInsertar.showEventDemo()
            //frameInsertar.show()
            //frameInsertar.isVisible = true
        }

        createLayout(buttons)

        setTitle(title)
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setLocationRelativeTo(null)
    }

    private fun createLayout(arg: List<JComponent>) {

        val gl = GroupLayout(contentPane)
        contentPane.layout = gl

        gl.autoCreateContainerGaps = true
        gl.autoCreateGaps = true


        gl.setHorizontalGroup(gl.createSequentialGroup()
            //.addGroup(gl.createSequentialGroup()
            .addComponent(arg[0])
            .addComponent(arg[1])

        )


        gl.setVerticalGroup(gl.createParallelGroup()
            //.addGroup(gl.createSequentialGroup()
            .addComponent(arg[0])
            .addComponent(arg[1])

        )

        pack()
    }
    fun main(/*args: Array<String>*/) {
        val frame = JFrame("Ventas")
        //frame.getContentPane().add(scrollPane, BorderLayout.CENTER)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
        frame.setSize(Dimension(500, 500))
        frame.setLocationRelativeTo(null)
        frame.setVisible(true)
    }
}

private fun createAndShowGUI() {

    val frame = Principal("Catálogo de Videojuegos")
    frame.isVisible = true
}


fun main(args: Array<String>) {
    EventQueue.invokeLater(::createAndShowGUI)
}

