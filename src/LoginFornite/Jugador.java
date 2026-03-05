package LoginFornite;

public class Jugador {

    // Gamertag: visible para todos en el juego
    public String gamertag;

    // Contraseña: nadie debe acceder a ella desde fuera
    private String contrasena;

    // Victorias: cada jugador tiene las suyas, visibles en su perfil
    public int victoriasTotales;

    // Total de jugadores: es el mismo dato para toda la plataforma
    // (Pista: necesita DOS palabras clave)
    public static int jugadoresConectados = 0;

    // --- CONSTRUCTOR ---
    // Se ejecuta al crear un nuevo jugador con: new Jugador(...)
    public Jugador(String gamertag, String contrasena, int victoriasTotales) {

        this.gamertag = gamertag;
        this.contrasena = contrasena;
        this.victoriasTotales = victoriasTotales;
    }


    // --- MÉTODO: iniciar sesión ---
    // Recibe una contraseña y comprueba si es correcta
    // Debe poder llamarse desde otras clases
    public boolean iniciarSesion(String passIntroducida) {
        boolean pass=false;
            if(passIntroducida.equals(contrasena)) {
                System.out.println("Iniciando Sesion");
                pass=true;
                jugadoresConectados++;
                //lo meto asi aumentan los jugadores cada login correcto
            }
            else{
                System.out.println("Contraseña incorrecta");
                pass=false;
            }
            return pass;
    }
    // --- MÉTODO: obtener el total de jugadores ---
    // Este método debe poder llamarse SIN crear un objeto
    // Ejemplo: Jugador.getJugadoresConectados()
    // (Pista: necesita DOS palabras clave)
    public static int getJugadoresConectados() {
        return jugadoresConectados;

    }
    // --- MÉTODO: obtener el gamertag ---
    // Cualquier parte del programa puede necesitar el nombre
    public String getGamertag() {
        return gamertag;}

    // --- MÉTODO: obtener las victorias ---
    public int getVictoriasTotales() {
        return victoriasTotales;
    }
    // --- MÉTODO: registrar una victoria ---
    // Se llama cuando un jugador gana una partida
    public void registrarVictoria() {}


}

