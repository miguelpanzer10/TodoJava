package UF02Programacion;
import java.util.Scanner;

public class MenorEdad {
    public static void main(String[] args) {
        System.out.println("Bienvenido a la comprobación de si puedes conducir un coche: ");
        Scanner sc = new Scanner(System.in);
        int edad ;
        String carnet;
        boolean carnetb;

        do {
            System.out.println("Introduce tu edad actual (debe ser mayor de 10): ");
            while (!sc.hasNextInt()) { // Evita que el programa pete si escriben letras
                System.out.println("Por favor, introduce un número válido.");
                sc.next();
            }
            edad = sc.nextInt();
            sc.nextLine(); // ¡IMPORTANTE! Limpia el "Enter" después del número para que no se salte el siguiente paso
            System.out.println("----------------------------");
        } while (edad <= 10);

        if (edad < 18) {
            System.out.println("¡Vaya! Eres menor de 18 años (no puedes tener carnet).");
        } else {
            System.out.print("¿Tienes carnet de conducir? (si/no): ");
            carnet = sc.nextLine().toLowerCase(); // Leemos y pasamos a minúsculas

            if (carnet.equals("si")) {
                carnetb = true;
            } else {
                carnetb = false;
            }

            if (carnetb) { // No hace falta poner == true, carnetb ya es un boolean
                System.out.println("¡Puedes conducir un coche!");
            } else {
                System.out.println("Vaya... No tienes carnet.");
            }
        }
        sc.close(); // Cerrar siempre al final de todo
    }
}