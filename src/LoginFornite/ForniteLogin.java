package LoginFornite;

import java.util.Scanner;

public class ForniteLogin {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creamos un array para guardar hasta 10 jugadores (de momento)
        Jugador[] listaJugadores = new Jugador[10];

        // Se inician los jugadores predeterminados(les doy atributos antes de iniciar el programa)
        listaJugadores[0] = new Jugador("KingMiky96", "Inves123", 3);
        listaJugadores[1] = new Jugador("TeacherMario", "pruebaclave", 5);

        // Llevamos la cuenta de cuántos jugadores reales hay en el array(no quiere decir que estén conectados)
        //me sirve para ir aumentandolo cada objeto
        int cantidadJugadores = 2;

        boolean bucle = true;
        //creo esta variable para poder ver si funciona los jugadores conectados y crear el bucle [cite: 39]

        while (bucle) {
            System.out.println(" BIENVENIDO A FORNITE ");
            System.out.println("---------------------------------------------------------------");
            //se muestran los jugadores conectados usando static
            System.out.println("Jugadores conectados en la plataforma: " + Jugador.getJugadoresConectados());
            System.out.println("---------------------------------------------------------------");
            System.out.println("1. Registrar nuevo jugador");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir");
            System.out.println("4. Ver usuarios registrados");//mi prueba para ver si funciona el array
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine(); // Limpia el "Enter" que dejó nextInt() para que no de errores luego el buffer

            if (opcion==1) {
                //Proceso de registro (Crea el objeto Jugador con los datos que mete el usuario)
                if (cantidadJugadores < listaJugadores.length) {
                    System.out.print("Elige tu Gamertag: ");
                    String nuevoNombre = sc.nextLine();
                    System.out.print("Crea tu contraseña: ");
                    String nuevaClave = sc.nextLine();

                    // Creamos el nuevo objeto con los datos del usuario e incrementamos el contador de cantidad de jugadores
                    //asi, meto el nuevo objeto en la posicion siguiente del array, en este caso, la 3
                    listaJugadores[cantidadJugadores] = new Jugador(nuevoNombre, nuevaClave, 0);
                    cantidadJugadores++;

                    System.out.println("¡Registro con éxito! Ahora puedes iniciar sesión.");
                } else {
                    System.out.println("Servidor lleno. No se pueden registrar más jugadores.");
                }

            } else if (opcion==2) {
                //Login
                System.out.println("Inicio de sesión");
                System.out.println("Introduce tu Gamertag: ");
                String nombreBusqueda = sc.nextLine();
                System.out.println("Introduce tu contraseña: ");
                String claveBusqueda = sc.nextLine();

                //: Buscar al jugador y ver si existe(de momento no le asigna nada hasta que comprueba en el for)
                //solo guarda un espacio en Jugador
                Jugador jugadorEncontrado = null;

                // Buscamos en el array si el nombre coincide con alguno de la lista de jugadores registrados
                for (int i = 0; i < cantidadJugadores; i++) {
                    //para cada jugador del array, comprueba su nombra y si es igual al introducido
                    //ahora si se lo asocia a jugadorEncontrado
                    if (listaJugadores[i].getGamertag().equals(nombreBusqueda)) {
                        jugadorEncontrado = listaJugadores[i];
                        break; // Lo encontramos, salimos del for
                    }
                }

                // Mostrar resultado
                if (jugadorEncontrado != null) {
                    // Si el jugador existe, intentamos iniciar sesión
                    // Al haber dicho que jugadorEncontrado = listaJugadores[i], puedo usar sus métodos de objeto
                    boolean exito = jugadorEncontrado.iniciarSesion(claveBusqueda);

                    if (exito) {
                        System.out.println("¡Bienvenido de vuelta, " + jugadorEncontrado.getGamertag() + "!");
                        System.out.println("Victory Royales: " + jugadorEncontrado.getVictoriasTotales());
                        System.out.println("¡Buena suerte en el Battle Royale!");
                    } else {
                        System.out.println("Acceso denegado: Contraseña incorrecta.");
                    }
                } else {
                    System.out.println("Error: El usuario no existe.");
                }

            } else if (opcion==3) {
                bucle = false;
                System.out.println("Saliendo...");
            }
            else if (opcion == 4) {
                //Muestro el array para comprobar
                System.out.println("Jugadores registrados");
                System.out.println("-------------------------");

                for (int i = 0; i < cantidadJugadores; i++) {
                    // Accedemos a cada jugador del array uno por uno y los muestro
                    System.out.println("Jugador " + (i + 1) + ": " + listaJugadores[i].getGamertag() +
                            " | Victorias: " + listaJugadores[i].getVictoriasTotales());
                }
                System.out.println("----------------------------------------------");
            }

            //ver el error de compilación que pide el ejercicio (Paso 6)
            // System.out.println(listaJugadores[0].contrasena);
        }
        sc.close();
    }
}