package UF02Programacion;
import java.util.Scanner;

public class Ejercicio16Cajero {
    int BC=0;
    int BV=0;
    int BD=0;


    public  void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         System.out.println("¿Cuánto dinero quieres sacar? ");
         int BC=0;
         int BV=0;
         int BD=0;
        int N= sc.nextInt();
        int C=N;
        int resto;
        while (C>=50000){
            BC=BC+1;
            C=C-50000;
            resto=C;
        }
         while (C>=20000){
             BV=BV+1;
             C=C-20000;
            resto=C;
         }
        while (C>=10000){
            BD=BD+1;
            C=C-10000;
            resto=C;
        }

         System.out.println("Cantidad solicitada: "+ N);
         System.out.println("Billetes de 50 sacados: " +BC);
         System.out.println("Billetes de 20 sacados: " +BV);
         System.out.println("Billetes de 10 sacados: " +BD);
         System.out.println("Billetes totales sacados: "+(BC+BV+BD));
         System.out.println("Calderilla: "+ C);


    }

}
