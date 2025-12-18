package EjerciciosVarios;
import java.util.Scanner;

public class longitudpalabra {
    public void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        /*Aquí, creo un Scanner(le llamo lector) y decirle de dónde va a leer los datos.
        Lo más común es leer desde la entrada estándar del sistema, que es la consola/teclado, usando System*/

        System.out.println("Bienvenido a la aplicación de contador de longitud de una palabra:");
        System.out.println("--------------------------------------------------------");
        System.out.println("Primero, ingresa una palabra:");
        String palabra = lector.nextLine();
                /* aquí, creo la variable string palabra y le digo al scanner que
                lea el dato como un string, con lector.nextLine*/
        System.out.println("Genial, ahora veamos su longitud, si es menor que 4, saldrá en Mayus, sino en minus:");
        System.out.println("----------------------------------:");
        int longitudpalabra = palabra.length();
            /*Ahora creo un int para que me cuente la longitud de palabra
            con el metodo length()*/
        if (longitudpalabra < 4) {
            System.out.println(palabra.toUpperCase());
        } else {
            System.out.print(palabra.toLowerCase());
        }

        lector.close(); // Cierra el Scanner al terminar.
    }
}
