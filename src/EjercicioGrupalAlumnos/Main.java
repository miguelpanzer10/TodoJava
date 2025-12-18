package EjercicioGrupalAlumnos;
import java.io.*;
import java.util.Scanner;

public class Main {

    Scanner sc = new Scanner(System.in);
    static final String FILE_NAME = "alumnos.txt";

    public static void main(String[] args) {
        Main procesos = new Main();
        int opcion;

        do {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Añadir alumno");
            System.out.println("2. Consultar alumno");
            System.out.println("3. Contar alumnos");
            System.out.println("4. Contar aprobados y suspensos");
            System.out.println("5. Salir");
            System.out.print("Opción: ");

            opcion = Integer.parseInt(procesos.sc.nextLine());

            switch (opcion) {
                case 1:
                    String nombre = procesos.leerNombre();
                    double[] notas = procesos.leerNotas();
                    double media = procesos.calculoNotas(notas);
                    String estado = media >= 5 ? "Aprobado" : "Suspenso";
                    procesos.guardarAlumno(nombre, notas, media, estado);
                    System.out.println("Alumno guardado correctamente.");
                    break;

                case 2:
                    System.out.print("Introduce el nombre del alumno a buscar: ");
                    String nombreBuscar = procesos.sc.nextLine();
                    procesos.buscarAlumno(nombreBuscar);
                    break;

                case 3:
                    int total = procesos.contarAlumnos();
                    System.out.println("Total de alumnos: " + total);
                    break;

                case 4:
                    procesos.contarAprobadosYSuspensos();
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);
    }

    // Leer nombre
    public String leerNombre() {
        System.out.print("Introduce el nombre del alumno: ");
        return sc.nextLine();
    }

    // Leer 3 notas
    public double[] leerNotas() {
        double[] notas = new double[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Nota " + (i + 1) + ": ");
            notas[i] = Double.parseDouble(sc.nextLine());
        }
        return notas;
    }

    // Calcular media
    public double calculoNotas(double[] notas) {
        double suma = 0;
        for (double n : notas) suma += n;
        return suma / notas.length;
    }

    // Guardar alumno en archivo
    public void guardarAlumno(String nombre, double[] notas, double media, String estado) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(nombre + ";" + notas[0] + ";" + notas[1] + ";" + notas[2] + ";" + media + ";" + estado);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo.");
        }
    }

    // Buscar alumno en archivo
    public void buscarAlumno(String nombreBuscar) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String linea;
            boolean encontrado = false;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");

                if (datos[0].equalsIgnoreCase(nombreBuscar)) {
                    System.out.println("\nAlumno encontrado:");
                    System.out.println("Nombre: " + datos[0]);
                    System.out.println("Nota 1: " + datos[1]);
                    System.out.println("Nota 2: " + datos[2]);
                    System.out.println("Nota 3: " + datos[3]);
                    System.out.println("Media: " + datos[4]);
                    System.out.println("Estado: " + datos[5]);
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("Alumno no encontrado.");
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }

    // Contar alumnos totales
    public int contarAlumnos() {
        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            while (br.readLine() != null) contador++;
        } catch (IOException e) {
            System.out.println("Error al contar los alumnos.");
        }
        return contador;
    }

    // Contar aprobados y suspensos
    public void contarAprobadosYSuspensos() {
        int aprobados = 0;
        int suspensos = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                String estado = datos[5];

                if (estado.equals("Aprobado")) aprobados++;
                else suspensos++;
            }

            System.out.println("Aprobados: " + aprobados);
            System.out.println("Suspensos: " + suspensos);

        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }
}


