package InterfazGrafica;
import javax.swing.*;
// Para ventanas, botones, etc.(el borde)
import java.awt.*;
import java.awt.event.*;
// Import necesario para la acción de botones
// y necesario para el "escuchador"
//esto son para usar los efectos al pasar con el ratón



//con el extends, tu clase es una ventana.
// No necesitas crear un objeto JFrame
// sino que usas this o directamente los métodos de la ventana.
public class VentanaMasCompleta extends JFrame {
    // Declaramos las variables aquí arriba para que "toda la clase" las vea y tambien usarlas en el metodo de interacción
    //porque sino, como las demás las creo, en iniciarcomponentes(privado), no las tengo
    private JTextField userField;
    private JPasswordField passField;
    private JButton boton;

    public VentanaMasCompleta() {
        setTitle("Acceso al Sistema");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana
        setResizable(false); //asi evita que se vea grande, ya que es una pantalla pequeña

        iniciarComponentes(); // Este método lo creo más abajo para no sobrecargar el constructor
    }

    private void iniciarComponentes() {

        // Creamos unas fuentes para usarlas: Nombre, Estilo (Negrita/Plana), Tamaño
        Font fuenteEtiquetas = new Font("SansSerif", Font.BOLD, 14);
        Font fuenteCampos = new Font("Monospaced", Font.PLAIN, 12);
        // Las monoespaciadas van bien para escribir

        JPanel panel = new JPanel();
        // Cambia el color de fondo del panel
        panel.setBackground(Color.decode("#FFECF0"));


        panel.setLayout(new GridLayout(3, 2, 10, 10));
        // Quiero 3 filas y 2 columnas
        // (Fila 1: Usuario, Fila 2: Contraseña, Fila 3: Botón)
        // Los números (3, 2) significan (filas, columnas)
        //el 10, 10 es la separacion vertical y horizontal, para que no quede pegado
        panel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));//para que no quede tan feo
        add(panel); // Añadimos el panel a la ventana directamente

        JLabel userLabel = new JLabel("Usuario:");
        panel.add(userLabel);
        userLabel.setForeground(Color.decode("#A60020")); // Cambia el texto a blanco
        userLabel.setFont(fuenteEtiquetas);//Uso las fuentes hechas

        // usamos la variable de arriba y crear el objeto, el 15 quiere decir, que si pongo más de 15 caracteres, salte de linea
        userField = new JTextField(15);
        panel.add(userField); //Crea el cuadro donde el usuario escribirá.
        userField.setFont(fuenteCampos);//uso la fuente

        JLabel passLabel = new JLabel("Contraseña:");
        panel.add(passLabel);
        passLabel.setForeground(Color.decode("#A60020")); // Cambia el texto a blanco
        passLabel.setFont(fuenteEtiquetas); // Reutilizamos la misma fuente

        //usamos la variable de arriba para crear el objeto
        passField = new JPasswordField(15);
        panel.add(passField);//igual que TextField pero sin que se vea y se sustituye por asteriscos

        // Usamos la variable de arriba
        boton = new JButton("Iniciar sesión");
        panel.add(boton);
        boton.setBackground(Color.decode("#FFACBC")); // Cambia el color del fondo del botón
        boton.setForeground(Color.white); // Cambia el color de la letra a blanco
        boton.setFont(fuenteEtiquetas);

        // Creamos el efecto de "iluminación" al pasar el ratón
        boton.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                // Color cuando el ratón está ENCIMA (un poco más oscuro que el original)
                boton.setBackground(Color.decode("#FF8DA1"));
            }


            public void mouseExited(MouseEvent e) {
                // Volvemos al color ORIGINAL cuando el ratón se va
                boton.setBackground(Color.decode("#FFACBC"));
            }
        });


        // logica del botón
        boton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String usuario = userField.getText();
                String password = new String(passField.getPassword());

                if (usuario.equals("KingMiky") && password.equals("Inves123")) {
                    JOptionPane.showMessageDialog(null, "¡Bienvenido, " + usuario + "!");
                } else {
                    //Limpio los campos
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                    //sólo se limpian los datos si el usuario falla
                    userField.setText("");// Borra el texto del usuario
                    passField.setText("");// Borra los puntos de la contraseña
                    userField.requestFocus();// Pone el cursor de nuevo en el cuadro de usuario
                }
                //Este método tengo que llamarlo siempre así, porque
                //Es una interfaz, ActionListener es una interfaz que solo tiene un método.
                // Al implementarla, el compilador busca específicamente public void actionPerformed(ActionEvent e)

                //Al poner null, el aviso simplemente aparece en el centro de la pantalla.
                //JOptionPane.ERROR_MESSAGE	Define el icono visual. En este caso, Java pondrá automáticamente un círculo rojo con una "X".
            }
        });
    }

    public static void main(String[] args) {
        new VentanaMasCompleta().setVisible(true);
    }
}