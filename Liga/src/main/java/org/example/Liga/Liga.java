package org.example.Liga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Liga 
{
    private String nombre;
    private ArrayList<Equipo> equipos = new ArrayList<>();
    private ArrayList<Jornada> jornadas = new ArrayList<>();



    public Liga (String nombre, ArrayList<Equipo> equipos, ArrayList<Jornada> jornadas)
    {
        this.nombre = nombre;
        this.equipos = equipos;
        this.jornadas = jornadas;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }


    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }


    public ArrayList<Jornada> getJornadas() {
        return jornadas;
    }


    public void setJornadas(ArrayList<Jornada> jornadas) {
        this.jornadas = jornadas;
    }


    public void aniadirJornada(Jornada jornada)
    {
        this.jornadas.add(jornada);
    }

    public void jugarJornada()
    {

    }

    public void verClasificacion(Equipo[] equipos)
    {
        
    }

    public static Equipo crearEquipo(String nombre)
	{
		int i;
		Equipo equipoPrueba;
		Jugador[] jugadores = new Jugador[11];

		i = 0;
		jugadores[i] = crearJugador(Posicion.PORTERO);
		i++;
		while (i <= 4)
		{
			jugadores[i] = crearJugador(Posicion.DEFENSA);
			i++;
		}
		while (i <= 7)
		{
			jugadores[i] = crearJugador(Posicion.MEDIOCAMPISTA);
			i++;
		}
		while (i <= 10)
		{
			jugadores[i] = crearJugador(Posicion.DELANTERO);
			i++;
		}
		equipoPrueba = new Equipo(nombre, jugadores);
		equipoPrueba.calcularMediaEquipo();

		return (equipoPrueba);
	}
}
