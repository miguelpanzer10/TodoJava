package GestionFicherosFile;
import java.io.*;
import java.util.Scanner;

public class ExploradorFicheros {
    public static void main(String[] args) {
        System.out.println("Bienvenido al explorador de ficheros");
        System.out.println("-----------------------------------------");
        System.out.println("Primero, escriba la ruta que quiera comprobar:");

        Scanner sc = new Scanner(System.in);
        String ruta = sc.nextLine();
        File archivoruta = new File(ruta);

        // Comprobamos si la ruta existe antes de hacer nada
        if (!archivoruta.exists()) {
            System.out.println("Error: La ruta introducida no existe.");
        } else {
            // Si es un directorio
            if (archivoruta.isDirectory()) {
                System.out.println(archivoruta.getName() + " es un directorio\n");

                // Listamos el contenido usando [FICHERO] o [DIR]
                File[] archivos = archivoruta.listFiles();
                if (archivos != null) {
                    System.out.println("Contenido del directorio:");
                    for (File archivo : archivos) {
                        if (archivo.isDirectory()) {
                            System.out.println("[DIR] " + archivo.getName());
                        } else if (archivo.isFile()) {
                            System.out.println("[FICHERO] " + archivo.getName());
                        }
                    }
                }

                // Pedimos el nombre para crear un archivo nuevo
                System.out.println("\nIntroduce el nombre del archivo que quieras crear en el directorio:");
                String archivonuevo = sc.nextLine();
                File archivocreado = new File(archivoruta, archivonuevo);

                // Aquí creamos el archivo físicamente en el disco
                try {
                    if (archivocreado.createNewFile()) {
                        System.out.println("¡Archivo creado con éxito!");
                    } else {
                        System.out.println("El archivo ya existe en este directorio.");
                    }
                } catch (IOException e) {
                    System.out.println("Ocurrió un error al crear el archivo: " + e.getMessage());
                }

            }
            // Si es un fichero
            else if (archivoruta.isFile()) {
                // Mostramos nombre, tamaño y permisos
                System.out.println("La ruta apunta a un archivo.");
                System.out.println("Nombre: " + archivoruta.getName());
                System.out.println("Tamaño: " + archivoruta.length() + " bytes");

                // Usamos if independientes para que evalúe ambos permisos
                if (archivoruta.canRead()) {
                    System.out.println("- Tiene permisos de lectura");
                }
                if (archivoruta.canWrite()) {
                    System.out.println("- Tiene permisos de escritura");
                }
            }
        }

        // Cerramos el scanner
        sc.close();
    }
}



/*Crea un programa que permita obtener información sobre un fichero o directorio:
1.  Pide al usuario una ruta por consola
2.  Muestra si es un fichero o un directorio
3.  Si es fichero: muestra nombre, tamaño, permisos de lectura/escritura
4.  Si es directorio: lista todo su contenido mostrando [FICHERO] o [DIR]
5.  Si es directorio: pide un nombre por consola y crea un nuevo fichero dentro
Utiliza los métodos de la clase File vistos en las diapositivas anteriores.*/