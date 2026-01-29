package EjerciciosVarios;
//pide una palabra y recorrela con un bucle carácter a carácter.
//La palabra es válida si:
//Contiene al menos una vocal
//No contiene espacios
//Usa booleanos como tieneVocal, tieneEspacio y decide al final
import java.util.Scanner;

public class PalabraValida {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Bienvenido a la aplicación de valicación de una palabra");
        System.out.println("--------------------------------------------------------");

        System.out.println("Ingresa la palabra que quieras validar:");
        String palabra = lector.nextLine();

        //Definimos los tres booleanos de control
        boolean longitudAceptada = false;
        boolean tieneVocal = false;
        boolean tieneEspacio = false;

        //Validamos la longitud primero
        int n = palabra.length();
        //creo la variable n y con el metodo length lo asocio al valor(int de palabra)
        if (n >= 6 && n <= 12) {
            longitudAceptada = true;
        }

        //Recorremos la palabra para las otras dos condiciones
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);

            // Check espacio
            if (letra == ' ') {
                tieneEspacio = true;
            }

            // Check vocales (incluyendo tildes y diéresis)
            char min = Character.toLowerCase(letra);
            //creo la variable min y uso el metodo para pasar el caracter a minus
            if (min == 'a' || min == 'e' || min == 'i' || min == 'o' || min == 'u' ||
                    min == 'á' || min == 'é' || min == 'í' || min == 'ó' || min == 'ú' ||
                    min == 'ü') {
                tieneVocal = true;
            }
        }
        //String (Objeto): Tiene métodos internos. Por eso haces palabra.toUpperCase().
        //
        //char (Primitivo): Es solo una letra "tonta" (un bit de información).
        // No tiene métodos. Por eso necesitas la máquina externa Character.toLowerCase(letra).

        //Decisión final
        System.out.println("--------------------------------------------------------");

        // Para ser válida: Longitud OK Y tiene Vocal Y NO tiene Espacio
        if (longitudAceptada && tieneVocal && !tieneEspacio) {
            System.out.println("¡ENHORABUENA! La palabra '" + palabra + "' es totalmente válida.");
        } else {
            System.out.println("LA PALABRA ES INVÁLIDA POR LOS SIGUIENTES MOTIVOS:");
            System.out.println("----------------------------------------------------");

            if (!longitudAceptada) {
                System.out.println("- Error de longitud: Tiene " + n + " caracteres (debe tener entre 6 y 12).");
            }
            if (!tieneVocal) {
                System.out.println("- Error de contenido: No tiene ninguna vocal.");
            }
            if (tieneEspacio) {
                System.out.println("- Error de formato: Contiene espacios en blanco.");
            }
        }
        lector.close();
    }

}

//Explicacion ChartAt
//Imagina que la palabra es un tren donde cada vagón es una letra. El bucle for empezará en el vagón 0 y terminará en el último vagón (longitud - 1).
//
//palabra.charAt(i): Extrae la letra en la posición i.
//
//tieneVocal: Si en algún momento una letra es 'a', 'e', 'i', 'o' o 'u', este booleano se vuelve true y se queda así.
//
//tieneEspacio: Si encuentra un ' ', este booleano se vuelve true.
