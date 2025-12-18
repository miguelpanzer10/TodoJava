package UF02Programacion;
import java.util.Scanner;
// Importo que pueda utilizar scanner, ya que no es una clase fundamental.
public class Operaciones {
    public static void main(String[] args){
        System.out.println("Bienvenido al calculador de operaciones!!");
        System.out.println("En base a dos números, calcularemos:");
        System.out.println("Suma, resta, multiplicacion y división");

        Operaciones objeto = new Operaciones();
        //Para llamar a los métodos que quiera crear, antes, necesito tener un objeto de la clase
        double[] datos = objeto.leerDatos();
        //Como leerDatos devuelve un array de int,
        double multiplicacion= objeto.Multiplicacion(datos);
        //creo la varables multiplicacion, suma, resta... que recoja los datos introducidos para calcularse
        double suma= objeto.Suma(datos);
        double resta= objeto.Resta(datos);
        double division= objeto.Division(datos);
        objeto.mostrarResultado("suma", suma);
        objeto.mostrarResultado("resta",resta);
        objeto.mostrarResultado("multiplicación", multiplicacion);
        objeto.mostrarResultado("division", division);
        /* Aquí, le vuelvo a pasar al objeto, la funcion mostrarResultado
         con los diferenets nombres como el String que me pide el método y
         double(el double de la variable de cada operacion) */
    }
    public double[] leerDatos() {
        // Se define un método público llamado 'leerDatos' que devuelve un array de double (double[]).
        // Este método no recibe parámetros.
        Scanner scanner = new Scanner(System.in);
        // Se crea un objeto 'Scanner' para leer datos desde la entrada estándar (normalmente el teclado).
        System.out.println("Por favor, introduce el primer número:");
        // Se solicita al usuario que introduzca el primer numero
        double primero = scanner.nextDouble();
        // Se lee el valor introducido por el usuario y se guarda en la variable 'primero'.
        System.out.println("Por favor, introduce el segundo número:");
        // Se solicita al usuario que introduzca el segundo número
        double segundo = scanner.nextDouble();
        // Se lee el valor introducido por el usuario y se guarda en la variable 'segundo'.
        scanner.close();

        return new double[]{primero, segundo};
         /* Se devuelve un array de enteros que contiene los valores de 'primer' y 'segundo'.
            El new en la línea return new,
            se utiliza porque estás creando una nueva instancia de un array de enteros en ese mismo momento*/
    }
    public double Suma(double[]datos){
        double numero1 = datos[0]; // El primer número del array
        double numero2 = datos[1]; // El segundo número del array
        double ResultadoSuma= numero1 + numero2;
        return ResultadoSuma;
        //Metodo suma
    }
    public double Resta(double[]datos){
        double numero1 = datos[0]; // El primer número del array
        double numero2 = datos[1]; // El segundo número del array
        double ResultadoResta= numero1 - numero2;
        return ResultadoResta;
        //Método resta
    }
    public double Multiplicacion(double[]datos) {
        double numero1 = datos[0]; // El primer número del array
        double numero2 = datos[1]; // El segundo número del array
        double ResultadoMultiplicacion = numero1 * numero2;
        return ResultadoMultiplicacion;
        //Método multiplicacion
    }
    public double Division(double[]datos) {
        double numero1 = datos[0]; // El primer número del array
        double numero2 = datos[1]; // El segundo número del array
        double ResultadoDivision = numero1 / numero2;
        return ResultadoDivision;
        //Método division
    }
    public void mostrarResultado(String calculo, double operacion){
        System.out.printf("La %s obtenida es de %.2f%n",calculo,operacion);
        /*Aquí creo el método para que muestre los resultados, le paso como parametros:
        String que le llamo calculo y un double que le llamo operacion*/
    }

}
