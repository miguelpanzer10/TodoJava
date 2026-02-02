package EjerciciosVarios;
import java.util.Scanner;
//Control de aforo(entradas y salida)
//Un local empieza con aforo 0 y máximo 50
//Lees eventos: E(entra 1 persona), S(sale 1 persona), F(fin).
//Reglas:
//No puede bajar de 0
//Si está en 50, no puede entrar más
//Muestra cuántos eventos fueron inválidos y el aforo final


public class Aforo {
    public static void main(String[] args) { // Añadido public
        Scanner sc = new Scanner(System.in);
        int aforo = 0;
        int invalidos = 0;
        String entrada = "";

        System.out.println("Control de Aforo escribe (E: Entra, S: Sale, F: Fin)");

        //mientras sea diferente de F, hace:
        while (!entrada.equalsIgnoreCase("F")) {
            System.out.print("Evento (E/S/F). Escribe lo que quieras hacer ");
            entrada = sc.nextLine().toUpperCase();

            switch (entrada) {
                case "E":
                    if (aforo <=50) {
                        aforo++;
                    } else {
                        System.out.println("Error: Aforo completo.");
                        invalidos++;
                    }
                    break;
                case "S":
                    if (aforo > 0) {
                        aforo--;
                    } else {
                        System.out.println("Error: El local ya está vacío.");
                        invalidos++;
                    }
                    break;
                case "F":
                    System.out.println("Cerrando control...");
                    break;
                default:
                    System.out.println("Código no reconocido.");
                    invalidos++;
                    break;
            }
        }

        System.out.println("\n--- Resumen Final ---");
        System.out.println("Aforo final: " + aforo);
        System.out.println("Eventos inválidos: " + invalidos);
        sc.close();
    }
}







