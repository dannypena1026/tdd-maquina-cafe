package com.itla.maquinacafe;

import java.util.Locale;

/** Coordina las reservas de café, vasos y azúcar. */
public class MaquinaDeCafe {
    private Cafetera cafetera;
    private Vaso vasosPequenos;
    private Vaso vasosMedianos;
    private Vaso vasosGrandes;
    private Azucarero azucarero;

    public void setCafetera(Cafetera cafetera) {
        this.cafetera = cafetera;
    }

    public Cafetera getCafetera() {
        return cafetera;
    }

    public void setVasosPequeno(Vaso vasosPequenos) {
        this.vasosPequenos = vasosPequenos;
    }

    public Vaso getVasosPequeno() {
        return vasosPequenos;
    }

    public void setVasosMediano(Vaso vasosMedianos) {
        this.vasosMedianos = vasosMedianos;
    }

    public Vaso getVasosMediano() {
        return vasosMedianos;
    }

    public void setVasosGrande(Vaso vasosGrandes) {
        this.vasosGrandes = vasosGrandes;
    }

    public Vaso getVasosGrande() {
        return vasosGrandes;
    }

    public void setAzucarero(Azucarero azucarero) {
        this.azucarero = azucarero;
    }

    public Azucarero getAzucarero() {
        return azucarero;
    }

    public Vaso getTipoDeVaso(String tipoDeVaso) {
        if (tipoDeVaso == null) {
            throw new IllegalArgumentException("Seleccione un tamaño de vaso");
        }
        switch (tipoDeVaso.toLowerCase(Locale.ROOT).trim()) {
            case "pequeno":
            case "pequeño":
                return vasosPequenos;
            case "mediano":
                return vasosMedianos;
            case "grande":
                return vasosGrandes;
            default:
                throw new IllegalArgumentException("Tamaño de vaso desconocido");
        }
    }

    /**
     * Prepara una o más porciones. El azúcar se indica por cada vaso.
     * Si falta algún insumo, el inventario se conserva sin cambios.
     */
    public String getVasoDeCafe(Vaso tipoVaso, int cantidadVasos, int cucharadasPorVaso) {
        if (tipoVaso == null || cafetera == null || azucarero == null) {
            throw new IllegalStateException("La máquina no está configurada");
        }
        if (cantidadVasos <= 0 || cucharadasPorVaso < 0) {
            throw new IllegalArgumentException("La cantidad de vasos o azúcar no es válida");
        }

        long cafeNecesario = (long) tipoVaso.getContenido() * cantidadVasos;
        long azucarNecesaria = (long) cucharadasPorVaso * cantidadVasos;

        if (!tipoVaso.hasVasos(cantidadVasos)) {
            return "No hay Vasos";
        }
        if (cafeNecesario > Integer.MAX_VALUE || !cafetera.hasCafe((int) cafeNecesario)) {
            return "No hay Cafe";
        }
        if (azucarNecesaria > Integer.MAX_VALUE || !azucarero.hasAzucar((int) azucarNecesaria)) {
            return "No hay Azucar";
        }

        tipoVaso.giveVasos(cantidadVasos);
        cafetera.giveCafe((int) cafeNecesario);
        azucarero.giveAzucar((int) azucarNecesaria);
        return "Felicitaciones";
    }
}
