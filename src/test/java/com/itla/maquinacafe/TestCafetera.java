package com.itla.maquinacafe;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestCafetera {
    @Test
    public void deberiaDevolverVerdaderoSiExisteCafe() {
        assertTrue(new Cafetera(10).hasCafe(5));
    }

    @Test
    public void deberiaDevolverFalsoSiNoExisteCafe() {
        assertFalse(new Cafetera(10).hasCafe(11));
    }

    @Test
    public void deberiaRestarCafe() {
        Cafetera cafetera = new Cafetera(10);
        cafetera.giveCafe(7);
        assertEquals(3, cafetera.getCantidadCafe());
    }

    @Test(expected = IllegalArgumentException.class)
    public void noDeberiaPermitirCafeNegativo() {
        new Cafetera(-1);
    }
}
