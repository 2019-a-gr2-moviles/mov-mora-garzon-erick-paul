

class Venta(

    var codigoVenta: String,
    var cedulaCliente: String,
    var fechaVenta: String,
    var descripcion: String,
    var total: Double
){
    override fun toString(): String {
        return "Venta(codigoVenta='$codigoVenta', cedulaCliente='$cedulaCliente', fechaVenta='$fechaVenta', descripcion='$descripcion', total='$total')"
    }

    fun registroVenta(): String {
        return "\n"+codigoVenta+","+cedulaCliente+","+fechaVenta+","+descripcion+","+total
    }
}


