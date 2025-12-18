package UF02Programacion;
import java.util.Scanner;
// Importo que pueda utilizar scanner, ya que no es una clase fundamental.

public class EjerciciosAreas {
    // Se define una clase pública llamada 'EjercicioAreas'. En Java, todo el código debe estar dentro de una clase.
    public static void main(String[] args) {
        // Se define el método 'main', que es el punto de entrada del programa.
        // Es el primer método que se ejecuta cuando se inicia el programa.
        // 'String[] args' permite recibir argumentos desde la línea de comandos.
        System.out.println("Bienvenido al calculador de área y perímetro!!");
        System.out.println("Ahora tendrás que introducir la base y la altura de dos figuras para calcular los valores:");

        EjerciciosAreas procesos = new EjerciciosAreas();
              /*Para llamar a los métodos que quiera crear, antes, necesito tener un objeto de la clase,
                para ello, se crea con el nombre de la clase y la palabra new, asociado a una variable
                en este caso, procesos, es similar a cuando usamos el scanner*/
        procesos.leerDatos();
        //Aquí, le pasamos a ese objeto, la función leerDatos, que hemos creado abajo//
        //Este paso se podria evitar si ya tengo el siguiente????????? SI, SE DEBE BORRAR//
        int[] datos = procesos.leerDatos();
                /*Como leerDatos devuelve un array de int,
                me interesa crear una variable que recoja esos datos y poder utilizarla, la llamo, datos*/
        procesos.calcularArea(datos);
                /*Ahora si, utilizo esa variable datos, que son los recogidos anteriormente
                y se la paso al objeto de clase con la función calcularArea como parámetros */
        //Este paso se podria evitar si ya tengo el siguiente????????? SI, SE DEBE BORRAR//
        double area = procesos.calcularArea(datos);
        // y lo mismo, creo una variable que recoja los datos de área, por si la necesito
        procesos.mostrarResultado("área", area);
                /* Aquí, le vuelvo a pasar al objeto, la funcion mostrarResultado
                con área como el String que me pide el método y area(el double de la variable anterior),
                 como el double que me pide el método */
        double perimetro = procesos.calcularPerímetro(datos);
            /* directamente creo la variable perimetro, pasandole al objeto la funcion
            CalcularPerímetro con los datos de inicio como parámetro*/
        procesos.mostrarResultado("perímetro", perimetro);
                /* Aquí, le vuelvo a pasar al objeto, la funcion mostrarResultado
                con perímetro como el String que me pide el método y perímetro(el double de la variable perímetro),
                 como el double que me pide el método */
    }
    public static int[] leerDatos(){
        // Se define un método público llamado 'leerDatos' que devuelve un array de enteros (int[]).
        // Este método no recibe parámetros.

        Scanner scanner = new Scanner(System.in);
        // Se crea un objeto 'Scanner' para leer datos desde la entrada estándar (normalmente el teclado).
        System.out.println("Por favor introduce la base");
        // Se solicita al usuario que introduzca un valor para la base.
        int base = scanner.nextInt();
        // Se lee el valor introducido por el usuario y se guarda en la variable 'base'.
        System.out.println("Por favor introduce la altura");
        // Se solicita al usuario que introduzca un valor para la altura.
        int altura = scanner.nextInt();
        // Se lee el valor introducido por el usuario y se guarda en la variable 'altura'.

        return new int[]{base, altura};
            /* Se devuelve un array de enteros que contiene los valores de 'base' y 'altura'.
            El new en la línea return new,
            se utiliza porque estás creando una nueva instancia de un array de enteros en ese mismo momento*/

    }
    public double calcularArea(int[] datosPasados){
            /*Creo un nuevo método calcularArea, al que le paso como parámetro
            int[], para que podamos utilizar los datos que he recogido con el scanner,
            con nombre datosPasados, ojo, este nombre es temporal, solo se usa para declarar el método*/
        double area = datosPasados[0] * datosPasados[1];
            /*en este caso, se declara una variable area, que multiplique los datos recogios en el array
            la posicion 0 y la posicion 1 */
        return area;
    }
    public void mostrarResultado(String calculo, double area){
        System.out.printf("EL %s calculada es de %.2f%n",calculo,area);
        /*Aquí creo el método para que muestre los resultados, le paso como parametros:
        String que le llamo calculo y un double que le llamo area */
    }
    public double calcularPerímetro(int[] datosPasados){
            /*Creo un nuevo método calcularPerímetro, al que le paso como parámetro
            int[], para que podamos utilizar los datos que he recogido con el scanner,
            con nombre datosPasados, ojo, este nombre es temporal, solo se usa para declarar el método*/
        double perimetro = 2*datosPasados[0] + 2*datosPasados[1];
            /*en este caso, se declara una variable perímetro, que realice la formula con los datos recogidos
             en el array, en la posicion 0 y la posicion 1 */
        return perimetro;
    }


}


