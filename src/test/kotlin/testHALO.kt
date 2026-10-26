package test

import kotlin.test.Test
import kotlin.test.BeforeEach
import kotlin.test.assertEquals

class testHALO {

    private lateinit var ascensor: AscensorHalo

    @BeforeEach
    fun setUp() {
        ascensor = AscensorHalo()
    }

    @Test
    fun `inicializacion correcta con nivel_actual en GarciaBarbon (0)`() {
        assertEquals(AscensorHalo.EstadoHalo.Idle, ascensor.estadoActual)
        assertEquals(ascensor.GarciaBarbon, ascensor.nivel_actual)
    }

    @Test
    fun `pulsarBotonSubir cambia estado a MovingUP y nivel_actual a Movimiento (2)`() {
        ascensor.pulsarBotonSubir()
        assertEquals(AscensorHalo.EstadoHalo.MovingUP, ascensor.estadoActual)
        assertEquals(ascensor.Movimiento, ascensor.nivel_actual)
    }

    @Test
    fun `abrirPuerta tras subir establece estado Idle y nivel_actual en Pcompostela (1)`() {
        ascensor.pulsarBotonSubir()
        ascensor.abrirPuerta()
        assertEquals(AscensorHalo.EstadoHalo.Idle, ascensor.estadoActual)
        assertEquals(ascensor.Pcompostela, ascensor.nivel_actual)
    }

    @Test
    fun `pulsarBotonBajar desde Pcompostela cambia a MovingDOWN y nivel_actual a Movimiento (2)`() {
        ascensor.pulsarBotonSubir()
        ascensor.abrirPuerta()

        ascensor.pulsarBotonBajar()
        assertEquals(AscensorHalo.EstadoHalo.MovingDOWN, ascensor.estadoActual)
        assertEquals(ascensor.Movimiento, ascensor.nivel_actual)
    }

    @Test
    fun `abrirPuerta tras bajar establece estado Idle y nivel_actual en GarciaBarbon (0)`() {
        ascensor.pulsarBotonSubir()
        ascensor.abrirPuerta()
        ascensor.pulsarBotonBajar()
        ascensor.abrirPuerta()

        assertEquals(AscensorHalo.EstadoHalo.Idle, ascensor.estadoActual)
        assertEquals(ascensor.GarciaBarbon, ascensor.nivel_actual)
    }

    @Test
    fun `abrirPuerta desde Idle genera estado Error y nivel_actual ErrorNivel (-1)`() {
        ascensor.abrirPuerta()
        assertEquals(AscensorHalo.EstadoHalo.Error, ascensor.estadoActual)
        assertEquals(ascensor.ErrorNivel, ascensor.nivel_actual)
    }

    @Test
    fun `pulsarBotonSubir estando ya en Pcompostela causa Error`() {
        ascensor.pulsarBotonSubir()
        ascensor.abrirPuerta()

        ascensor.pulsarBotonSubir()
        assertEquals(AscensorHalo.EstadoHalo.Error, ascensor.estadoActual)
        assertEquals(ascensor.ErrorNivel, ascensor.nivel_actual)
    }

    @Test
    fun `invocar fallo transiciona a Error y asigna nivel ErrorNivel (-1)`() {
        ascensor.fallo()
        assertEquals(AscensorHalo.EstadoHalo.Error, ascensor.estadoActual)
        assertEquals(ascensor.ErrorNivel, ascensor.nivel_actual)
    }
}