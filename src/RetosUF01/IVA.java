package RetosUF01;

import java.util.Scanner;
public class IVA {
//Aquí necesito hacer estas importaciones para usar luego las funciones

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        //Creo el escaner
        System.out.println("Bienvenido al calculador dr IVA");
        System.out.println("----------------------------------------");
        System.out.println("Ingresa el precio sobre el que quieres calcular el IVA");
        double precio = sn.nextDouble();
        //declaro la variable double precio
        System.out.println("Perfecto, ahora selecciona(sin el %) cuanto % de IVA quieres entre 0 y 25");
        System.out.println("------------------------------------------");
        double iva = sn.nextDouble();
        //Declaro la variable opcion para que elija el iva
        double precioconIVA = precio -(precio* (iva/100));
        //Calculo los precios con y sin iva
        double preciosinIVA = precio-iva;
//Doy los resultados con formateo
        System.out.printf("El IVA cobrado ha sido %.2f%n",iva);
        System.out.printf("La compra sin IVA ha sido %.2f%n",precio);
        System.out.printf("El total de la compra ha sido %.2f%n",precioconIVA);
    }
}
