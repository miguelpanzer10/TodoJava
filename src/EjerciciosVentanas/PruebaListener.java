package EjerciciosVentanas;
import javax.swing.*;
import java.awt.event.*;


public class PruebaListener extends JFrame implements ActionListener {


    private JButton varon, mujer;
    //creo las variables para crear los objetos abajo

    public PruebaListener() {

        setLayout(null);
        // Desactiva el layout para usar coordenadas absolutas con setBounds
        setResizable(false);//no le deja modificar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //finaliza completamente la aplicación Java

        setBounds(50,50, 500, 300);
        // Posiciona la ventana en x=0, y=0 con ancho=500 y alto=300 píxeles
        IniciarComponentes();
        //Llamo al métood para no sobrecargar el constructor
    }

    public void IniciarComponentes() {
        //creo este médtodo para no sobrecargar el constructor y crear los objetos con las variables de la clase
        varon = new JButton("Varon");
        varon.setBounds(10, 10, 100, 30);
        //LE DECIMOS AL BOTÓN QUIÉN DEBE ESCUCHARLO
        // "this" significa: "Busca el método actionPerformed en esta misma clase"
        varon.addActionListener(this);
        add(varon);



        mujer = new JButton("Mujer");
        mujer.setBounds(10, 40, 100, 30);
        mujer.addActionListener(this); // Aquí "this" sigue siendo la ventana PruebaListener
        add(mujer);

    }

    // Método obligatorio de ActionListener: se ejecuta automáticamente cada vez que se pulsa el botón
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == varon) {  // Comprueba si el evento lo generó boton1

            setTitle("varón");
            // Finaliza completamente la aplicación Java
        }

        if (e.getSource() == mujer) {
           setTitle("Mujer");
        }
    }

    static void main(String[] args) {
        PruebaListener pruebaListener = new PruebaListener();
        pruebaListener.setVisible(true);
    }


}
