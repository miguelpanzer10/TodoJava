package UF02Programacion;

import java.util.Scanner; //Aquí necesito hacer estas importaciones para usar luego las funciones
import java.util.Random;
public class MikyMachine {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        Random rand = new Random();
        int opcion;
        do {  //Hago un do while, que es más cómodo para este caso y sólo se sale en el 4
            System.out.println("Mini Proyecto MikyMachine");
            System.out.println("----------------------------------------");
            System.out.println("1. Calcular el precio final con su IVA");
            System.out.println("2.Mostrar números pares entre dos valores");
            System.out.println("3.Generación de un número aleatorio");
            System.out.println("4.Salir del programa");
            System.out.println("--------------------------------------");

            opcion =  sn.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el precio sobre el que quieres calcular el IVA");
                    double precio = sn.nextDouble();
                    System.out.println("Perfecto, ahora selecciona que tipo de IVA quieres");
                    System.out.println("------------------------------------------");
                    System.out.println("1.IVA al 30%");
                    System.out.println("2.IVA al 10%");
                    System.out.println("3.IVA al 21%");
                    int opcion2 = sn.nextInt();
                    switch (opcion2) {
                        case 1:
                            System.out.println(precio + " El total con un 30% de IVA seria: " + precio * 1.30);break;
                        case 2:
                            System.out.println(precio + " El total con un 10% de IVA seria: " + precio * 1.10);break;
                        case 3:
                            System.out.println(precio + " El total con un 21% de IVA seria: " + precio * 1.21);  break;
//Se multiplica 1.30 1.10 porque así lo calculas directamente y te evitas hacer el x 0,3 y luego sumarlo
                    }
                    System.out.println("------------------------------------------");
                    System.out.println();break;

                case 2:
                    System.out.println("Ahora necesitamos dos números para calcular los pares entre ellos. Ingresa el primer numero");
                    int numero1 = sn.nextInt();
                    System.out.println("Bien hecho,  ahora ingresa el segundo numero");
                    int numero2 = sn.nextInt();
                    System.out.println("Estos serian los numero pares que hay entre esos números:");
                    for (int i = numero1; i <= numero2; i++) {if (i%2==0){System.out.print(i+", ");  } }
                    System.out.println("------------------------------------------");
                    System.out.println();break;
                case 3:
                    int numeroAleatorio = rand.nextInt(100);
                    System.out.println("Aqui esta tu numero aleatorio: " + numeroAleatorio);
                    System.out.println("------------------------------------------");
                    System.out.println(); break;
                case 4:
                    System.out.println("Saliendo del sistema..."); }
        }while (opcion != 4);}}
