package UF02Programacion;

// Rectangulo hereda de Figura
public class Rectangulo extends Figura {

    // Constructor de Rectangulo:
    // Debe llamar al constructor de la superclase Figura usando 'super()'
    public Rectangulo(double base, double altura) {
        // Llama al constructor de Figura(base, altura) para inicializar
        // las propiedades base y altura heredadas.
        super(base, altura);
    }

    // Método para calcular el área
    // Accede directamente a las propiedades 'base' y 'altura' heredadas
    public double Area() {
        return base * altura;
    }
}