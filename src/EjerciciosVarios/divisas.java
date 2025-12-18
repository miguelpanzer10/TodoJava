package EjerciciosVarios;

import java.util.Scanner;
// Importo que pueda utilizar scanner, ya que no es una clase fundamental.
public class divisas {
    public void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        /*Aquí, creo un Scanner(le llamo lector) y decirle de dónde va a leer los datos.
        Lo más común es leer desde la entrada estándar del sistema, que es la consola/teclado, usando System*/

        System.out.println("Bienvenido a la aplicación de conversión de divisas:");
        System.out.println("--------------------------------------------------------");
        System.out.println("Primero, ingresa una cantidad, en €:");
        double cantidad = lector.nextDouble();
                /* aquí, creo la variable decimal cantidad y le digo al scanner que
                lea el dato como un número decimal, con lector.nextDouble*/
        System.out.println("Genial, ahora veamos las opciones:");
        System.out.println("----------------------------------:");
        System.out.println("Vamos a ver ahora las opciones a lo que quieres convertirlo:");
        System.out.println("1.Convertir a Dolares:");
        System.out.println("2.Convertir a Yenes:");
        System.out.println("3.Convertir a Libras:");
        System.out.println("Seleciona el número de la opción que quieras:");
        System.out.println("---------------------------------------------------------------------------");
        int opciones = lector.nextInt();
        //Lo mismo que antes pero con entero(double no admite el switch) con opciones, para ver que opción quiere//
        switch(opciones){
            /*creo los primeros casos implemente multiplicando la cantidad inicial
            para hacer la conversión*/
            //En todos les pongo el break para que pare y no siga
            case 1:
                double dolares= cantidad*1.14;
                System.out.printf("%.2f€, son %.2f %s", cantidad, dolares, "dolares");
                //los meto con printf para formatear a 2 decimales solo
                // La plantilla de formato: "%.2f€, son %.2f %s\n"
                // - El primer %.2f es para la variable 'cantidad'.
                // - El segundo %.2f es para la variable 'dolares' (el resultado).
                // - El %s es para la unidad monetaria (el String "dolares").
                break;

            case 2:
                double yenes= cantidad*177.06;
                System.out.printf("%.2f€, son %.2f %s", cantidad, yenes, "yenes");
                break;

            case 3:
                double libras= cantidad*0.88;
                System.out.printf("%.2f€, son %.2f %s", cantidad, libras, "libras");
                break;

            default:
                System.out.print("Opción no válida");
        }
        lector.close(); // Cierra el Scanner al terminar.
    }


}


