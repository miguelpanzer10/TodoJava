package UF02Programacion;

import java.util.Scanner;
// Importo que pueda utilizar scanner, ya que no es una clase fundamental.
//Crea un programa que encuentre todos los números pares entre dos valores que el usuario indique.
public class EjercicioPares {
    public  void main(String[] args) {
        System.out.println("Bienvenido al indicador de números pares!!");
        System.out.println("Vamos a calcular cuántos números pares hay entre dos números:");


        EjercicioPares objeto = new EjercicioPares();
        //Para llamar a los métodos que quiera crear, antes, necesito tener un objeto de la clase
        int[] datos = objeto.leerDatos();
        /*Como leerDatos devuelve un array de int,
        me interesa crear una variable que recoja esos datos y poder utilizarla, la llamo, datos*/
        objeto.contarYMostrarPares(datos);
        // Llamamos al nuevo método con los datos recogidos de os pares
        objeto.contarYMostrarImpares(datos);
        //Ahora con mpares

    }


    public  int[] leerDatos() {
        // Se define un método público llamado 'leerDatos' que devuelve un array de enteros (int[]).
        // Este método no recibe parámetros.
        Scanner scanner = new Scanner(System.in);
        // Se crea un objeto 'Scanner' para leer datos desde la entrada estándar (normalmente el teclado).
        System.out.println("Por favor, introduce el primer número:");
        // Se solicita al usuario que introduzca el primer numero
        int primero = scanner.nextInt();
        // Se lee el valor introducido por el usuario y se guarda en la variable 'primero'.
        System.out.println("Por favor, introduce el segundo número:");
        // Se solicita al usuario que introduzca el segundo número
        int segundo = scanner.nextInt();
        // Se lee el valor introducido por el usuario y se guarda en la variable 'segundo'.
        scanner.close();

        return new int[]{primero, segundo};
         /* Se devuelve un array de enteros que contiene los valores de 'primer' y 'segundo'.
            El new en la línea return new,
            se utiliza porque estás creando una nueva instancia de un array de enteros en ese mismo momento*/

    }

    public void contarYMostrarPares(int[] datos) {
        int numero1 = datos[0]; // El primer número del array
        int numero2 = datos[1]; // El segundo número del array

        // Lógica para determinar el inicio y fin del bucle por si ingresa números al reves
        int inicioBucle; // Guardará el número más pequeño
        int finBucle;    // Guardará el número más grande

        if (numero1 < numero2) {
            inicioBucle = numero1;
            finBucle = numero2;
        } else {
            inicioBucle = numero2;
            finBucle = numero1;
        }
        /*Es decir, si ingresa un numero pequeño y uno grande,
        indistintamente, el pequeño será el inicio*/

        int contadorPares = 0;
        /*Aquí creo una variable con valor = para usarla como contador
        porque si salen muchos números, es más fácil que los cuente*/

        System.out.println("----------------------------------------------------------------");
        System.out.println("Los números pares entre " + numero1 + " y " + numero2 + " son:");

        // Iteramos desde el número más pequeño hasta el más grande
        for (int i = inicioBucle; i <= finBucle; i++) {
            if (i % 2 == 0) {
                System.out.print(i + ", "); // Mostramos el número par
                contadorPares++;            // El contador se suma 1 cada vuelta
            }


        }

        System.out.println("\n----------------------------------------------------------------");
        System.out.println("Total de pares encontrados: " + contadorPares);
    }

    public void contarYMostrarImpares(int[] datos) { // Para los impares
        int numero1 = datos[0];
        int numero2 = datos[1];

        // Se reutiliza la lógica para determinar el inicio y fin del bucle
        int inicioBucle;
        int finBucle;

        if (numero1 < numero2) {
            inicioBucle = numero1;
            finBucle = numero2;
        } else {
            inicioBucle = numero2;
            finBucle = numero1;
        }

        int contadorImpares = 0; // Contador específico para los impares

        System.out.println("\n----------------------------------------------------------------");
        System.out.println("Los números impares entre " + numero1 + " y " + numero2 + " son:");

        // Iteramos desde el número más pequeño hasta el más grande
        for (int i = inicioBucle; i <= finBucle; i++) {
            if (i % 2 != 0) { // Un número es impar si el residuo de la división por 2 NO es 0
                System.out.print(i + ", "); // Mostramos el número impar
                contadorImpares++;           // El contador se suma 1 cada vuelta
            }
        }

        System.out.println("\n----------------------------------------------------------------");
        System.out.println("Total de impares encontrados:" + contadorImpares );
    }

}





