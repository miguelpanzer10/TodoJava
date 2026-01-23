package EjerciciosVarios;
import java.util.Scanner;

//Enunciado: hay un PIN correcto(1234)
//Pide al usuario el pin hasta que lo acierte o agote 3 intentos
//Usa un booleano acertado para salir del bucle
//salida final: Acceso concedido o tarjeta bloqueada
public class Tarjeta {
    static void main(String[] args) {
        int pin;
        int intento=3;
        int pinFinal;
        boolean contra=false;

        System.out.println("Ingrese la contraseña que quiere establecer, sólo admite valores numéricos");
        Scanner sc = new Scanner(System.in);
        pin= sc.nextInt();

        do{
        System.out.println("Ahora introduce la contraseña correctamente para entrar, tienes tres intentos:");
        pinFinal= sc.nextInt();
        if(pinFinal==pin){
            contra=true;
            System.out.println("Acceso concedido, bienvenido.");}

        else {
            intento--;
            System.out.println("Acceso denegado, te quedan "+ intento+ " intentos:");}

        }//final del do

        while(intento>0 && contra==false);//while del do

        if(intento==0){
            System.out.println("Lo sentimos, tarjeta bloqueada");
        }
        sc.close();
    }

}
