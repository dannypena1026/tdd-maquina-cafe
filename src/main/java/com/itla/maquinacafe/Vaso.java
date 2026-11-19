package com.itla.maquinacafe;

/** Inventario de vasos de un tamaño específico. */
public class Vaso {
    private int cantidadVasos;
    private final int contenido;

    public Vaso(int cantidadVasos, int contenido) {
        if (cantidadVasos < 0 || contenido <= 0) {
            throw new IllegalArgumentException("Cantidad o capacidad de vasos inválida");
        }
        this.cantidadVasos = cantidadVasos;
        this.contenido = contenido;
    }

    public boolean hasVasos(int cantidad) {
        return cantidad > 0 && cantidadVasos >= cantidad;
    }

    public void giveVasos(int cantidad) {
        if (!hasVasos(cantidad)) {
            throw new IllegalArgumentException("No hay suficientes vasos");
        }
        cantidadVasos -= cantidad;
    }

    public int getCantidadVasos() {
        return cantidadVasos;
    }

    public int getContenido() {
        return contenido;
    }
}
