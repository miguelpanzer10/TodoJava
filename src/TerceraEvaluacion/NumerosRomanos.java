package TerceraEvaluacion;

import java.util.Scanner;

public class NumerosRomanos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        boolean entradaValida = false; //Boolean para controlar el bucle de validación

        System.out.println("Bienvenido al conversor de número romanos:");

        // Bucle para obligar al usuario a escribir un dato correcto
        while (!entradaValida) {
            System.out.print("Introduce un número entero entre el 1 o el 3999: ");

            // Comprobamos primero si lo que ha escrito es un número
            if (sc.hasNextInt()) {
                numero = sc.nextInt();

                // Si es un número, comprobamos si está en el rango deseado
                if (numero >= 1 && numero <= 3999) {
                    entradaValida = true; // Se cambia el boolean para salir del bucle
                } else {
                    System.out.println("Error: El número debe estar entre 1 y 3999. Inténtalo de nuevo.");
                }
            } else {
                // Si no escribe un número:
                System.out.println("Error: Eso no es un número válido. Por favor, introduce solo números.");
                sc.next(); // Se limpia el buffer del Scanner
            }
        }

        // Se muestra el resultado
        System.out.println("El número " + numero + " en números romanos es: " + convertirARomano(numero));

        sc.close();
    }

    public static String convertirARomano(int numero) {
        //Dos arrays con cada número normal y en romano
        int[] normales = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder resultado = new StringBuilder();
        //StringBuilder, me permite que en lugar de pisar el string
        //me añade el nuevo resultado al anterior
        //Si fuese solo string, sería M, luego L...
        //Pero con StringBuilder y append es: MLX...


        // Recorremos los arrays
        for (int i = 0; i < normales.length; i++) {
            // Mientras el número sea mayor o igual al numero actual, se resta y se añade el símbolo
            while (numero >= normales[i]) {
                resultado.append(romanos[i]); //Aquí me añade al resultado que ya tengo
                numero -= normales[i]; //Aquí le resta el valor para ir añadiendo nuevos romanos
            }
        }
        return resultado.toString();
        //Se pasa a String para utilizar el método y porque es más compatible
    }
}