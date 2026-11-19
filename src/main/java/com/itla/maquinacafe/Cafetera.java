package com.itla.maquinacafe;

/** Reserva de café expresada en onzas (oz). */
public class Cafetera {
    private int cantidadCafe;

    public Cafetera(int cantidadCafe) {
        if (cantidadCafe < 0) {
            throw new IllegalArgumentException("La cantidad de café no puede ser negativa");
        }
        this.cantidadCafe = cantidadCafe;
    }

    public boolean hasCafe(int cantidad) {
        return cantidad >= 0 && cantidadCafe >= cantidad;
    }

    public void giveCafe(int cantidad) {
        if (!hasCafe(cantidad)) {
            throw new IllegalArgumentException("No hay suficiente café");
        }
        cantidadCafe -= cantidad;
    }

    public int getCantidadCafe() {
        return cantidadCafe;
    }
}
