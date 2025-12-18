package RetosUF01;

import java.util.Scanner;
public class sueldo {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        //creo el escaner
        System.out.println("Bienvenido al calculador de sueldo");
        System.out.println("------------------------------------");
        System.out.println("Introduce tu sueldo anual");
        double sueldo = lector.nextDouble();
        //creo la variable sueldo
        System.out.println("Introduce el número de pagas");
        int pagas = lector.nextInt();
        //creo que la variabe pagas
        System.out.println("Se aplicará por defecto una retención del 15%");
        double retenciones = 0.15;
        //Creo la variable retenciones
        //Creo las variables de sueldos año y mes
        double sueldoBruto = sueldo / pagas;
        double sueldoNetoAño = sueldo - (sueldo * retenciones);
        double sueldoNetoMes = sueldoNetoAño / pagas;
        //Saco por pantalla los suelos y valores formateados a 3 decimales el anual y 2 decimales el mensual
        System.out.printf("Tu sueldo bruto anual es %.3f y el sueldo bruto mensual %.2f%n", sueldo, sueldoBruto);
        System.out.printf("El sueldo neto anual es %.3f y el sueldo neto mensual%.2f%n", sueldoNetoAño, sueldoNetoMes);
    }
}

