package BatallaPokemon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Creo el objeto de la clase CombatePokemon para usar los metodos de combate
        CombatePokemon combate = new CombatePokemon();

        // Pokedex es el array donde tengo los objetos Pokemon, que los creo con new,
        // que llama al constructor de la clase Pokemon
        // (Nombre, Tipo, Nivel, Vida, Ataque, Defensa, Velocidad)
        //normalmente es int[] o String[], pero con Pokemon[], lo que hago es crear un array de objetos
        //Así puedo acceder a las propiedades de los objetos y usarlos como parámetros
        Pokemon[] pokedex = {
                new Pokemon("Charmander", "Fuego", 12, 110, 45, 35, 55),
                new Pokemon("Squirtle", "Agua", 12, 120, 40, 50, 43),
                new Pokemon("Bulbasaur", "Planta", 12, 115, 42, 45, 45),
                new Pokemon("Charizard", "Fuego", 50, 250, 90, 80, 100),
                new Pokemon("Blastoise", "Agua", 50, 260, 85, 110, 78),
                new Pokemon("Venusaur", "Planta", 50, 255, 88, 95, 80),
                new Pokemon("Golem", "Roca", 50, 270, 110, 130, 45),
                new Pokemon("Onix", "Roca", 20, 150, 45, 75, 25),
                new Pokemon("Pikachu", "Electrico", 12, 110, 45, 35, 55),
                new Pokemon("Raichu", "Electrico", 50, 250, 100, 75, 110)
        };

        System.out.println("Pokémon disponibles: Charmander(Nv12)🔥, Squirtle(Nv12)💧, Bulbasaur(Nv12)🌱, Charizard(Nv50)🔥, Blastoise(Nv50)💧, Venusaur(Nv50)🌱, Golem(Nv50)🪨, Onix(Nv20)🪨, Pikachu(Nv12) ⚡, Raichu(Nv50) ⚡");

        // 2. Selección por nombre
        System.out.println("Escribe el nombre de tu Pokémon: ");
        String nombreElegido = sc.nextLine();
        // Llamamos al buscador: le pasamos la pokedex y el texto, y nos devuelve el objeto p1
        Pokemon p1 = buscarPokemonPorNombre(pokedex, nombreElegido);

        System.out.println("Escribe el nombre del Pokémon rival: ");
        String nombreRival = sc.nextLine();
        // Hacemos lo mismo para el oponente p2
        Pokemon p2 = buscarPokemonPorNombre(pokedex, nombreRival);

        // Control de seguridad: Si el nombre no existe, el buscador devuelve "null" y el objeto es null
        if (p1 == null || p2 == null) {
            System.out.println("Error: Uno de los nombres no es correcto. Reinicia el juego.");
            return;
        }

        System.out.println("\n¡Combate Pokémon: " + p1.nombre + " (Nv" + p1.nivel + ") vs " + p2.nombre + " (Nv" + p2.nivel + ")!");
        System.out.println("--------------------------------------------------------------------------");


        try { Thread.sleep(1500); } catch (InterruptedException e) {}
        // Pausa antes de empezar el combate

        // Bucle del combate: se repite mientras ambos tengan vida mayor a 0
        while (p1.vidaActual > 0 && p2.vidaActual > 0) {
            // Determinamos orden por velocidad, lo meto en el bucle porque como
            //He metido que el paralizado reduzca la vel entre 2, igual durante el combate cambia la vel
            int turnoInicial = combate.determinarOrdenAtaque(p1.velocidad, p2.velocidad);
            if (turnoInicial == 1) {
                //si el turno inicial es 1, significa que el p1 es mas rapido y ataca el primero
                BatallaFinal(combate, p1, p2);

                //luego, si la vida del segundo es mayor que 0, el segundo contraataca
                if (p2.vidaActual > 0) {
                    BatallaFinal(combate, p2, p1);
                }
            } else {
                //si el turno no es igual a 1, el p2 ataca primero
                BatallaFinal(combate, p2, p1);

                //si el p1 sobrevive, contraataca
                if (p1.vidaActual > 0) {
                    BatallaFinal(combate, p1, p2);
                }
            }
        }

        // Resultado final: mostramos quién muere y quien gana
        System.out.println("\n-----------------------------------");
        if (p1.vidaActual <= 0) {
            System.out.println("¡" + p1.nombre + " se ha debilitado!💀 El ganador es " + p2.nombre);
        } else {
            System.out.println("¡" + p2.nombre + " se ha debilitado!💀 El ganador es " + p1.nombre);
        }
    }


    // Este método compara el texto con los objetos
    // Recorre el array 'lista' y compara el 'nombreBuscado' con el atributo .nombre de cada objeto
    private static Pokemon buscarPokemonPorNombre(Pokemon[] lista, String nombreBuscado) {
        //uso private porque sólo en este Main voy a usar este método para buscar pokémon y así
        //es static porque así lo puedo llamar directamente desde Main sin necesidad de crear un objeto
        //limito el acceso externo
        for (int i = 0; i < lista.length; i++) {
            //Al meter lenght, el bucle es dinámico y cambia sin yo preocuparme
            //es decir, si meto mas pokemon en el array de arriba, el bucle va aumentando sólo
            Pokemon p = lista[i];
            //creo la variable p de objeto Pokemon, donde guardo la posicion 0,1,2 de la lista de objetos pokemon....
            if (p.nombre.equalsIgnoreCase(nombreBuscado)){
                return p;
        // Si encuentra el nombre en la lista de nombres de objeto Pokemon, devuelve el objeto Pokémon completo
            }
        }
        return null; // Si termina el bucle y no lo encuentra, devuelve nada
    }

    private static void BatallaFinal(CombatePokemon c, Pokemon atacante, Pokemon defensor) {
        //Uso private para sólo acceder a este método en el Main
        // Pausa de 3 segundos (3000 milisegundos) para dar emoción al combate y que no salga todo seguido
        try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
        // Si algo falla en la pausa, sale el error, aunque es raro que pase

        // pokemon atacante y defensor lo que estoy haciendo es pasarle el tipo de dato, que es un objeto de pokemon
        // En CombatePokemon es lo mismo, digo que el dato es el objeto combatepokemon(para usar sus metodos) y lo llamo c para usarlo

        // Ahora le pasamos directamente los objetos 'atacante' y 'defensor' en lugar de todas las variables sueltas
        // El metodo simularTurno ahora se encarga de calcular daño y aplicar estados (quemado/veneno)
        //le paso los valores de pokemon atacante y defensor y guardo en la variable dano el daño final del metodo para saber
        //Cuanto quitarle de vida despues
        int dano = c.simularTurno(atacante, defensor);

        // Restamos el daño del ataque(daño final) a la vida del defensor
        defensor.vidaActual -= dano;

        // Se aplica el efecto del estado (veneno/quemado) si lo tiene
        // El método nos devuelve la vida tras sufrir el efecto del estado (ej. quita un % de vida)
        //le paso como argumentos el string estado y el int vidaActual
        defensor.vidaActual = c.aplicarEstado(defensor.estado, defensor.vidaActual);

        // Control para que la vida no sea negativa (si baja de 0, lo dejamos en 0)
        if (defensor.vidaActual < 0) defensor.vidaActual = 0;

        System.out.println("Vida restante de " + defensor.nombre + ": " + defensor.vidaActual +"\n");
    }
}