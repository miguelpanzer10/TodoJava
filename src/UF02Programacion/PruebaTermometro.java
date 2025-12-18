package UF02Programacion;

public class PruebaTermometro {
    public void main(String[] args){
        Termometro mitermometro= new Termometro();
        //mitermometro.temperaturaCelsius;
        mitermometro.setTemperaturaCelsius(-125);

        System.out.println("Tu temperatura en Celsius es: " + mitermometro.getTemperaturaCelsius());
        System.out.println("Tu temperatura en Faren es: " + mitermometro.convertirAFahrenheit());
        System.out.println("---------------------------------------");

        mitermometro.setTemperaturaCelsius(-300);

        System.out.println("Tu temperatura en Celsius es: " + mitermometro.getTemperaturaCelsius());
        System.out.println("Tu temperatura en Faren es: " + mitermometro.convertirAFahrenheit());

    }
}
