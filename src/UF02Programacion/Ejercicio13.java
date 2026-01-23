package UF02Programacion;

import java.util.Scanner;

public class Ejercicio13{
     void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Numero_obreros;
        double Total_nomina = 0;
        int Numero_horas_trabajadas;

        System.out.println("Introduce cuantos obreros tiene la empresa: ");
        Numero_obreros = sc.nextInt();
        System.out.println("Número de obreros: "+Numero_obreros);

        while (Numero_obreros > 0){
            System.out.println("Introduce ahora, cuantas horas trabaja el obrero sobre el que quieres calcular la nómina: ");
            Numero_horas_trabajadas = sc.nextInt();
            System.out.println("Horas Trabajadas: "+Numero_horas_trabajadas);
            double Salario = Numero_horas_trabajadas * 30;
            System.out.println("Como la hora se paga a 30eur, vamos a calcular cuanto gana cada obrero): ");
            System.out.println("El salario es: "+Salario+" €");
            Total_nomina = Total_nomina + Salario;
            System.out.println("El total de su nómina es: "+Total_nomina+" €");
            Numero_obreros -= 1;
        }

    }
}