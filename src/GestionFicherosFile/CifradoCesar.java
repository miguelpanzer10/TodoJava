package GestionFicherosFile;

import java.io.*; //importar clases de entrada/salida
import java.util.Scanner;

public class CifradoCesar {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una frase por consola:");
        String frase = sc.nextLine();
        //Voy a crear el archivo y escribir en el la frase
        FileWriter fw= new FileWriter("cifrado.txt");
        for(char c : frase.toCharArray()){
            fw.write(c*2);
        }fw.close();

        FileReader fr = new FileReader("cifrado.txt");
        FileWriter fw2= new FileWriter("descifrado.txt");
        int leer;
        while((leer = fr.read())!=-1){
            fw2.write(leer/2);
        } fr.close();
        fw2.close();

    }
}

/*1. Pide al usuario una frase por consola.
2. Cifra la frase multiplicando por 2 el código ASCII de cada carácter.
3. Escribe la frase cifrada en un fichero llamado "cifrado.txt".
4. Crea un método descifrarFichero() que:

a. Lea el fichero cifrado con FileReader

b. Divida por 2 cada valor leído para obtener el carácter original

c. Muestre el mensaje descifrado por pantalla

Ejemplo: 'A' (65) → cifrado: 130 → descifrado: 65 → 'A'*/