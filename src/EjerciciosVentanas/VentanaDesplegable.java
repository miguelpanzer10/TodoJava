package EjerciciosVentanas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 1. Añadimos ActionListener a la declaración de la clase
public class VentanaDesplegable extends JFrame implements ItemListener, ActionListener {
    private JComboBox<String> desplegable;
    private JButton boton;

    public VentanaDesplegable() {
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 50, 700, 500);

        iniciarComponentes();
    }

    private void iniciarComponentes() {
        desplegable = new JComboBox<String>();
        desplegable.setBounds(10, 10, 100, 25);
        desplegable.addItem("Argentina");
        desplegable.addItem("Brasil");
        desplegable.addItem("Colombia");
        add(desplegable);
        desplegable.addItemListener(this);

        boton = new JButton("Elegir");
        boton.setBackground(Color.decode("#FFACBC"));
        boton.setForeground(Color.black);
        boton.setBounds(250, 220, 100, 30);
        add(boton);

        // El botón ahora sí enviará el evento al método actionPerformed
        boton.addActionListener(this);
    }

    // Este método se ejecuta cada vez que cambias la opción en el menú (sin hacer clic en el botón)
    public void itemStateChanged(ItemEvent e) {
        String seleccion = (String) desplegable.getSelectedItem();
        setTitle("Seleccionado: " + seleccion);
    }

    // 2. Aquí es donde el botón "recoge" la selección al hacer clic
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton) {
            //Aunque uso el this, es buena practica decir que es cuando usa el boton
            //Por si añado un nuevo boton o algo
            String seleccion = (String) desplegable.getSelectedItem();

            // Ejemplo: Mostrar un mensaje con la selección recogida
            JOptionPane.showMessageDialog(null, "Has pulsado el botón y el color es: " + seleccion);

            // También puedes cambiar el color del botón según la selección
            if(seleccion.equals("Colombia")) boton.setBackground(Color.YELLOW);
            if(seleccion.equals("Brasil")) boton.setBackground(Color.GREEN);
            if(seleccion.equals("Argentina")) boton.setBackground(Color.BLUE);
        }
    }

    public static void main(String[] args) {
        new VentanaDesplegable().setVisible(true);
    }
}