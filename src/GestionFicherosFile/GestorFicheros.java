package GestionFicherosFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//IMPORTANTE:UNA VEZ QUE SE EJECUTA HAY QUE BORRAR LOS ARCHIVOS PORQUE SINO DA FALLO
public class GestorFicheros {
    public static void main(String[] args) throws IOException {
        //throws IOException es necesario para el createNewFile,
        //lo que hace es, devuelve el error al main para que lo depure
        File f1 = new File("ventas.txt");
        File f2 = new File("clientes.txt");
        File f3 = new File("productos.txt");

        //Creamos los ficheros
        f1.createNewFile();
        f2.createNewFile();
        f3.createNewFile();

        //Los metemos en un array para poder recorrerlos
        File[] tienda = {f1, f2, f3};
        //Ahora voy a escribir en cada fichero
        FileWriter fw1 = new FileWriter(f1);
        fw1.write("Hola desde ventas");
        fw1.close();//fundamental cerrarlo
        FileWriter fw2 = new FileWriter(f2);
        fw2.write("Hola desde clientes");
        fw2.close();
        FileWriter fw3 = new FileWriter(f3);
        fw3.write("Hola desde productos");
        fw3.close();

        //voy a darles permisos de escritura y lectura aleatorios:
        f1.canWrite();//solo escritura
        f2.setReadOnly();//solo lectura, pero lo hago de escritura tambien
        f2.setWritable(true);//lo hago de escritura también. //podria poner canWrite y canRead
        f3.setReadOnly();//solo lectura


        //Ahora vemos su tamaño en bytes
        long bytes1 = f1.length();
        long bytes2 = f2.length();
        long bytes3 = f3.length();
        //los meto en un array para decir sus bytes
        long[] bytestotal = {bytes1, bytes2, bytes3};


        System.out.println("Comprobando ficheros...");
        System.out.println("---------------------------------------------------------------------------");
        for (int i = 0; i < tienda.length; i++) {
            if (tienda[i].exists() && tienda[i].isFile()) {
                System.out.println("El archivo " + tienda[i].getName() + " existe correctamente.");
                System.out.println(tienda[i] + " tiene: " + bytestotal[i] + " bytes");
                System.out.println("Su ruta absoluta es: " + tienda[i].getAbsolutePath());
                System.out.println("Sus permisos son: ");
                if (tienda[i].canRead()) {
                    System.out.println("El archivo" + tienda[i].getName() + " tiene permisos de lectura ");
                } else {
                    System.out.println("El archivo" + tienda[i].getName() + " no tiene permisos de lectura ");
                }
                if (tienda[i].canWrite()) {
                    System.out.println("El archivo" + tienda[i].getName() + " tiene permisos de escritura");
                } else {
                    System.out.println("El archivo" + tienda[i].getName() + " no tiene permisos de escritura");
                }
                System.out.println("-------------------------------------------------------------------------");

            } else {
                System.out.println("El archivo " + tienda[i].getName() + " NO existe.");
                System.out.println("----------------------------------------------------------------------");
            }
        }


        //Ahora voy a cambiar a ventas txt de nombre, creo el nuevo objeto
        File f4 = new File("ventas_antiguas.txt");
        //si ventas.txt existe, lo renombro
        if (f1.exists()) {
            boolean exito = f1.renameTo(f4); // Intentamos renombrar a ventas
            if (exito) {
                System.out.println("Fichero renombrado correctamente.");
                // Se actualiza el Array: Ahora la posición 0 es el nuevo archivo
            } else {
                System.out.println("No se pudo renombrar");
            }
        }

        //voy a borrar clientes sólo si existe
        if (f2.exists()) {
            boolean comprobacion = f2.delete();
            if (comprobacion) System.out.println("Fichero " + f2.getName() + " eliminado.");
        }

        //Ahora creo un array para el bucle final, que tenga todos los elementos para ver si estan o no
        File[] comprobacion = {f1, f2, f3, f4};

        System.out.println("\n-------------------------------------------------------------------------------------");
        System.out.println("Resumen final de comprobación, vamos a ver que ficheros existen y cuales no:");
        System.out.println("------------------------------------------------------------------------------");

        int contador = 0;
        // Usamos el while con una condición de control basada en el tamaño del array
        while (contador < comprobacion.length) {
            File ficheroActual = comprobacion[contador];

            if (ficheroActual.exists()) {
                System.out.println("El fichero " + ficheroActual.getName() + " existe.");
            } else {
                System.out.println("El fichero " + ficheroActual.getName() + " no existe");
            }

            contador++; // Incremento el contador para que no sea un bucle infinito
        }

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Fin de la gestión de ficheros.");


    }
}

//ENUNCIADO
/*Una tienda guarda sus datos en tres ficheros: ventas.txt, clientes.txt y productos.txt. Antes de ejecutar el programa, crea estos tres ficheros manualmente en la carpeta del proyecto (pueden estar vacíos o con algo de texto).
Tu programa debe hacer lo siguiente:
Recorrer los tres ficheros con un bucle for y, para cada uno, comprobar si existe. Si existe y es un fichero, mostrar su ruta absoluta, su tamaño en bytes y sus permisos de lectura y escritura usando if / else if / else.
Renombrar ventas.txt a ventas_antigua.txt (solo si existe).
Borrar clientes.txt (solo si existe).
Mostrar un resumen final recorriendo con un bucle while los cuatro ficheros (ventas.txt, ventas_antigua.txt, clientes.txt y productos.txt) indicando cuáles existen y cuáles no.
Métodos que debes utilizar: exists(), isFile(), getName(), getAbsolutePath(), length(), canRead(), canWrite(), renameTo() y delete().*/

