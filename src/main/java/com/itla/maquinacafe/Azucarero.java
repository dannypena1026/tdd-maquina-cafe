package com.itla.maquinacafe;

/** Reserva de azúcar expresada en cucharadas. */
public class Azucarero {
    private int cantidadAzucar;

    public Azucarero(int cantidadAzucar) {
        if (cantidadAzucar < 0) {
            throw new IllegalArgumentException("La cantidad de azúcar no puede ser negativa");
        }
        this.cantidadAzucar = cantidadAzucar;
    }

    public boolean hasAzucar(int cantidad) {
        return cantidad >= 0 && cantidadAzucar >= cantidad;
    }

    public void giveAzucar(int cantidad) {
        if (!hasAzucar(cantidad)) {
            throw new IllegalArgumentException("No hay suficiente azúcar");
        }
        cantidadAzucar -= cantidad;
    }

    public int getCantidadAzucar() {
        return cantidadAzucar;
    }
}
