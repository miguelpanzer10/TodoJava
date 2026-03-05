package InterfazGrafica;
import javax.swing.*;
import java.awt.*;

public class MiPrimeraVentana {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Mi Ventana");

        //Configuracion tamaño(ancho x alto en pixeles)
        ventana.setSize(500, 500);
        //Centrar en pantalla
        ventana.setLocationRelativeTo(null);
        //cerrar la app al pulsar la x
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Hacer visible
        ventana.setVisible(true);
    }
}
