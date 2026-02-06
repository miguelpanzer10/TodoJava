package BatallaPokemon;

public class Pokemon {
    // Variables que tendrá cada Pokémon, las meto protected porque al usar un paquete,
    //lo puedo utilizar desde las clases y metodos de dentro y no las modifica quien quiera
    protected String nombre;
    protected String tipo;
    protected int nivel;
    protected int vidaActual;
    protected int ataque;
    protected int defensa;
    protected int velocidad;
    protected String estado; //variable para guardar si está envenenado, quemado, etc.

    // Constructor: Se llama igual que la clase, lo creo para poder usar objetos de esta clase.
    // Inicia los atributos del objeto cuando hago un new.
    //Si no hiciese un constructor, Java crea uno por defecto y le asigna valroes null, 0, false...
    //Entonces luego al llamar a esta clase Pokemon, no me daría lo que yo quiero
    //El constructor me coge los datos que yo asigno en el Main: Charmander, fuego, 12...
    //y con this, los asigna a las variables de esta clase
    public Pokemon(String nombre, String tipo, int nivel, int vida, int ataque, int defensa, int velocidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.vidaActual = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.estado = "ninguno"; // Por defecto, al crearse no tienen ningún estado
    }
}
