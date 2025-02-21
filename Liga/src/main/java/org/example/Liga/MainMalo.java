public class MainMalo {

    public static void main(String[] args) 
    {
        Jugador jugador1 = new Jugador("Pepito", "asklfh", Continente.EUROPA, 5, Posicion.DELANTERO, 1, 0, 90);
        Jugador jugador2 = new Jugador("Manuel", "sdahha", Continente.EUROPA, 8, Posicion.DEFENSA, 1, 0, 88);
        Jugador jugador3 = new Jugador("Paco", "ghgfd", Continente.EUROPA, 0, Posicion.DELANTERO, 1, 0, 80);
        Jugador jugador4 = new Jugador("Pepe", "cvads", Continente.EUROPA, 0, Posicion.DELANTERO, 0, 1, 80);
        Jugador jugador5 = new Jugador("Juan", "awee", Continente.EUROPA, 4, Posicion.DELANTERO, 1, 0, 80);
        Jugador jugador6 = new Jugador("Francisco", "tgfds", Continente.EUROPA, 1, Posicion.DELANTERO, 1, 0, 80);
        
        Jugador[] jogador = new Jugador[3];
        jogador[0] = jugador1;
        jogador[1] = jugador2;
        jogador[2] = jugador3;

        Jugador[] jogador2 = new Jugador[3];
        jogador2[0] = jugador4;
        jogador2[1] = jugador5;
        jogador2[2] = jugador6;

        Equipo equipo1 = new Equipo("hola", jogador, 0, 0, 0, 80, 0, null);
        Equipo equipo2 = new Equipo("adios", jogador2, 0, 0, 0, 70, 0, null);

        Partido partidoPrueba = new Partido(equipo1, equipo2, null, 0);
        //partidoPrueba.simularPartido();
        System.out.println("media equipo " + equipo1.getMediaStats());
        equipo1.calcularMediaEquipo();
        System.out.println("media equipo " + equipo1.getMediaStats());
        equipo2.calcularMediaEquipo();

    }   
    
}
