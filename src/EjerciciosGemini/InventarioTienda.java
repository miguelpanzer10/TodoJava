package EjerciciosGemini;

/* * GESTOR DE TIENDA: Pide precios (double) hasta introducir un número negativo.
 * Suma el total, cuenta los productos y detecta(manda un aviso de lujo) si alguno supera los 100€.
 * Al finalizar, calcula y muestra el gasto total, la cantidad de productos
 * y el precio medio de la compra.
 */
import java.util.Scanner;

public class InventarioTienda {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        int contador = 0;
        System.out.println("Bienvenido al carrito de la tienda");
        double precio;
        double total = 0;

        do {
            System.out.println("Introduce el precio (o un número negativo para salir):");
            precio = lector.nextDouble();

            if (precio >= 0) { // Solo operamos si es un precio válido
                total += precio;
                contador++;

                if (precio > 100) {
                    System.out.println("¡Producto de lujo detectado!");
                }
            }
        } while (precio >= 0);

        // Validación para evitar dividir por cero
        if (contador > 0) {
            double media = total / contador;
            System.out.println("Total de gasto: " + total + "€");
            System.out.println("Media de gasto: " + media + "€");
            System.out.println("Productos comprados: " + contador);
        } else {
            System.out.println("No se han registrado productos.");
        }


    }
}



