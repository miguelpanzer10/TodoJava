package GestionFicherosFile;

import java.io.*;
import java.util.Scanner;

public class FicheroStreams {
    public static void main(String[] args) { // Ya no hace falta el throws IOException
        System.out.println("Bienvenido a la lectura de ficheros");
        Scanner sc = new Scanner(System.in);
        System.out.println("Tenemos un fichero que recoge el nombre de los alumnos:");
        System.out.println("Escribe el nombre de 5 alumnos, separados por comas:");
        String nombres = sc.nextLine();

        // 1. Escritura del archivo usando try-with-resources
        //Con fileWriter me deja escribir en el archivo y si este no existe, lo crea, asi me evito usar
        //el createnewfile
        try (FileWriter alumnos = new FileWriter("alumnos.txt")) {
            // Cortamos el String por las comas para separar los nombres
            String[] arrayNombres = nombres.split(",");

            for (String nombre : arrayNombres) {
                // Escribimos el nombre. El método .trim() quita los espacios en blanco sobrantes
                // y el "\n" añade el salto de línea para que el siguiente vaya abajo.
                alumnos.write(nombre.trim() + "\n");
            }
            System.out.println("Nombres guardados correctamente.\n");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir: " + e.getMessage());
        }

        System.out.println("--- Leyendo el contenido del fichero ---");

        // 2, 3 y 5. Lectura del archivo
        try (BufferedReader entrada = new BufferedReader(new FileReader("alumnos.txt"))) {
            String linea;
            int numeroLinea = 1; // Contador para cumplir el punto 4

            while ((linea = entrada.readLine()) != null) {
                // 4. Muestra cada nombre por consola con su número de línea
                System.out.println(numeroLinea + ". " + linea);
                numeroLinea++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}

/*Crea un programa Java que lea un fichero de texto línea a línea utilizando flujos de datos (streams):
1.Crea un fichero de texto llamado alumnos.txt con al menos 5 nombres
2.Abre el fichero usando un flujo de caracteres de entrada (FileReader)
3.Envuélvelo con BufferedReader para leer línea a línea
4.Muestra cada nombre por consola con su número de línea
5.Utiliza try-with-resources para cerrar el flujo automáticamente
Utiliza las clases de flujo de caracteres (Reader/Writer) vistas en las diapositivas anteriores.*/