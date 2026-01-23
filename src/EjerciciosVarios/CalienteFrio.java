package EjerciciosVarios;
import java.util.Scanner;
import java.util.Random;

//Importo el random para generar el aleatorio
//Adivina el número con caliente-frio
//El número secreto es fijo
//El usuario prueba hasta acertar
//Si la diferencia es de 3: "Caliente", si la diferencia es de 10: "Templado", si la diferencia es mayor que 10: "Frio".
//Para que sea negativo vamos a multiplicarlo por -1

public class CalienteFrio {

    public static void main(String[] args) {
        Random rand = new Random();
        int secreto= rand.nextInt(101);
        System.out.println("(Chivatazo para pruebas: El número es " + secreto + ")");
        int numero;
        int diferencia;
        boolean encontrado=false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al juego de caliente/frio");
        System.out.println("Intenta adivinar un número secreto del 0 al 100, tienes intentos ilimitados. Prueba, dime un número:");

        do {
            System.out.println("Ingresa el numero ");
            numero = sc.nextInt();
            diferencia = Math.abs(numero - secreto);
            //con math abs me aseguro que el num lo hace absoluto siempre
            if (numero < 0 || numero > 100) {
                System.out.println("El núimero tiene que ser entre 0 y 100");

            } else {
                if (diferencia == 0) {
                    encontrado = true;
                    System.out.println("Lo has clavao fenómemo!!!!");
                }
                else if (diferencia <= 3 && diferencia > 0) {
                    System.out.println("Caliente, caliente");
                }
                else if (diferencia > 3 && diferencia <= 10) {
                    System.out.println("Templadiiiito");
                }
                else {
                    System.out.println("Frio frio");
                }
            }
        }
        while(!encontrado);

        sc.close();
    }

}
