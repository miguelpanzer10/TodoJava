package EjerciciosVarios;

//Vas leyendo temperaturas (decimales) hasta que el usuario escriba(stop/exit/parar)
//Debe saltar una alarma si hay 3 lecturas seguidas por encima de 30
//Usa un booleano alarmActiva y un contador de consecutivas.
//Al final indica si hubo alarma o no

import java.util.Scanner;


public class SensorTemperatura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean alarmaActiva = false;
        int contador = 0;
        boolean continuar = true;
        //Creo esta variable para luego salir del bucle
        int numeroAlarma=0;
        //Para mostrar cuantas alarmas han saltado


        System.out.println("--- Bienvenido al captador de temperaturas---");
        System.out.println("Ingresa la temperatura que quieras");
        System.out.println("Escribe 'exit' para terminar.");

        while (continuar) {
            System.out.print("Lectura de temperaturas(Escribe exit si quieres salir): ");

            // Comprobamos si lo que viene es un número y si es así, que lo coja
            if (sc.hasNextDouble()) {
                double temperatura = sc.nextDouble();

                if (temperatura > 30) {
                    contador++;
                } else {
                    contador = 0; // Se rompe la racha
                }

                // Si llegamos a 3 seguidas, activamos alarma
                if (contador == 3) {
                    alarmaActiva = true;
                }

                if (alarmaActiva) {
                    System.out.println("   [!] Alta temperatura: Has introducido tres temperaturas por encima de 30 grados");
                    numeroAlarma++;
                }

            } else {
                // Si NO es un número, leemos la palabra para ver si es de salida
                String entrada = sc.next();

                if (entrada.equalsIgnoreCase("exit")) {
                    continuar = false;
                } else {
                    System.out.println("Entrada no válida. Introduce un número o 'exit'.");
                }
            }
        }

        System.out.println("--------------------------------");
        if (alarmaActiva) {
            System.out.println("RESULTADO: Se detectaron "+numeroAlarma+" Alarmas(una alarma= 3 lecturas seguidas > 30).");
        } else {
            System.out.println("RESULTADO: No hubo alarmas.");
        }

        sc.close();
    }
}

