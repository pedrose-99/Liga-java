package org.example.Liga.liga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import org.example.Liga.personas.Jugador;

public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int[] resultado;
    private int numeroGoles;

    public Partido(Equipo equipoLocal, Equipo equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }

    public void simularPartido() {
        Random ran = new Random();
        int golesEquipo1 = 0;
        int golesEquipo2 = 0;
        int minutoActual = 0;
        List<String> eventos = new ArrayList<>();

        System.out.println("---------------------------------------------");
        System.out.println("BIENVENIDOS AL PARTIDO ENTRE " + this.equipoLocal.getNombre() + " vs " + this.equipoVisitante.getNombre());
        System.out.println("---------------------------------------------");

        for (int i = 0; i < 5; i++) {
            golesEquipo1 = simularGolConPortero(minutoActual, golesEquipo1, this.equipoLocal, this.equipoVisitante, eventos, ran);
            golesEquipo2 = simularGolConPortero(minutoActual, golesEquipo2, this.equipoVisitante, this.equipoLocal, eventos, ran);
        }

        mostrarEventos(eventos);
        mostrarMarcador(golesEquipo1, golesEquipo2);
    }

    public int simularGolConPortero(int minutoActual, int golesEquipo, Equipo equipoAtacante, Equipo equipoDefensor, List<String> eventos, Random ran) {
        int dado = ran.nextInt(10);
        if (dado <= 6 && minutoActual < 90) { 
            minutoActual += ran.nextInt(1, 24);
            if (minutoActual > 90) return golesEquipo;

            int marcarGol = ran.nextInt(1, 10);
            Jugador goleador = equipoAtacante.getJugadores()[marcarGol - 1];

            Jugador portero = equipoDefensor.getJugadores()[0];

            
            int probabilidadAtajada = ran.nextInt(100);
            if (probabilidadAtajada < 30) { 
                eventos.add(minutoActual + ": ¡Parada espectacular de " + portero.getNombre() + " " + portero.getApellido() + "! Evita el gol del " + equipoAtacante.getNombre());
            } else {
                golesEquipo++;
                eventos.add(minutoActual + ": Gol del " + equipoAtacante.getNombre() + " (" + goleador.getNombre() + " " + goleador.getApellido() + ")");

                if (ran.nextInt(10) <= 7) { 
                    int darAsistencia;
                    do {
                        darAsistencia = ran.nextInt(1, 10);
                    } while (darAsistencia == marcarGol);
                    Jugador asistente = equipoAtacante.getJugadores()[darAsistencia - 1];
                    eventos.add(minutoActual + ": Asistencia del " + equipoAtacante.getNombre() + " (" + asistente.getNombre() + " " + asistente.getApellido() + ")");
                }
            }
        }
        return golesEquipo;
    }

    public void mostrarEventos(List<String> eventos) {
        eventos.forEach(System.out::println);
    }

    public void mostrarMarcador(int golesEquipo1, int golesEquipo2) {
        System.out.println("Marcador: " + this.equipoLocal.getNombre() + " " + golesEquipo1 + " - " + golesEquipo2 + " " + this.equipoVisitante.getNombre());
    }
}
