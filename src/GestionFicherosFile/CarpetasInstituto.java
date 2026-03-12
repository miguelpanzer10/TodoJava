package GestionFicherosFile;

import java.io.File;

public class CarpetasInstituto {
    public static void main(String[] args) {
        //Creo el archivo instituto y si no existe el directorio, lo creo con mkdir
        File instituto = new File("instituto");
        if (!instituto.exists()) {
            instituto.mkdir();}
        //Ahora creo una ruta anidada dentro de instituto
        //le metes instituto ya y luego la ruta
        File ruta=new File(instituto,"/cursos/DAM/primero");
        ruta.mkdirs();

        System.out.println("\n--- Comprobación de los elementos de instituto:");
        //Ahora creo un archivo para listar los directorios
        File[] archivos=instituto.listFiles();
        for (File archivo : archivos) {
            if (archivo.isDirectory()) {
                System.out.println(archivo.getName() + " es un directorio");
            }
            else if(archivo.isFile()) {
                System.out.println(archivo.getName() + " es un archivo");
            }

        }
        // Obtener nombres con list() y mostrar con do-while
        System.out.println("\n--- Nombres de elementos (list) ---");
        String[] nombres = instituto.list();

        if (nombres != null && nombres.length > 0) {
            int i = 0;
            do {
                System.out.println("Nombre: " + nombres[i]);
                i++;
            } while (i < nombres.length);
        } else {
            System.out.println("La carpeta está vacía.");
        }

        //Intentar borrar "primero" con delete()
        System.out.println("\n--- Intento de borrado ---");
        // Usamos la variable 'ruta' que ya apunta a "instituto/cursos/DAM/primero"
        ruta.delete();
        if (ruta.exists()) {
            System.out.println("No se pudo eliminar la carpeta 'primero");
        } else {
            System.out.println("La carpeta 'primero' ha sido eliminada correctamente.");
        }

    }
}

/*Un instituto quiere organizar sus carpetas de datos. Escribe un programa en Java que haga lo siguiente:
* Comrpobar con if si existe la carpeta "instituto" usando exists(), si no existe, crearla con mkdir()
* Dentro de instituto, crear la ruta anidada "cursos/DAM/primero" usando mkdirs()
* Usar listFiles() y recorrer el contenido de "instituto" con un bucle for. Para cada elemento, usar if/else con isDirectory() para indicar si es directorio o fichero
* Obtener los nombres con list() y mostrarlos con un do-while(solo si el array no es null)
* Intentar borrar "primero" con delete() y usar if/else para mostrar si se puede eliminar*/
