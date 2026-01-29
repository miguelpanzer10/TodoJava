package EjerciciosGemini;
/* * REGISTRO SEMANAL: Crea un Array de 7 posiciones para las temperaturas de la semana.
 * 1. Llena el array pidiendo los datos al usuario con un bucle for.
 * 2. Usa otro bucle para encontrar la temperatura máxima y la mínima.
 * 3. Muestra por pantalla el listado completo y los valores extremo (Max/Min).
 */

import java.util.Scanner;

public class TemperaturaSemanal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al registrador de temperatura semanal");
        System.out.println("Ahora, tendrás que ir registrando temperaturas de los 7 días de la semana:");
        System.out.println("-------------------------------------------------------------------------------");

        double[] temperaturas = new double[7];
        // Los corchetes [] significa que es un array
        // new double[7]: Aquí es donde sucede la magia.
        // new: Es la orden para que Java reserve espacio en la memoria.
        // [7]: Es el tamaño. Le estás diciendo que el archivador tiene exactamente 7 cajones (uno para cada día de la semana).

        //Creo el bucle for para pedirle al usuario las temperaturas de cada día
        for(int i=0; i<temperaturas.length; i++){
            System.out.println("Digite la temperatura del día "+(i+1)+":");
            temperaturas[i] = sc.nextDouble();
            //con esto, le asigna lo que introduce el usuario, a cada posición del array
        }

        double maxTemperatura = temperaturas[0];
        //Creo una variable maximo para registrar la maxima temperatura para hacer el bucle
        //Aquí, creo un bucle que establezca la temperatura maxima y la compare con la actual
        //si la actual es mas grande que la maxima, ahora la maxima vale lo que la actual
        //asi luego llamo a la maximo y me aseguro de que es la mas alta
        for(int i=0; i<temperaturas.length; i++){
            if(temperaturas[i]>maxTemperatura){
                maxTemperatura = temperaturas[i];
            }
        }
        //Hago lo mismo con la minima temperatura
        double minTemperatura = temperaturas[0];
        for(int i=0; i<temperaturas.length; i++){
            if(temperaturas[i]<minTemperatura){
                minTemperatura = temperaturas[i];
            }
        }

        System.out.println("Lista de tempearturas completas:");
        System.out.println("-----------------------------------");
        for(int i=0; i<temperaturas.length; i++){
            System.out.println("Temperatura del día " + (i+1)+ ": "+temperaturas[i]);
        }
        System.out.println("Tempratura maxima: "+maxTemperatura);
        System.out.println("Tempratura minima: "+minTemperatura);


    }
}
