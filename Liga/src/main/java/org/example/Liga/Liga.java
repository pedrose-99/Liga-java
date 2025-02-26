package org.example.Liga;

import java.util.Arrays;

public class Liga 
{
    private String nombre;
    private Equipo[] equipos;
    private Jornada[] jornadas;


    public Liga(String nombre, Equipo[] equipos, Jornada[] jornadas)
    {

    }

    @Override
    public String toString() {
        return "Liga [nombre=" + nombre + ", equipos=" + Arrays.toString(equipos) + ", jornadas="
                + Arrays.toString(jornadas) + "]";
    }

    public void jugarJornada()
    {

    }

    public void verClasificacion(Equipo[] equipos)
    {
        
    }
}
