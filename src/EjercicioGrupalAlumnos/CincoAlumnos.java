package EjercicioGrupalAlumnos;

import java.util.Scanner;

public class CincoAlumnos {
    // Constante para definir el número de alumnos, hemos dicho 5
    private static final int NUMERO_ALUMNOS = 5;

    //Lee y devuelve el nombre de un alumno:
    public static String leerNombre() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre del alumno: ");
        String nombre = sc.nextLine();
        return nombre;
    }

    //Lee y devuelve un array de 3 notas del alumno:
    public static double[] leerNotas() {
        Scanner sc = new Scanner(System.in);
        double[] notas = new double[3];

        System.out.print("Introduzca la primera nota: ");
        notas[0] = sc.nextDouble();

        System.out.print("Introduzca la segunda nota: ");
        notas[1] = sc.nextDouble();

        System.out.print("Introduzca la tercera nota: ");
        notas[2] = sc.nextDouble();

        // Consumir el salto de línea pendiente
        sc.nextLine();

        return notas;
    }

    //Calcula la media aritmética de las notas proporcionadas:
    public static double CalculoMedia(double[] notasAlumno) {
        double sumaNotas = notasAlumno[0] + notasAlumno[1] + notasAlumno[2];
        return sumaNotas / 3.0;
    }

    //Determina si el alumno aprueba o suspende:
    public static String obtenerResultado(double media) {
        if (media >= 5.0) {
            return "APROBADO";
        } else {
            return "SUSPENSO";
        }
    }

    //Método principal
    public static void main(String[] args) {

        // Variable para acumular la suma de las medias individuales, empieza en 0:
        double sumaTotalMedias = 0.0;

        System.out.println("=================================================");
        System.out.println("Bienvenido al análisis de las calificaciones de la clase.");
        System.out.printf("Procesando datos para %d alumnos.\n", NUMERO_ALUMNOS);
        System.out.println("=================================================");

        // Bucle principal para procesar a los 5 alumnos
        for (int i = 1; i <= NUMERO_ALUMNOS; i++) {
            System.out.printf("\n--- ALUMNO NÚMERO %d ---\n", i);

            String nombre = leerNombre();
            double[] notas = leerNotas();
            double media = CalculoMedia(notas);
            String resultado = obtenerResultado(media);

            // Acumular la media de este alumno:
            //Aquí a la variable sumaTotalMedias(0) le suma la media de este alumno(por ej:7)
            //Entonces, para el siguiente, sumaTotaMedias es 7 y le suma la siguiente media
            sumaTotalMedias += media;

            // Imprimir resultado individual
            System.out.printf("\n>>> RESULTADO DE %s:\n", nombre.toUpperCase());
            System.out.printf("    Media: %.2f\n", media);
            System.out.printf("    Resultado final: %s\n", resultado);
        }

        //  Calcular la Media Global (fuera del bucle):
        double mediaGlobal = sumaTotalMedias / NUMERO_ALUMNOS;
        //Aquí dividimos la acumulacion de medias entre esos 5 alumnos

        // --- Informe Final (Incluyendo la Media Global) ---
        System.out.println("\n\n=================================================");
        System.out.println("INFORME FINAL DE LA CLASE");
        System.out.println("=================================================");
        System.out.printf("Total de alumnos en la clase: %d\n", NUMERO_ALUMNOS);
        System.out.printf("Media global de la clase: %.2f\n", mediaGlobal);
    }

}
