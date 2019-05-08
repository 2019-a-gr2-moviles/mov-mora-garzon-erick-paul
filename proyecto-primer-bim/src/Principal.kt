import javax.swing.*
import java.awt.*
import java.io.File
import javax.swing.JFrame
import javax.swing.JButton

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

            val opciones: Array<Any> = arrayOf("Insertar","Consultar","Modificar","Eliminar")

            var listaVideojuego : Videojuego

           // var leer : BaseDatosVideojuego

            var registroVideojuego = ""



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
                //System.exit(0)
                val result = JOptionPane.showOptionDialog(null, "Seleccione una opción","Videojuegos", 1,1,null, opciones,null)
                when(result){
                    0->{

                        val codJuego = JOptionPane.showInputDialog("Ingrese el Código del videojuego")
                        val nomJuego = JOptionPane.showInputDialog("Ingrese el Nombre del videojuego")
                        val precioJuego = JOptionPane.showInputDialog("Ingrese el Precio del videojuego")
                        val genJuego = JOptionPane.showInputDialog("Ingrese el Género del videojuego")
                        val clasifJuego = JOptionPane.showInputDialog("Ingrese la Clasificación del videojuego")
                        val platJuego = JOptionPane.showInputDialog("Ingrese la Plataforma del videojuego")
                        val distJuego = JOptionPane.showInputDialog("Ingrese la Distribuidora del videojuego")

                        registroVideojuego="\n"+codJuego+","+nomJuego+","+precioJuego+","+genJuego+","+clasifJuego+","+platJuego+","+distJuego+";"


                        //listaVideojuego.agregarVideojuego(codJuego,nomJuego,precioJuego,genJuego,clasifJuego,platJuego,distJuego)

                        JOptionPane.showMessageDialog(null, "Videojuego registrado")
                        println(registroVideojuego)
                        escribirArchivo(registroVideojuego)
                        leerContenido()
                    }
                    1->{
                        val codJuego = JOptionPane.showInputDialog("Ingrese el Código del videojuego a buscar")

                       // listaVideojuego.consultarVideojuego(codJuego)

                        JOptionPane.showMessageDialog(null, "Datos: ")
                    }
                    2->{
                        val codJuego = JOptionPane.showInputDialog("Ingrese el Código del videojuego a modificar")
                        val nomJuego = JOptionPane.showInputDialog("Ingrese el Nombre del videojuego")
                        val precioJuego = JOptionPane.showInputDialog("Ingrese el Precio del videojuego")
                        val genJuego = JOptionPane.showInputDialog("Ingrese el Género del videojuego")
                        val clasifJuego = JOptionPane.showInputDialog("Ingrese la Clasificación del videojuego")
                        val platJuego = JOptionPane.showInputDialog("Ingrese la Plataforma del videojuego")
                        val distJuego = JOptionPane.showInputDialog("Ingrese la Distribuidora del videojuego")

                        JOptionPane.showMessageDialog(null, "Datos de Videojuego modificados")
                    }
                    3->{
                        val codJuego = JOptionPane.showInputDialog("Ingrese el Código del videojuego a eliminar")

                        JOptionPane.showMessageDialog(null, "Videojuego eliminado")
                    }

                }


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

            //createLayout(buttons)
            //createLayout(btnVentas)
            createLayout(btnVideojuego)



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

















fun leerContenido() {
    val fileName = "src/baseVideojuegos.txt"

    val lines: List<String> = File(fileName).readLines()

    lines.forEach { line -> println(line) }
}

fun escribirArchivo(args: String) {
    val fileName = "src/baseVideojuegos.txt"

    val myfile = File(fileName)

    myfile.appendText(args)

    }

