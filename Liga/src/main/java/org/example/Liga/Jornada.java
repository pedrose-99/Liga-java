package org.example.Liga;

import java.util.ArrayList;

public class Jornada 
{
    private int numJornada;
    private ArrayList<Partido> partidos = new ArrayList<>();


    public Jornada(int numJornada)
    {
        this.numJornada = numJornada;
    }

    public Jornada(int numJornada, ArrayList<Partido> partidos)
    {
        this.numJornada = numJornada;
        this.partidos = partidos;
    }

    public int getNumJornada() {
        return numJornada;
    }

    public void setNumJornada(int numJornada) {
        this.numJornada = numJornada;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    public void aniadirPartido(Partido partido)
    {
        this.partidos.add(partido);
    }

    public void simularJornada()
    {
        for (Partido partido : this.partidos)
        {
            partido.simularPartido();
        }
    }
}
