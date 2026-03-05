package EjerciciosVentanas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormularioCompleto extends JFrame implements ItemListener,ActionListener{

    private JComboBox<String> desplegable;
    private JButton boton;
    private JTextField nombre, apellido; // Atributos de clase
    private JScrollPane scroll;
    private JRadioButton presencial, online;
    private ButtonGroup grupoModalidad;
    //Tengo que crear el buttongroup porque sino podria elegir los dos
    private JCheckBox ingles, espanol, frances;

    ImageIcon img = new ImageIcon("form.png");
    //meto una imagen para que sea el icono del from

    public FormularioCompleto(){
        setTitle("Ejercicio formulario completo");
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 50, 500, 600); // Ajustado el ancho y alto de la ventana
        setIconImage(img.getImage());
        //añado la imagen(que tiene que estar fuera del src)

        // Cambiamos el fondo de la ventana a un gris muy suave para un look profesional
        getContentPane().setBackground(Color.decode("#F2F4F7"));

        IniciarComponentes();
        //Llamo al método para no sobrecargar el constructor
    }

    private void IniciarComponentes(){
        // Nombre
        JLabel usuario = new JLabel("Nombre:");
        usuario.setForeground(Color.decode("#2D3436")); // Gris
        usuario.setFont(new Font("Arial", Font.BOLD, 16));
        usuario.setBounds(20, 20, 100, 30);
        add(usuario);

        nombre = new JTextField(); // Quitamos el "JTextField" delante para usar el atributo de clase
        nombre.setForeground(Color.BLACK);
        nombre.setFont(new Font("Arial", Font.PLAIN, 16));
        nombre.setBounds(130, 20, 300, 30);
        // Añadimos un borde sutil para que no se vea plano
        nombre.setBorder(BorderFactory.createLineBorder(Color.decode("#CED4DA")));
        add(nombre);

        //Apellidos
        JLabel apellidosLabel = new JLabel("Apellidos:");
        apellidosLabel.setForeground(Color.decode("#2D3436"));
        apellidosLabel.setFont(new Font("Arial", Font.BOLD, 16));
        apellidosLabel.setBounds(20, 70, 100, 30);
        add(apellidosLabel);

        apellido = new JTextField(); // Quitamos el "JTextField" delante
        apellido.setForeground(Color.BLACK);
        apellido.setFont(new Font("Arial", Font.PLAIN, 16));
        apellido.setBounds(130, 70, 300, 30);
        apellido.setBorder(BorderFactory.createLineBorder(Color.decode("#CED4DA")));
        add(apellido);

        //Curso
        JLabel cursoLabel = new JLabel("Curso:");
        cursoLabel.setForeground(Color.decode("#2D3436"));
        cursoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        cursoLabel.setBounds(20, 120, 100, 30);
        add(cursoLabel);

        desplegable = new JComboBox<String>();
        desplegable.setBounds(130, 120, 100, 30);
        desplegable.setBackground(Color.WHITE); // Fondo limpio para el combo
        desplegable.addItem("DAM");
        desplegable.addItem("ASMR");
        desplegable.addItem("DAW");
        add(desplegable);
        desplegable.addItemListener(this);

        //Modalidad
        JLabel modalidad = new JLabel("Modalidad:");
        modalidad.setForeground(Color.decode("#2D3436"));
        modalidad.setFont(new Font("Arial", Font.BOLD, 16));
        modalidad.setBounds(20, 170, 100, 30);
        add(modalidad);

        presencial = new JRadioButton("Presencial");
        presencial.setBounds(130, 170, 100, 30);
        presencial.setBackground(Color.decode("#F2F4F7"));
        // Mismo color que el fondo, sino, sale un recuadro de otro color
        presencial.setSelected(true); // Seleccionado por defecto
        add(presencial);

        online = new JRadioButton("Online");
        online.setBounds(240, 170, 100, 30);
        online.setBackground(Color.decode("#F2F4F7"));
        add(online);

        // Importante: Agruparlos para que solo se pueda elegir uno
        grupoModalidad = new ButtonGroup();
        grupoModalidad.add(presencial);
        grupoModalidad.add(online);

        //Idiomas
        JLabel idiomas = new JLabel("Idiomas:");
        idiomas.setForeground(Color.decode("#2D3436"));
        idiomas.setFont(new Font("Arial", Font.BOLD, 16));
        idiomas.setBounds(20, 220, 100, 30);
        add(idiomas);

        ingles = new JCheckBox("Inglés");
        ingles.setBounds(130, 220, 80, 30);
        ingles.setBackground(Color.decode("#F2F4F7"));
        add(ingles);

        espanol = new JCheckBox("Español");
        espanol.setBounds(210, 220, 90, 30);
        espanol.setBackground(Color.decode("#F2F4F7"));
        add(espanol);

        frances = new JCheckBox("Francés");
        frances.setBounds(300, 220, 90, 30);
        frances.setBackground(Color.decode("#F2F4F7"));
        add(frances);

        //Observaciones
        JLabel observaciones = new JLabel("Observaciones:");
        observaciones.setForeground(Color.decode("#2D3436"));
        observaciones.setFont(new Font("Arial", Font.BOLD, 16));
        observaciones.setBounds(20, 270, 150, 30);
        add(observaciones);

        JTextArea observacionesText = new JTextArea();
        scroll = new JScrollPane(observacionesText);
        scroll.setBounds(20, 310, 410, 120);
        scroll.setBorder(BorderFactory.createLineBorder(Color.decode("#CED4DA")));
        add(scroll);

        //Botón
        boton = new JButton("Inscribir");
        boton.setBackground(Color.BLACK); // negro
        boton.setForeground(Color.WHITE); // Texto blanco
        boton.setFocusPainted(false); // Quita el recuadro feo al hacer clic
        boton.setFont(new Font("Arial", Font.BOLD, 20));
        boton.setBounds(150, 460, 150, 45);
        add(boton);
        // El botón ahora sí enviará el evento al método actionPerformed
        boton.addActionListener(this);
    }

    // Este método se ejecuta cada vez que cambias la opción en el menú (sin hacer clic en el botón)
    //es decir, sirve para interactuar con informacion al momento
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == desplegable) {
            String seleccion = (String) desplegable.getSelectedItem();
            setTitle("Seleccionado: " + seleccion);
        }
    }

    //Al hacer clic en inscribirse
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton) {
            //Aunque uso el this, es buena practica decir que es cuando usa el boton
            //Por si añado un nuevo boton o algo
            String nombreelegido = nombre.getText();
            String apellidoselegidos = apellido.getText();

            //Mensaje por si los deja vacios
            if( nombreelegido.isEmpty()|| apellidoselegidos.isEmpty()){
                JOptionPane.showMessageDialog(null, "Nombre y Apellidos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String curso = (String) desplegable.getSelectedItem();

                // Determinamos modalidad
                String mod = "";
                if (presencial.isSelected()) {
                    mod = "Presencial";
                } else {
                    mod = "Online";
                }

                // Determinamos idiomas
                String listaIdiomas = "";
                if (ingles.isSelected()) listaIdiomas += "Inglés ";
                if (espanol.isSelected()) listaIdiomas += "Español ";
                if (frances.isSelected()) listaIdiomas += "Francés ";
                if (listaIdiomas.equals("")) listaIdiomas = "Sin idiomas";

                // Mensaje final
                JOptionPane.showMessageDialog(null, nombreelegido + " " + apellidoselegidos + " | " + curso + " | " + mod + " | " + listaIdiomas);
            }
        }
    }

    public static void main(String[] args) {
        FormularioCompleto form = new FormularioCompleto();
        form.setVisible(true);
    }
}