package RetosUF01;

import java.util.Scanner;
// Importo que pueda utilizar scanner, ya que no es una clase fundamental.
public class horasmin {
    public void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        /*Aquí, creo un Scanner(le llamo lector) y decirle de dónde va a leer los datos.
        Lo más común es leer desde la entrada estándar del sistema, que es la consola/teclado, usando System*/
        System.out.println("Bienvenido al conversor de tiempo:");
        System.out.println("--------------------------------------------------------");
        System.out.println("Primero, ingresa la cantidad de segundos que quieres convertir:");
        int segundos = lector.nextInt();
                /* aquí, creo la variable string segundos y le digo al scanner que
                lea el dato como un int, con lector.nextInt*/
        System.out.println("Genial, ahora veamos a calcular a cuantas horas, min y seg corresponden:");
        System.out.println("----------------------------------:");
        int horas= segundos/3600;
        //paso los segundos a horas
        int segundosrestantes= segundos%3600;
        //Calculo los segundos que sobran
        int minutos= segundosrestantes/60;
        //calculo con el  resto de antes, los minutos que son
        int segundosfinales= segundosrestantes%60;
        //Calculo los segundos que quedan al final, como resto de lo anterior
        System.out.println("Los "+ segundos +" seg"+ "equivalen a:");
        System.out.println(horas + " horas, " + minutos+" min, " + segundosfinales+ " seg");}

}