package GestionFicherosFile;
import java.io.*;

public class GestionAlumnosScanner {
    public static void main(String[] args) {
        File file = new File("alumnos_registro.dat");
        int TAM_REGISTRO = 28; // 10 chars (20 bytes) + 1 double (8 bytes)

        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) { // Modo lectura/escritura

            // 1. Escribir 3 alumnos: Ana (8.5), Luis (6.0), Sara (9.2)
            escribirAlumno(raf, "Ana       ", 8.5); // 10 caracteres exactos
            escribirAlumno(raf, "Luis      ", 6.0);
            escribirAlumno(raf, "Sara      ", 9.2);

            System.out.println("Fichero creado con 3 alumnos.");

            // 2. Lee DIRECTAMENTE el 2º alumno (índice 1)
            // Usamos la fórmula: n * TAM_REGISTRO
            raf.seek(1 * TAM_REGISTRO);
            System.out.println("\nLeyendo el 2º alumno directamente:");
            leerYMostrarAlumno(raf);

            // 3. Modifica la nota del 1er alumno (índice 0) a 9.8
            // La nota empieza después del nombre (10 chars * 2 bytes = 20 bytes)
            int posNotaPrimerAlumno = (0 * TAM_REGISTRO) + 20;
            raf.seek(posNotaPrimerAlumno); // Saltamos directamente a la posición de la nota
            raf.writeDouble(9.8); // Sobrescribimos solo la nota
            System.out.println("\nNota del 1er alumno modificada a 9.8.");

            // 4. Muestra todos los alumnos
            System.out.println("\n=== LISTADO FINAL DE ALUMNOS ===");
            for (int i = 0; i < 3; i++) {
                raf.seek(i * TAM_REGISTRO); // Salto al inicio de cada registro
                leerYMostrarAlumno(raf);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método auxiliar para escribir datos con tamaños fijos
    public static void escribirAlumno(RandomAccessFile raf, String nombre, double nota) throws IOException {
        raf.writeChars(nombre); // Escribe caracteres (2 bytes cada uno)
        raf.writeDouble(nota);  // Escribe double (8 bytes)
    }

    // Método auxiliar para leer un registro en la posición actual
    public static void leerYMostrarAlumno(RandomAccessFile raf) throws IOException {
        String nombre = "";
        for (int i = 0; i < 10; i++) {
            nombre += raf.readChar(); // Lee carácter a carácter
        }
        double nota = raf.readDouble(); // Lee el número real
        System.out.println("Alumno: " + nombre.trim() + " | Nota: " + nota);
    }
}

//Crea un programa que gestione registros de alumnos con RandomAccessFile:
//Cada registro tiene: nombre (10 chars fijos) + nota (double)
//Tamaño registro = 10 × 2 + 8 = 28 bytes
//1.  Escribe 3 alumnos: Ana (8.5), Luis (6.0), Sara (9.2)
//2.  Lee DIRECTAMENTE el 2º alumno sin leer el 1º (usa seek)
//3.  Modifica la nota del 1er alumno a 9.8
//4.  Muestra todos los alumnos
//Usa seek(n × TAM_REGISTRO) para saltar al registro n.