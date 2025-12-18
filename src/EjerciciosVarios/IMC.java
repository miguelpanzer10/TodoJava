package EjerciciosVarios;
import java.util.Scanner;
// Importo que pueda utilizar scanner, ya que no es una clase fundamental.
public class IMC {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        /*Aquí, creo un Scanner(le llamo lector) y decirle de dónde va a leer los datos.
        Lo más común es leer desde la entrada estándar del sistema, que es la consola/teclado, usando System.in*/
        String salida;
        /*Declaro la variable que usaré en el bucle para salir, si la declaro dentro,
         el bucle con do-while no sirve porque una vez que acaba ese bucle, ya no tiene la variable*/
        do { //Creo un bucle con do-while//
            System.out.println("Bienvenido al calculador de tu IMC:");
            System.out.println("--------------------------------------------------------");
            System.out.println("Primero, ingresa tu peso en kg por favor y pulsa enter:");
            double peso = lector.nextDouble();
                /* aquí, creo la variable decimal peso y le digo al scanner que
                lea el dato como un número decimal, con lector.nextDouble*/
            System.out.println("Genial, ahora ingresa tu altura en m por favor y pulsa enter:");
            double altura = lector.nextDouble();
            //Lo mismo que antes pero con altura//
            double altura2 = altura * altura;
            //Aquí creo la variable altura2 que me va a dar la altura elevada al cuadrado//
            double imc = peso / altura2;
            //Aquí creo el imc, que es la división entre el peso introducido y la altura2//
            String imcFormateado = String.format("%.1f",imc);
            /* Aquí creo el imc formateado diciéndole que solo me coja 1 decimal, porque sino me salen muchísimos:
            %: Empieza el especificador de formato.
            .1: Indica que se debe redondear y mostrar el número con un solo decimal.
            f: Indica que el argumento que se va a formatear es un número de punto flotante (double o float).
            imc es el argumento que quieres que se inserte en la cadena formateado según la regla anterior.
            */

            //Pasamos a las opciones//

            if (imc < 18.5) {
                System.out.println("Tu IMC es " + imcFormateado + ". Eso indica que es muy bajo. Toca ponerse a sacar músculo");
                //Aquí sólo me imprime si es menor que 18,5//
            } else if (imc <= 25) {
                System.out.println("Tu IMC es "+imcFormateado+". Por lo que es bajo, estás casi en lo normativo, un poco más de fuerza y perfecto");
            }
        /*Aquí sólo llega si ya es mayor de 18.5, sino, imprime la anterior,
         entonces sólo necesito decirle que sea menor o igual de 25*/
            else if (imc <= 30) {
                System.out.println("Tu IMC es "+ imcFormateado+ ". Es un IMC normal, sigue así");
            }
        /*Aquí sólo llega si ya es mayor de 25, sino, imprime la anterior,
        entonces sólo necesito decirle que sea menor o igual de 30*/
            else {
                System.out.println("Tu IMC es "+imcFormateado+". Es un IMC alto, hay que cuidar la alimentación y meter más ejercicio");
            }
            System.out.println("--------------------------------------------------------");
            System.out.println("Pulsa 'EXIT' para salir o cualquier otra tecla para calcular otro IMC:");

            lector.nextLine();
            /* Esto es necesario porque cuando combino scanner de números
            y letras, cuando ingresa el número y da enter el carácter
            de "nueva línea" (\n) se queda atascado en la memoria del Scanner (el buffer).
            Entonces cuando ingreso texto con nextLine() lee inmediatamente ese \n pendiente,
            lo consume (lo quita del buffer) y no le da tiempo al usuario a ingresar "EXIT"*/
            salida = lector.nextLine();
            //le digo al scanner que la variable salida que declare fuera del bucle, la recoja como texto//
        } while (!salida.equalsIgnoreCase("EXIT"));
        /* Aquí, le estoy diciendo con equal que compare si la opcion de salida es igual a exit
         y on IgnoreCase que no tenga en cuenta si está en mayus o minus*/

        /* Con el ! invierte/niega el resultado, es decir, el bucle se repite si ingresa exit(porque es true)
        pero con el !, hago que se pare si ingresa exit(porque es false)
         */
        System.out.println("Programa finalizado. ¡Gracias por usar el calculador de IMC!");
        lector.close(); // Cierra el Scanner al terminar.

    }
}
