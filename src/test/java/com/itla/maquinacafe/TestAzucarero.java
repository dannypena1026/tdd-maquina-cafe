package com.itla.maquinacafe;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestAzucarero {
    @Test
    public void deberiaDevolverVerdaderoSiExisteSuficienteAzucar() {
        assertTrue(new Azucarero(10).hasAzucar(10));
    }

    @Test
    public void deberiaDevolverFalsoSiNoExisteAzucar() {
        assertFalse(new Azucarero(10).hasAzucar(15));
    }

    @Test
    public void deberiaRestarAzucar() {
        Azucarero azucarero = new Azucarero(10);
        azucarero.giveAzucar(5);
        azucarero.giveAzucar(2);
        assertEquals(3, azucarero.getCantidadAzucar());
    }

    @Test
    public void deberiaPermitirCafeSinAzucar() {
        assertTrue(new Azucarero(0).hasAzucar(0));
    }
}
