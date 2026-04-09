package GestionFicherosFile;

import java.io.*;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RegistroMensajes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Configuramos el formato de hora [HH:mm:ss]
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println("Escribe tus mensajes (escribe 'salir' para terminar):");

        // Fase de Escritura: PrintWriter en modo append
        // Usamos try-with-resources para el cierre automático
        try (PrintWriter pw = new PrintWriter(new FileWriter("log.txt", true))) {

            // Bucle for: inicialización, condición de salida y actualización en una línea
            for (String mensaje = sc.nextLine(); !mensaje.equalsIgnoreCase("salir"); mensaje = sc.nextLine()) {

                String hora = LocalTime.now().format(formatoHora);

                // Escribimos con el formato [HH:mm:ss] mensaje
                pw.println("[" + hora + "] " + mensaje);

                // Vaciamos el buffer para asegurar que se guarde en el disco
                pw.flush();
            }

        } catch (IOException e) {
            System.out.println("Error al escribir: " + e.getMessage());
        }

        //Fase de Lectura: Mostrar contenido con BufferedReader
        System.out.println("\n--- Contenido actual del fichero ---");
        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
            String linea;
            // Leemos línea a línea hasta llegar al final (null) [cite: 895, 901]
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}

//Realmente el flush y close no harian falta, porque el try los hace automatico por ti, pero mete el flush porque:
//Sin el flush dentro del bucle: Si el programa se corta de golpe (por ejemplo, se va la luz o el ordenador se apaga) mientras el usuario está escribiendo mensajes,
// los mensajes que estuvieran en el buffer pero no se hubieran volcado al disco todavía, se perderían.
//Con el flush dentro del bucle: Te aseguras de que cada vez que el usuario pulsa "Intro", el mensaje se guarda físicamente en el archivo al instante.


/*Crea un programa que simule un sistema de escritura:
1.Crea un fichero "log.txt" usando PrintWriter en modo append
2.En un bucle, pide al usuario mensajes por consola
3.Escribe cada mensaje en el fichero con formato:[HH:mm:ss] mensaje
4.El usuario escribe "salir" para terminar
5.Finalmente, lee y muestra todo el contenido del log con BufferedReader

Investiga el uso de las librerías java.time.LocalTime y java.time.format.DateTimeFormatter para obtener la hora actual.*/