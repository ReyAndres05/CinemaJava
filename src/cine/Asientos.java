package cine;

import java.util.Random;
import java.util.Scanner;

public class Asientos {

    private static final int FILAS = 8;
    private static final int COLUMNAS = 9;
    private final String[][] asientos;
    private final Random random;
    private final Scanner scanner;

    public Asientos() {
        asientos = new String[FILAS][COLUMNAS];
        random = new Random();
        scanner = new Scanner(System.in);
        inicializarAsientos();
    }

    private void inicializarAsientos() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                asientos[i][j] = "D"; // D = Disponible
            }
        }
    }

    public int registrarPersona() {
        System.out.print("Ingresa tú nombre  = ");
        String nombre = scanner.next();
        System.out.println("Ingresa tu edad = ");
        int edad = scanner.nextInt();
        int edadmin = 12;
        if (edad < edadmin) {
            System.out.println("No cumples con la edad minima");
            return 0;
        }
        System.out.println("¿Cuanto dinero tienes?");
        int dinero = scanner.nextInt();
        int mindinero = 12000;
        if (dinero < mindinero) {
            System.out.println("Tu dinero no es suficiente");
            return 0;
        }

        int fila = random.nextInt(FILAS);
        int columna = random.nextInt(COLUMNAS);

        if (asientos[fila][columna].equals("D")) {
            asientos[fila][columna] = nombre; // Ocupar asiento
            System.out.println("Asiento reservado para " + nombre + 
            " en la fila " + (char) ('A' + fila) + " columna " + (columna + 1)) ;
        } else {
            System.out.println("Asientoocupado. Intenta de nuevo.");
            registrarPersona();
        }
        return 0;
    }

    public void imprimirAsientos() {
        System.out.println("Asientos disponibles:");
        System.out.print("  ");
        for (int j = 0; j < COLUMNAS; j++) {
            System.out.print(j + 1 + " ");
        }
        System.out.println();

        for (int i = 0; i < FILAS; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < COLUMNAS; j++) {
                if (asientos[i][j].equals("D")) {
                    System.out.print(" [D] ");
                } else {
                    System.out.print(" [" + asientos[i][j] + "] ");
                }
            }
            System.out.println();
        }
    }

    public void menu() {
        int opcion;

        do {
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Registrarme");
            System.out.println("2. Mostrar asientos disponbles y/o ocupados");
            System.out.println("3. Salir");

            System.out.print("Elige una opcion = ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registrarPersona();
                    break;
                case 2:
                    imprimirAsientos();
                    break;
                case 3:
                    System.out.println("Gracias por visitar CinePaz");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion !=3);
    }
}