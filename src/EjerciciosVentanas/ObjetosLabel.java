package EjerciciosVentanas;
import javax.swing.*;


public class ObjetosLabel  extends JFrame {
    private JLabel rojo,verde,azul;
    //declaro variables de clase privadas para luego crear el objeto con ellas

    //Creo el constructor
    public ObjetosLabel() {
        setLayout(null);
        // Desactiva el layout para usar coordenadas absolutas con setBounds
        setResizable(false);//no le deja modificar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //finaliza completamente la aplicación Java
        CreacionLabel();
        //Llamo al método para no sobresaturar el constructor
        setBounds(0, 0, 500, 300);
        // Posiciona la ventana en x=0, y=0 con ancho=500 y alto=300 píxeles
    }

    public void CreacionLabel(){
      verde=new JLabel("verde");
      verde.setBounds(50,50,200,50);
      add(verde);

      rojo=new JLabel("rojo");
      rojo.setBounds(50,100,200,50);
      add(rojo);

      azul=new JLabel("azul");
      azul.setBounds(50,150,200,50);
      add(azul);
      //creo los objetos y los pongo uno encima de otro
    }

    public static void main(String[] args) {
        ObjetosLabel objeto=new ObjetosLabel();
        objeto.setVisible(true);
    }

}
