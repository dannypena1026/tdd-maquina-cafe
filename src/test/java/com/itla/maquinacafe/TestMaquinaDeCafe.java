package com.itla.maquinacafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestMaquinaDeCafe {
    private MaquinaDeCafe maquina;
    private Vaso pequeno;
    private Vaso mediano;
    private Vaso grande;

    @Before
    public void configurar() {
        maquina = new MaquinaDeCafe();
        maquina.setCafetera(new Cafetera(50));
        pequeno = new Vaso(5, 3);
        mediano = new Vaso(5, 5);
        grande = new Vaso(5, 7);
        maquina.setVasosPequeno(pequeno);
        maquina.setVasosMediano(mediano);
        maquina.setVasosGrande(grande);
        maquina.setAzucarero(new Azucarero(20));
    }

    @Test
    public void deberiaDevolverUnVasoPequeno() {
        assertSame(pequeno, maquina.getTipoDeVaso("pequeño"));
    }

    @Test
    public void deberiaDevolverUnVasoMediano() {
        assertSame(mediano, maquina.getTipoDeVaso("mediano"));
    }

    @Test
    public void deberiaDevolverUnVasoGrande() {
        assertSame(grande, maquina.getTipoDeVaso("grande"));
    }

    @Test
    public void deberiaDevolverNoHayVasos() {
        pequeno.giveVasos(5);
        assertEquals("No hay Vasos", maquina.getVasoDeCafe(pequeno, 1, 2));
    }

    @Test
    public void deberiaDevolverNoHayCafe() {
        maquina.setCafetera(new Cafetera(2));
        assertEquals("No hay Cafe", maquina.getVasoDeCafe(pequeno, 1, 2));
    }

    @Test
    public void deberiaDevolverNoHayAzucar() {
        maquina.setAzucarero(new Azucarero(1));
        assertEquals("No hay Azucar", maquina.getVasoDeCafe(pequeno, 1, 2));
    }

    @Test
    public void deberiaRestarCafe() {
        maquina.getVasoDeCafe(pequeno, 1, 2);
        assertEquals(47, maquina.getCafetera().getCantidadCafe());
    }

    @Test
    public void deberiaRestarVasos() {
        maquina.getVasoDeCafe(pequeno, 1, 2);
        assertEquals(4, maquina.getVasosPequeno().getCantidadVasos());
    }

    @Test
    public void deberiaRestarAzucar() {
        maquina.getVasoDeCafe(pequeno, 1, 3);
        assertEquals(17, maquina.getAzucarero().getCantidadAzucar());
    }

    @Test
    public void deberiaDevolverFelicitaciones() {
        assertEquals("Felicitaciones", maquina.getVasoDeCafe(pequeno, 1, 3));
    }

    @Test
    public void deberiaConsumirProporcionalmenteVariosVasos() {
        assertEquals("Felicitaciones", maquina.getVasoDeCafe(mediano, 2, 1));
        assertEquals(40, maquina.getCafetera().getCantidadCafe());
        assertEquals(3, mediano.getCantidadVasos());
        assertEquals(18, maquina.getAzucarero().getCantidadAzucar());
    }

    @Test
    public void noDebeConsumirRecursosSiFaltaUnIngrediente() {
        maquina.setAzucarero(new Azucarero(0));
        assertEquals("No hay Azucar", maquina.getVasoDeCafe(grande, 1, 2));
        assertEquals(5, grande.getCantidadVasos());
        assertEquals(50, maquina.getCafetera().getCantidadCafe());
    }

    @Test
    public void permiteCafeSinAzucar() {
        maquina.setAzucarero(new Azucarero(0));
        assertEquals("Felicitaciones", maquina.getVasoDeCafe(pequeno, 1, 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void rechazaCantidadDeVasosNoValida() {
        maquina.getVasoDeCafe(pequeno, 0, 1);
    }
}
