package org.example.Liga;

import java.util.Arrays;

public class Equipo 
{
    private String nombre;
    private Jugador[] jugadores;
    private int golesAfavor;
    private int golesEnContra;
    private int diferenciaGoles;
    private int mediaStats;
    private int puntos;
    private Partido[] partidos;

    
    public Equipo(String nombre, Jugador[] jugadores, int golesAfavor, int golesEnContra, int diferenciaGoles, int mediaStats, int puntos, Partido[] partidos) 
    {
        this.nombre = nombre;
        this.jugadores = jugadores;
        this.golesAfavor = golesAfavor;
        this.golesEnContra = golesEnContra;
        this.diferenciaGoles = diferenciaGoles;
        this.mediaStats = 0;
        this.puntos = puntos;
        this.partidos = partidos;
    }

    public String getNombre() 
    {
        return nombre;
    }
    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }
    public Jugador[] getJugadores() 
    {
        return jugadores;
    }
    public void setJugadores(Jugador[] jugadores) 
    {
        this.jugadores = jugadores;
    }
    public int getGolesAfavor() 
    {
        return golesAfavor;
    }
    public void setGolesAfavor(int golesAfavor) 
    {
        this.golesAfavor = golesAfavor;
    }
    public int getGolesEnContra() 
    {
        return golesEnContra;
    }
    public void setGolesEnContra(int golesEnContra) 
    {
        this.golesEnContra = golesEnContra;
    }
    public int getDiferenciaGoles() 
    {
        return diferenciaGoles;
    }
    public void setDiferenciaGoles(int diferenciaGoles) 
    {
        this.diferenciaGoles = diferenciaGoles;
    }
    public int getMediaStats() 
    {
        return mediaStats;
    }
    public void setMediaStats(int mediaStats) 
    {
        this.mediaStats = mediaStats;
    }
    public int getPuntos() 
    {
        return puntos;
    }
    public void setPuntos(int puntos) 
    {
        this.puntos = puntos;
    }
    public Partido[] getPartidos() 
    {
        return partidos;
    }
    public void setPartidos(Partido[] partidos) 
    {
        this.partidos = partidos;
    }

    public int calcularMediaEquipo()
    {
        int media = 0;
        for(Jugador jugadorprueba : this.jugadores)
        {
            media = media + jugadorprueba.getStats();
        }
        media = media/3;
        System.out.println("la media es : " + media);
        this.mediaStats = media;
        return media;
    }


    @Override
    public String toString() {
        return "Equipo [nombre=" + nombre + ", jugadores=" + Arrays.toString(jugadores) + ", golesAfavor=" + golesAfavor
                + ", golesEnContra=" + golesEnContra + ", diferenciaGoles=" + diferenciaGoles + ", mediaStats="
                + mediaStats + ", puntos=" + puntos + ", partidos=" + Arrays.toString(partidos) + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Equipo other = (Equipo) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (!Arrays.equals(jugadores, other.jugadores))
            return false;
        if (golesAfavor != other.golesAfavor)
            return false;
        if (golesEnContra != other.golesEnContra)
            return false;
        if (diferenciaGoles != other.diferenciaGoles)
            return false;
        if (mediaStats != other.mediaStats)
            return false;
        if (puntos != other.puntos)
            return false;
        if (!Arrays.equals(partidos, other.partidos))
            return false;
        return true;
    }

    
    
}
