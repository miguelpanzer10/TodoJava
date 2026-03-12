package GestionFicherosFile;

import java.io.*; //importar clases de entrada/salida

public class LeerFichero {
    public static void main(String[] args) {
        try ( //try.with-resources: cierra el flujo solo
                BufferedReader entrada = new BufferedReader( //lector con buffer (lee lineas)
                        new FileReader("datos.txt"))) { //abre el fichero de texto
            String linea; //variable para guardar cada linea
            while ((linea = entrada.readLine()) != null) { //lee cada linea del fichero mientras haya
                System.out.println(linea); //imprime la linea
            }
        } catch (IOException e) { //si no puede leer el fichero salta el error
            e.printStackTrace();
        }

    }
}
