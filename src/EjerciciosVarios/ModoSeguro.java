package EjerciciosVarios;
//Modo seguro por confirmación
//Pide al usuario si quiere borrar datos:responde S/N
//Sólo borra si responde S dos veces seguidas(confirmación)
//Si en cualquier punto responde N, se cancelas.
//Usa booleano confirmado y un bucle lectura

import java.util.Scanner;

public class ModoSeguro {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String respuesta;
        String respuesta2;
        boolean confirmado = false; // Esta variable controlará el bucle

        System.out.println("Bienvenido al modo seguro de confirmación doble");

        do {
            System.out.println("\n--- Nuevo intento de borrado ---");
            System.out.print("Digite S para borrar y N para cancelar: ");
            respuesta = sc.nextLine().toUpperCase();

            if (respuesta.equals("S")) {
                System.out.println("¿Estás seguro de que quieres borrar?");
                System.out.print("Escriba S de nuevo para confirmar o N si quiere cancelar: ");
                respuesta2 = sc.nextLine().toUpperCase();

                if (respuesta2.equals("S")) {
                    System.out.println("Operación confirmada. Borrando datos...");
                    confirmado = true; // Al ser true, el bucle terminará
                } else {
                    System.out.println("Confirmación denegada. Volviendo al inicio.");
                }
            } else {
                System.out.println("Operación cancelada. ¿Deseas intentarlo de nuevo?");
                System.out.print("Escribe 'EXIT' para salir o cualquier tecla para reintentar: ");
                String salida = sc.nextLine();
                if (salida.equalsIgnoreCase("EXIT")) {
                    confirmado = true; // También ponemos true para salir si el usuario se rinde
                }
            }

            System.out.println("--------------------------------------------------------");

        } while (!confirmado); // El bucle se repite mientras NO esté confirmado

        System.out.println("Saliendo del sistema de seguridad...");
        sc.close();
    }
}