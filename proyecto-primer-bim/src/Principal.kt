import javax.swing.*
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JButton
import javax.swing.SwingConstants.LEADING

class Principal(title: String) : JFrame(){
    /*val panel: JPanel ?= JPanel()
    private val btnVideojuego: JButton ?= JButton("Videojuegos")
    private val btnVentas: JButton ?= JButton("Ventas")

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
            val frame = JFrame("Videojuegos")
            frame.contentPane = Principal().panel
            frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            frame.preferredSize=Dimension(500,500)
            frame.pack()
            frame.isVisible = true
        }
    }
}*/


        init {
            createUI(title)
        }

        private fun createUI(title: String) {
            setTitle(title)

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

                //println("boton juego")
                System.exit(0)

            }
            btnVentas.
                addActionListener {
                    //Ventas(title).show()
                    //frameInsertar.showEventDemo()
                    //frameInsertar.show()
                    //frameInsertar.isVisible = true
                    // println("boton venta")
                    System.exit(0)
                }

            createLayout(buttons)
            //createLayout(btnVentas)
            //createLayout(btnVideojuego)
            ///createLayout(btnVentas)


            defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            //setSize(400, 400)
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
                //.addGroup(gl.createParallelGroup()
                    .addComponent(arg[0])
                    .addComponent(arg[1])

            )

            pack()
        }
    private fun createLayout(vararg arg: JComponent) {

        val gl = GroupLayout(contentPane)
        contentPane.layout = gl

        gl.autoCreateContainerGaps = true

        gl.setHorizontalGroup(gl.createSequentialGroup()
            .addComponent(arg[0])
        )

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addComponent(arg[0])
        )

        pack()
    }

    }

    private fun createAndShowGUI() {

        val frame = Principal("Catálogo de Videojuegos")
        frame.isVisible = true
    }

    fun main(args: Array<String>) {
        EventQueue.invokeLater(::createAndShowGUI)
    }
