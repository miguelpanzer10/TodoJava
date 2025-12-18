package UF02Programacion;

public class Termometro {
    private double temperaturaCelsius; // Valor interno del Termómetro

    public void setTemperaturaCelsius(double Cels) {
        if (Cels < -273.15) {
            // Si es menor que el Cero Absoluto, establece el límite.
            this.temperaturaCelsius = -273.15;
        } else {
            // Si es válido, establece el valor.
            this.temperaturaCelsius = Cels;
        }
    }
    // Método para convertir la temperatura interna a Fahrenheit.
    public double convertirAFahrenheit() {
        // La fórmula de conversión es: F = C * 9/5 + 32
        return temperaturaCelsius * 9 / 5 + 32;
    }

    // Método getter para obtener el valor actual en Celsius
    public double getTemperaturaCelsius() {

        return this.temperaturaCelsius;
    }
}