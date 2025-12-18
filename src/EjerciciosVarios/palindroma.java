package EjerciciosVarios;
public class palindroma {

    public static void main(String[] args) {
        String fraseOriginal = "Yo hago yoga hoy";

        // 1. Limpiar la frase: Quitar espacios y convertir a minúsculas
        String fraseLimpia = limpiarFrase(fraseOriginal);

        // 2. Comprobar si es un palíndromo
        boolean esPalindromo = esPalindromo(fraseLimpia);
            /*Crea una nueva variable llamada esPalindromo que solo puede guardar valores true o false."
             =    Asignación: Le dice a Java: "Guarda el resultado de lo que está a la derecha en la variable de la izquierda."
            esPalindromo(fraseLimpia)
             Llamada al Método: "Ejecuta el método con el argumento fraseLimpia:
             " Este método devuelve (return) el valor true o false después de hacer la comprobación.*/


        // 3. Imprimir el resultado
        System.out.println("Frase original: \"" + fraseOriginal + "\"");
        System.out.println("Frase limpia: \"" + fraseLimpia + "\"");

        if (esPalindromo) {
            System.out.println("Resultado: ¡La frase es un palíndromo! ✅");
        } else {
            System.out.println("Resultado: La frase NO es un palíndromo. ❌");
        }
    }

    /**
     * Prepara la cadena eliminando espacios y convirtiendo a minúsculas.
     */
    public static String limpiarFrase(String cadena) {
            /* .replaceAll("\\s", "") elimina todos los espacios en blanco:
            Busca cada lugar donde haya un espacio("\\s")
            Reemplaza ese espacio con nada (la cadena vacía "").*/
        return cadena.toLowerCase().replaceAll("\\s", "");
        //toLowerCase devuelve la frase a minúsculas
    }

    /**
     * Verifica si una cadena (ya limpia) es un palíndromo invirtiéndola.
     */
    public static boolean esPalindromo(String cadenaLimpia) {
        //Es boolean para que me diga sólo si es tru o false
        // Crea un StringBuilder con la cadena limpia
        StringBuilder sbuildercadena = new StringBuilder(cadenaLimpia);
        //StringBuilder es una clase de Java diseñada para manipular (construir y modificar) cadenas de caracteres de manera eficiente.

            /*new: Es la palabra clave que le dice a Java: "Crea una nueva instancia de esta clase."
            sbuildercadena es el nombre que elijo para mi stringbuilder

            StringBuilder(...): Es la llamada al constructor de la clase StringBuilder.

            (cadenaLimpia): Es el argumento (el dato) que le pasamos al constructor.
            "Cuando alguien me llame, debe darme una cadena de texto, y yo la llamaré temporalmente cadenaLimpia dentro de mi código."
            Cuando se ejecuta esPalindromo(fraseLimpia) en el main, el valor de la variable fraseLimpia (que es "yohagoyogahoy")
            se copia y se asigna a la variable cadenaLimpia dentro del método esPalindromo*/

        // Invierte el StringBuilder y lo convierte de nuevo a String
        String cadenaInvertida = sbuildercadena.reverse().toString();
            /*  .reverse(): Invierte el contenido del StringBuilder.
            .toString(): Convierte el resultado invertido de nuevo a String.*/

        // Compara si la cadena limpia es igual a la cadena invertida
        return cadenaLimpia.equals(cadenaInvertida);
    }

}

