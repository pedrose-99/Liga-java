package Liga;
import java.util.List;
import Entidades.Equipo;
import Liga.Jornada;
import Humano.Jugador;

public class Liga {
    String nombre;
    List<Equipo> equipos;
    List<Jornada> jornadas;
    List<Jugador> jugadores;
    void jugarjornada(){
    void verclasificacion(int equipo){


public void jugarJornada(int numeroJornada) {
        Jornada jornada = jornadas.get(numeroJornada - 1);
        for (Partido partido : jornada.getPartidos()) {
        int golesLocal = (int) (Math.random() * 5);    
        int golesVisitante = (int) (Math.random() * 5);
        partido.setGolesLocal(golesLocal);
        partido.setGolesVisitante(golesVisitante);
    



}


