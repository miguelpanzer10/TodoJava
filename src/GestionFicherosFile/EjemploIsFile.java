

//Junto varios ejemplos de objetos y métodos para verlo todo explicado

package GestionFicherosFile;

import java.io.*;

public class EjemploIsFile {
    public static void main(String[] args) throws IOException {
        //throws IOException es necesario para el createNewFile,
        //lo que hace es, devuelve el error al main para que lo depure
        File f1 = new File("registro.txt");
        File f2 = new File("C:/Windows");
        File f3 = new File("C:/Windows/explorer.exe");
        File f4 = new File("C:/rutaInventada");

    //isFile comprueba si hay un fichero y exists si existe la ruta en el disco

        System.out.println(f1.isFile()); //false: no existe el fichero
        System.out.println(f2.isFile()); //false:es directorio, no hay fichero
        System.out.println(f3.isFile()); //true:es fichero real

        System.out.println(f2.exists()); //true porque existe la ruta en el disco
        System.out.println(f4.exists()); //false porque no existe la ruta en el disco
        System.out.println(f3.exists()); //true


        //Ahora vamos a probar la de createNewFile para que cree el fichero si no existe
        boolean ok = f1.createNewFile();
        if (ok) {
            System.out.println("Fichero creado" + f1.getName());
        } else {
            System.out.println("Fichero no creado" + f1.getName());
        }
        //si ya lo ejecuto una vez, si existe el archivo, no lo creará


        //Ahora pruebo el canRead para evr si se puede leer o no el fichero, en mi caso sí
        if(f1.canRead()){
            System.out.println("Permiso de lectura: Sí");}
            else{
                System.out.println("Permiso de lectura: No");
        }


        //Ahora vamos a probar el ReadOnly y el canWrite
        System.out.println(f1.canWrite());//aqui le dejo escribir

        f1.setReadOnly();//aqui lo cambio a sólo lectura
        System.out.println(f1.canWrite());//me dara false porque no deja escribir

        f1.setWritable(true);
        System.out.println(f1.canWrite());//Y aquí ahora si me da true, porque lo he hecho editable


        //Vamos a probar FileWriter para escribir en el archivo
        FileWriter fw = new FileWriter(f1); //le paso el objeto f1
        fw.write("Hola Miguel"); //11 caracteres
        fw.close();//lo cierra tras crear

        //y con length() devuelve el tamaño en bytes/tipo long)
        long bytes=f1.length();
        System.out.println("Bytes: "+bytes); // da 11
        System.out.println("KB: "+ (bytes/1024.0));


        //Vamos a probar a eliminar el fichero con delete()
        boolean ok2=f1.delete();
        if (ok2) {
            System.out.println("Fichero eliminado " + f1.getName());
        }
        else{
            System.out.println("Fichero no eliminado " + f1.getName());
        }


        //Ahora vamos a cambiar los nombres con renameto(), que renombra o mueve a otro directorio
        File org = new File("borrador.txt");
        File dest= new File("definitivo.txt");
        org.createNewFile(); //Creo el org

        boolean ok3=org.renameTo(dest);
        System.out.println(ok3); //saldrá true
        System.out.println(org.exists()); //saldrá false porque ya lo ha cambiado
        System.out.println(dest.exists()); //saldrá true porque ya está en destino


        //Ahora con getName vamos a ver como se llama ese fichero o directorio, tanto si existen o no
        //DEVUELVE SÓLO EL ÚLTIMO COMPONENTE DE LA RUTA

        System.out.println(f2.getName()); //Windows
        System.out.println(f3.getName()); //Explorador exe

        //Ahora con getAbsolutePath devuelve la ruta completa desde la raiz

        System.out.println(f2.getAbsolutePath());


    }

}
