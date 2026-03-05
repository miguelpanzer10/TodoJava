package BatallaPokemon;

import java.util.Random;


public class CombatePokemon {

    public int calcularDano(int poderAtaque, int defensaRival, int nivelAtacante) {
        // Aplicamos la fórmula: (poder * nivel / defensa) / 2
        int danoBase = (poderAtaque * nivelAtacante / defensaRival) / 2;
        return danoBase;
    }

    // esGolpeCritico(): 15% de probabilidad
    public boolean esGolpeCritico() {
        Random rand = new Random();
        // Generamos un número entre 0 y 99
        int suerte = rand.nextInt(100);

        // Si sale del 0 al 14 (son 15 números), devolvemos true
        return suerte < 15;
    }
    //Si suerte es 8, la pregunta "¿8 es menor que 15?" resulta en true.
    //Si suerte es 50, la pregunta "¿50 es menor que 15?" resulta en false.
    //Al poner return suerte < 15;, le estás diciendo a Java: "Calcula si esto es verdad o mentira, y el resultado (true o false) devuélvelo directamente".


    //ahora calculo las ventajas o no, meto el tipo roca del primer gym de Kanto
    public double calcularEfectividad(String tipoAtaque, String tipoDefensor) {
        // Ventajas (Daño x2)
        if ((tipoAtaque.equalsIgnoreCase("Fuego") && tipoDefensor.equalsIgnoreCase("Planta")) ||
                (tipoAtaque.equalsIgnoreCase("Planta") && tipoDefensor.equalsIgnoreCase("Agua")) ||
                (tipoAtaque.equalsIgnoreCase("Agua") && tipoDefensor.equalsIgnoreCase("Fuego")) ||
                (tipoAtaque.equalsIgnoreCase("Electrico") && tipoDefensor.equalsIgnoreCase("Agua")) ||
                (tipoAtaque.equalsIgnoreCase("Roca") && tipoDefensor.equalsIgnoreCase("Fuego"))||
                (tipoAtaque.equalsIgnoreCase("Planta") && tipoDefensor.equalsIgnoreCase("Roca"))||
                (tipoAtaque.equalsIgnoreCase("Agua") && tipoDefensor.equalsIgnoreCase("Roca"))
        ) { // Roca vence a Fuego
            return 2.0;
        }
        // Desventaja(Daño x0.5)
        else if ((tipoAtaque.equalsIgnoreCase("Planta") && tipoDefensor.equalsIgnoreCase("Fuego")) ||
                (tipoAtaque.equalsIgnoreCase("Agua") && tipoDefensor.equalsIgnoreCase("Planta")) ||
                (tipoAtaque.equalsIgnoreCase("Fuego") && tipoDefensor.equalsIgnoreCase("Agua")) ||
                (tipoAtaque.equalsIgnoreCase("Fuego") && tipoDefensor.equalsIgnoreCase("Roca")) || // Fuego débil ante Roca
                (tipoAtaque.equalsIgnoreCase("Roca") && tipoDefensor.equalsIgnoreCase("Agua")) ||
                (tipoAtaque.equalsIgnoreCase("Electrico") && tipoDefensor.equalsIgnoreCase("Planta")) ||// Roca débil ante Agua
                (tipoAtaque.equalsIgnoreCase("Roca") && tipoDefensor.equalsIgnoreCase("Planta"))) { // Roca débil ante Planta
            return 0.5;
        }
        // Neutro
        return 1.0;
    }

    public int aplicarEstado(String estado, int vidaActual) {
        switch (estado.toLowerCase()) {
            case "veneno":
                return (int) (vidaActual * 0.90);
            //El (int) convierte el resultado en int, porque seguramente al multiplicarlo, sale decimal
            // Al usar 'return', el método termina aquí y devuelve el valor inmediatamente.
            // No hace falta poner 'break' porque el return ya "sale" de todo el método.

            case "quemado":
                return (int) (vidaActual * 0.94);
                //el (int) convierte el resultado en int, porque seguramente al multiplicarlo, sale decimal

            case "paralizado":
                return vidaActual;

            default:
                // Si el estado no coincide con ninguno, devolvemos la vida sin cambios.
                return vidaActual;
        }
    }

    public int determinarOrdenAtaque(int velocidad1, int velocidad2) {
        if (velocidad1 > velocidad2) {
            return 1; // Ataca el primero
        } else if (velocidad2 > velocidad1) {
            return 2; // Ataca el segundo
        } else {
            // Empate: suerte pura
            Random rand = new Random();
            return rand.nextInt(2) + 1; // Devuelve 1 o 2 al azar
        }
    }
    //rand.nextInt(2): Lanza un dado de dos caras(por que es n-1, siendo n el numero que pones): sale 0 o 1.
    //+ 1: Le suma uno al resultado. Si sale 0, ahora es 1. Si salió 1, ahora es 2.
    //return: Devuelve ese 1 o 2 para decidir quién empieza.

    //método que toma los anteriores
    // Cambiamos los parámetros para recibir los objetos Pokemon completos
    public int simularTurno(Pokemon atacante, Pokemon defensor) {
        // Si el Pokémon que va a atacar está paralizado, tiene un 25% de probabilidad de fallar(no atacar)
        if (atacante.estado.equalsIgnoreCase("paralizado")) {
            Random Paralisis = new Random();
            if (Paralisis.nextInt(100) < 25) { // 25% de probabilidad
                System.out.println( "\nTurno de " + atacante.nombre + " :");
                System.out.println("¡" + atacante.nombre + " está paralizado y no puede moverse! ⚡⚡");
                return 0;
                // Devolvemos 0 daño y salimos del método, así es mas funcional porque sale y no hace lo demás
            }
        }

        //Uso el objeto de la clase Pokemon,que puedo acceder a él porque en Main llamo a ese objeto y este metodo lo coge como parámetro
        System.out.println("Turno de " + atacante.nombre + " :");
        if(atacante.tipo=="Fuego"){
            System.out.println(atacante.nombre+" uso Lanzallamas ♨️");
        } else if (atacante.tipo=="Planta") {
            System.out.println(atacante.nombre+" uso Lluevehojas 🍃");
        } else if (atacante.tipo=="Roca") {
            System.out.println(atacante.nombre+" uso Avalancha 🗻");
        } else if (atacante.tipo=="Agua") {
            System.out.println(atacante.nombre+" uso Hidrobomba 🚿");
        }
        else {
            System.out.println(atacante.nombre+" uso Rayo ⛈️");
        }
        //Meto unos ataques estándar según el tipo

        //llamo al metodo de efectividad y guardo el resultado (2,0'5...) en la variable efec
        // Ahora sacamos los tipos directamente de los objetos
        double efec = calcularEfectividad(atacante.tipo, defensor.tipo);

        // Miramos si hay suerte y es crítico
        //si el metodo critico es false, se queda en 1 y el valor es el mismo, pero si devuelve true(<15) critico se vuelve 2(duplica el daño)
        int critico = 1;
        if (esGolpeCritico()) {
            critico = 2;
            System.out.println("¡¡GOLPE CRÍTICO‼️");
        }

        // Calculo del daño con la formula base
        // Usamos los atributos del objeto: atacante(Pokemon).ataque, defensor.defensa y atacante.nivel
        int base = calcularDano(atacante.ataque, defensor.defensa, atacante.nivel);

        //Daño final: multiplicamos todo para ver el daño total en cada turno
        int danoFinal = (int) (base * efec * critico);
        //Uso otra vez el (int) porque calcularefectividad es double, asi me aseguro que me lo pasa a int

        // Mensaje para el usuario
        if (efec > 1) System.out.println("¡Es muy eficaz! ");
        else if (efec < 1) System.out.println("No es muy eficaz...");

        System.out.println("Daño infligido: " + danoFinal);
        //Guía visual del daño

        // Estados
        Random rand = new Random();
        int probabilidad = rand.nextInt(100); // 0 a 99
        //Tengo que meter lo de estado ninguno, porque sino, al ser varios turnos, lo quema,paraliza o envenena varias veces
        // Si el que ataca es de Fuego, tiene un 20% de quemar al rival (y solo si no tiene estado previo)
        //también he tenido que meter que la condicion sea que la vida del defensor es mayor que 0, porque sino, a veces lo quema y lo mata
        if (atacante.tipo.equalsIgnoreCase("Fuego") && probabilidad < 20 && defensor.estado.equalsIgnoreCase("ninguno")&& defensor.vidaActual>0) {
            defensor.estado = "quemado";
            System.out.println("¡" + atacante.nombre + " ha quemado a " + defensor.nombre + "! 🔥");
        }
        // Si el que ataca es de Planta, tiene un 15% de envenenar al rival (y solo si no tiene estado previo)
        else if (atacante.tipo.equalsIgnoreCase("Planta") && probabilidad < 15 && defensor.estado.equalsIgnoreCase("ninguno")&& defensor.vidaActual>0) {
            defensor.estado = "veneno";
            System.out.println("¡" + atacante.nombre + " ha envenenado a " + defensor.nombre + "! ☠️");
        }
        // Si el que ataca es electrico, tiene un 25% de paralizar al rival
        // ¡Añadimos la condición de que el estado sea "ninguno" para no paralizar dos veces!
        else if (atacante.tipo.equalsIgnoreCase("Electrico") && probabilidad < 25 && defensor.estado.equalsIgnoreCase("ninguno")&& defensor.vidaActual>0) {
            defensor.estado = "paralizado";
            defensor.velocidad = defensor.velocidad / 2;
            System.out.println("¡" + atacante.nombre + " ha paralizado a " + defensor.nombre + "! ⚡");
            System.out.println("¡La velocidad de " + defensor.nombre + " ha disminuido! ⬇️");
            System.out.println("¡La velocidad de " + defensor.nombre + " ahora es: "+defensor.velocidad);
            //Meto que si le paraliza, diga la velocidad actual del pokemon así se ver visualmente la disminución
        }

        return danoFinal;
    }


}


