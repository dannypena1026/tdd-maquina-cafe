package com.itla.maquinacafe;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestVaso {
    @Test
    public void deberiaDevolverVerdaderoSiExistenVasos() {
        Vaso vasos = new Vaso(5, 3);
        assertTrue(vasos.hasVasos(2));
    }

    @Test
    public void deberiaDevolverFalsoSiNoExistenVasos() {
        Vaso vasos = new Vaso(1, 3);
        assertFalse(vasos.hasVasos(2));
    }

    @Test
    public void deberiaRestarCantidadDeVasos() {
        Vaso vasos = new Vaso(5, 3);
        vasos.giveVasos(1);
        assertEquals(4, vasos.getCantidadVasos());
    }

    @Test(expected = IllegalArgumentException.class)
    public void noDeberiaPermitirRetirarMasVasosDeLosDisponibles() {
        new Vaso(1, 3).giveVasos(2);
    }

    @Test
    public void deberiaGuardarContenidoDeVasoEnOnzas() {
        assertEquals(7, new Vaso(3, 7).getContenido());
    }
}
