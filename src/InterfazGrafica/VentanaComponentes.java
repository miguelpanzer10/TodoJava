package InterfazGrafica;

import javax.swing.*;
import java.awt.*;

public class VentanaComponentes extends JFrame {
    public VentanaComponentes() {
        //esto es el constructor, ya que heredo la clase JFrame
        //y asi uso sus metodos directamente

        setTitle("Componentes básicos");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        JPanel panel = new JPanel();
        //creamos el panel
        JLabel etiqueta = new JLabel("Escribe tu nombre:");
        JTextField campo= new JTextField(15);
        JButton boton = new JButton("Crear componente");

        //JLabel muestra un texto o imagen no interactivo
        //JButton es un botón que ejecuta una acción al pulsarlo
        //JTextField permite al usuario introducir o editar una sola línea de texto
        //El 15 establece el ancho visual aproximado del campo (número de columnas)


        panel.add(etiqueta);
        panel.add(campo);
        panel.add(boton);

        add(panel);//añadir el panel a la ventana
    }

    public static void main(String[] args) {
        VentanaComponentes ventana = new VentanaComponentes();
        ventana.setVisible(true);


    }

}
