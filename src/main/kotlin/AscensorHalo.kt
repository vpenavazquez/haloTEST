class AscensorHalo {

    enum class EstadoHalo {
        Idle,
        MovingDOWN,
        MovingUP,
        Error
    }

    val GarciaBarbon: Int = 0
    val Pcompostela: Int = 1
    val Movimiento: Int = 2
    val ErrorNivel: Int = -1


    var estadoActual: EstadoHalo = EstadoHalo.Idle
        private set

    var nivel_actual: Int = GarciaBarbon
        private set


    fun pulsarBotonBajar(): Unit {
        when (estadoActual) {
            EstadoHalo.Idle -> {
                if (nivel_actual == Pcompostela) {
                    estadoActual = EstadoHalo.MovingDOWN
                    nivel_actual = Movimiento
                } else {
                    registrarError()
                }
            }
            else -> registrarError()
        }
    }


    fun pulsarBotonSubir(): Unit {
        when (estadoActual) {
            EstadoHalo.Idle -> {
                if (nivel_actual == GarciaBarbon) {
                    estadoActual = EstadoHalo.MovingUP
                    nivel_actual = Movimiento
                } else {
                    registrarError()
                }
            }
            else -> registrarError()
        }
    }


    fun abrirPuerta(): Unit {
        when (estadoActual) {
            EstadoHalo.MovingDOWN -> {
                estadoActual = EstadoHalo.Idle
                nivel_actual = GarciaBarbon
            }
            EstadoHalo.MovingUP -> {
                estadoActual = EstadoHalo.Idle
                nivel_actual = Pcompostela
            }
            else -> registrarError()
        }
    }


    fun fallo(): Unit {
        registrarError()
    }


    fun nivel_0(): Unit = pulsarBotonBajar()
    fun nivel_1(): Unit = pulsarBotonSubir()

    private fun registrarError(): Unit {
        estadoActual = EstadoHalo.Error
        nivel_actual = ErrorNivel
    }
}