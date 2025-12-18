package UF02Programacion;

// Clase de prueba
public class PruebaFiguras {

    public static void main(String[] args) {
        // Creamos una instancia de Rectangulo, que automáticamente
        // llama al constructor de Figura para establecer base=10 y altura=6
        Rectangulo miRectangulo = new Rectangulo(10.0, 6.0);

        double area = miRectangulo.Area();

        System.out.println("--- Resultados ---");
        System.out.println("Base del rectángulo: " + miRectangulo.base);
        System.out.println("Altura del rectángulo: " + miRectangulo.altura);
        System.out.println("Su área calculada es: " + area);
    }
}
