package org.example.Liga.personas;

import org.example.Liga.enumLiga.Continente;
import org.example.Liga.enumLiga.Posicion;

public class Portero extends Jugador {
    private int paradas; // Número de paradas realizadas

    public Portero(String nombre, String apellido, Continente continente, int stats, Posicion posicion) {
        super(nombre, apellido, continente, stats, posicion);
        this.paradas = 0; // Inicializamos el número de paradas en 0
    }

    // Método para registrar una parada
    public void realizarParada() {
        paradas++;
        System.out.println(getNombre() + " ha realizado una parada. Total paradas: " + paradas);
    }

    // Método para obtener el número total de paradas
    public int getParadas() {
        return paradas;
    }

    @Override
    public String toString() {
        return super.toString() + " | Portero [paradas=" + paradas + "]";
    }
}

