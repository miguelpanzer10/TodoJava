package EjerciciosVarios;


import java.util.Scanner;
// Importo que pueda utilizar scanner, ya que no es una clase fundamental.
public class InteresSimple {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        /*Aquí, creo un Scanner(le llamo lector) y decirle de dónde va a leer los datos.
        Lo más común es leer desde la entrada estándar del sistema, que es la consola/teclado, usando System.in*/
        System.out.println("Bienvenido al calculador de interés simple:");
        System.out.println("--------------------------------------------------------");
        System.out.println("Primero, ingresa tu Nombre y apellidos:");
        String nombre = lector.nextLine();
        /* aquí, creo la variable texto nombre y le digo al scanner que
                lea el dato como un número decimal, con lector.nextLine para que cuente espacios*/
        System.out.println("Ahora, ingresa tu capital inicial y pulsa enter:");
        double capital = lector.nextDouble();
                /* aquí, creo la variable decimal capital y le digo al scanner que
                lea el dato como un número decimal, con lector.nextDouble*/
        System.out.println("Genial, ahora ingresa tu tasa (sin el %) por favor y pulsa enter:");
        double tasa = lector.nextDouble();
        //Lo mismo que antes pero con tasa//
        double tasareal = tasa/100;
        //Aquí creo la variable tasareal que me va a dar la tasa en porcentaje //
        System.out.println("Por último, dime el plazo de tiempo en años y pulsa enter:");
        double tiempo = lector.nextDouble();
        //Lo mismo que antes pero con tiempo en años//
        double interes= (capital*tasareal*tiempo);
        double capitalfinal= interes+capital;
        //Aquí calculo el capital final que tendrás cuando tiene el interés//
        double interespromedio= interes/12;
        //Aquí obtengo el interes mensual promedio, dividiendo el anual entre los 1 meses//
        System.out.printf("Perfecto, tu Interés total es %.2f%n", interes);
        System.out.printf(" Tu capital final generado es %.2f", capital);
        System.out.printf(" y tu interés promedio mensual es %.2f", interespromedio);
        // En estos pasos, imprimo formateados a dos decimales los valores de interes, capital final e interes promedio//
        lector.close(); // Cierra el Scanner al terminar.
    }
}
