package Entidades;

import Humano.Jugador;

public class Equipo 
{
    private String nombre;
    private Jugador[] jugadores;
    private int golesAfavor;
    private int golesEnContra;
    private int diferenciaGoles;
    private int mediaStats;
    private int puntos;
    private Partidos[] partidos;

    
    public Equipo(String nombre, Jugador[] jugadores, int golesAfavor, int golesEnContra, int diferenciaGoles, int mediaStats, int puntos, Partidos[] partidos) {
        this.nombre = nombre;
        this.jugadores = jugadores;
        this.golesAfavor = golesAfavor;
        this.golesEnContra = golesEnContra;
        this.diferenciaGoles = diferenciaGoles;
        this.mediaStats = mediaStats;
        this.puntos = puntos;
        this.partidos = partidos;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Jugador[] getJugadores() {
        return jugadores;
    }
    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }
    public int getGolesAfavor() {
        return golesAfavor;
    }
    public void setGolesAfavor(int golesAfavor) {
        this.golesAfavor = golesAfavor;
    }
    public int getGolesEnContra() {
        return golesEnContra;
    }
    public void setGolesEnContra(int golesEnContra) {
        this.golesEnContra = golesEnContra;
    }
    public int getDiferenciaGoles() {
        return diferenciaGoles;
    }
    public void setDiferenciaGoles(int diferenciaGoles) {
        this.diferenciaGoles = diferenciaGoles;
    }
    public int getMediaStats() {
        return mediaStats;
    }
    public void setMediaStats(int mediaStats) {
        this.mediaStats = mediaStats;
    }
    public int getPuntos() {
        return puntos;
    }
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    public Partidos[] getPartidos() {
        return partidos;
    }
    public void setPartidos(Partidos[] partidos) {
        this.partidos = partidos;
    }

    
}
