package EjerciciosVentanas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaScroll extends JFrame implements ActionListener {
    private JTextArea texto1, texto2;
    private JButton boton;
    //creo las variables para luego usarlas
    private JScrollPane scroll;

    //declaro la variable scroll para usarla
    public VentanaScroll() {

        setLayout(null);
        // Desactiva el layout para usar coordenadas absolutas con setBounds
        setResizable(false);//no le deja modificar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //finaliza completamente la aplicación Java

        setBounds(250, 50, 700, 500);
        // Posiciona la ventana

        IniciarComponentes();
        //Llamo al método para no sobrecargar el constructor
    }

    public void IniciarComponentes() {

        JLabel primertexto = new JLabel("Texto 1:");
        primertexto.setBounds(10, 10, 100, 30);
        add(primertexto);

        texto1 = new JTextArea();
        scroll = new JScrollPane(texto1);
        scroll.setBounds(10, 60, 200, 130);
        add(scroll);

        JLabel segundotexto = new JLabel("Texto 2:");
        segundotexto.setBounds(400, 10, 100, 30);
        add(segundotexto);

        texto2 = new JTextArea();
        scroll = new JScrollPane(texto2);
        scroll.setBounds(400, 60, 200, 130);
        add(scroll);


        boton = new JButton("Comparar");       // Crea el botón con el texto "Comparar"
        boton.setBackground(Color.decode("#FFACBC")); // Cambia el color del fondo del botón
        boton.setForeground(Color.black); // Cambia el color de la letra a blanco
        boton.setBounds(250, 220, 100, 30);   // Lo posiciona
        add(boton);                         // Añade el botón a la ventana (sin esto no se ve
        boton.addActionListener(this);
        // Registra esta clase como oyente del botón (this = este mismo objeto)
        //Si no registraras el componente con addActionListener(this), al pulsar el botón el programa no sabría a dónde enviar la señal del clic.
        // Al usar this, vinculas el evento con la lógica que escribiste más abajo:

    }

    // Cuando el botón avisa a "this", se ejecuta este bloque de código.
    public void actionPerformed(ActionEvent e) {
        String primero = texto1.getText();
        String segundo = texto2.getText();
        if (primero.equals(segundo)) {
            JOptionPane.showMessageDialog(null, "¡Los textos son iguales!");
        } else {
            //Limpio los campos
            JOptionPane.showMessageDialog(null, "No coinciden los textos", "Error", JOptionPane.ERROR_MESSAGE);
            texto1.setText("");// Borra el texto del usuario
            texto2.setText("");// Borra el texto del usuario

        }
    }

    public static void main(String[] args) {
        VentanaScroll Pruebatextos = new VentanaScroll();
        Pruebatextos.setVisible(true);

    }
}
