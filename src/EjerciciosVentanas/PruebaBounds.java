package EjerciciosVentanas;
import javax.swing.*;

public class PruebaBounds extends JFrame {
    //Creo el constructor para luego crear el objeto
    public PruebaBounds() {
        setLayout(null);
        // Desactiva el layout para usar coordenadas absolutas con setBounds
        setResizable(false);//no le deja modificar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //finaliza completamente la aplicación Java
        setBounds(0, 0, 1024, 800);
        // Posiciona la ventana en x=0, y=0 con ancho=1024 y alto=800 píxeles
    }
    // Método principal: punto de entrada del programa, Java lo ejecuta primero
    public static void main(String[] ar) {
        PruebaBounds f = new PruebaBounds();
        // Crea un objeto ventana llamando al constructor
        f.setVisible(true);
        // Hace visible la ventana (sin esto no se muestra nada)

    }

}



