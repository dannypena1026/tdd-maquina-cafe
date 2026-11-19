package com.itla.maquinacafe;

import java.util.Scanner;

/** Consola de demostración de la máquina de café. */
public class Main {
    public static void main(String[] args) {
        MaquinaDeCafe maquina = new MaquinaDeCafe();
        maquina.setCafetera(new Cafetera(150));
        maquina.setVasosPequeno(new Vaso(10, 3));
        maquina.setVasosMediano(new Vaso(10, 5));
        maquina.setVasosGrande(new Vaso(10, 7));
        maquina.setAzucarero(new Azucarero(100));

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== MÁQUINA DE CAFÉ ===");
        System.out.println("Seleccione un tamaño y las cucharadas de azúcar por vaso.");

        while (true) {
            System.out.println("\n1. Pequeño (3 oz)  2. Mediano (5 oz)  3. Grande (7 oz)  0. Salir");
            System.out.print("Opción: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Por favor, introduzca un número.");
                scanner.next();
                continue;
            }
            int opcion = scanner.nextInt();
            if (opcion == 0) {
                System.out.println("Hasta luego.");
                break;
            }
            if (opcion < 1 || opcion > 3) {
                System.out.println("Opción no válida.");
                continue;
            }
            System.out.print("Cantidad de vasos: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Cantidad no válida.");
                scanner.next();
                continue;
            }
            int cantidad = scanner.nextInt();
            System.out.print("Cucharadas de azúcar por vaso (0 para sin azúcar): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Cantidad no válida.");
                scanner.next();
                continue;
            }
            int azucar = scanner.nextInt();

            String tipo = opcion == 1 ? "pequeño" : opcion == 2 ? "mediano" : "grande";
            try {
                String resultado = maquina.getVasoDeCafe(maquina.getTipoDeVaso(tipo), cantidad, azucar);
                System.out.println(resultado);
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
    }
}
