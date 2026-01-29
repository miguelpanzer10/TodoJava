package EjerciciosVarios;
import java.util.Scanner;

/*Encuentra el primer múltiplo
 Enunciado: Pide un número n(>0)
 Encuentra con un bucle el primer múltiplo de n que sea mayor o igual que 100
 Muestra el múltiplo encontrado y cuántas veces se ha ejecutado el bucle
 (se valora hacerlo sin usar divisiones para adivinarlo*/

public class Multiplo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.println("Bienvenido al calculador de múltiplos");

        // Bucle de validación: se repite hasta que numero sea > 0
        do {
            System.out.print("Ingresa un número (debe ser mayor que 0): ");
            numero = sc.nextInt();

            if (numero <= 0) {
                System.out.println("Error: El número " + numero + " no es válido.");
            }
        } while (numero <= 0);

        // Una vez que salimos del do-while, ya sabemos que numero > 0
        int resultado = 0;
        int vueltas = 0;

        // Bucle para encontrar el múltiplo
        for (resultado = 0; resultado < 100; resultado += numero) {
            vueltas++;
        }

        System.out.println("--------------------------------");
        System.out.println("El primer múltiplo mayor o igual a 100 es: " + resultado);
        System.out.println("Se ha ejecutado el bucle " + vueltas + " veces.");

        sc.close();
    }
}

