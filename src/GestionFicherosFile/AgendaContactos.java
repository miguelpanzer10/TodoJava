package GestionFicherosFile;

import java.io.*;

public class AgendaContactos {
    public static void main(String[] args) {
        // 1. Escritura de contactos en "agenda.dat"
        // Se usa FileOutputStream para el destino y DataOutputStream para tipos primitivos
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("agenda.dat"))) {

            // Contacto 1
            dos.writeUTF("Daniel Garcia"); // Nombre
            dos.writeInt(912344556);    // Teléfono
            dos.writeInt(25);           // Edad

            // Contacto 2
            dos.writeUTF("Alejandro De");
            dos.writeInt(934556677);
            dos.writeInt(30);

            // Contacto 3
            dos.writeUTF("Sara Martinez");
            dos.writeInt(911223344);
            dos.writeInt(22);

            dos.flush(); // Fuerza la escritura de los datos pendientes
            System.out.println("Contactos guardados correctamente.\n");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Lectura de contactos usando DataInputStream
        System.out.println("--- Lista de contactos ---");
        try (DataInputStream dis = new DataInputStream(new FileInputStream("agenda.dat"))) {

            // Bucle infinito que se romperá al saltar la EOFException
            while (true) {
                // Se debe leer exactamente en el mismo orden que se escribió: UTF -> Int -> Int
                String nombre = dis.readUTF();
                int telefono = dis.readInt();
                int edad = dis.readInt();

                // Mostrar contactos formateados
                System.out.println("Nombre: " + nombre + " | Tel: " + telefono + " | Edad: " + edad);
            }

        } catch (EOFException e) {
            // Este bloque se ejecuta automáticamente al llegar al final del fichero
            System.out.println("\n--- Fin de la agenda ---");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}








/*Crea un programa que gestione una agenda de contactos:
1.  Usa DataOutputStream para guardar en "agenda.dat":
Nombre (writeUTF), teléfono (writeInt), edad (writeInt)
2.  Guarda al menos 3 contactos
3.  Usa DataInputStream para leer todos los contactos
4.  Usa un bucle con captura de EOFException para detectar el final
5.  Muestra los contactos formateados por pantalla
Recuerda: readUTF/readInt deben seguir el mismo orden que writeUTF/writeInt.*/