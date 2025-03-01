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
    private int paradasPorteroLocal = 0;
    private int paradasPorteroVisitante = 0;

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

        int[] tarjetasAmarillasLocal = new int[11];
        int[] tarjetasRojasLocal = new int[11];
        int[] tarjetasAmarillasVisitante = new int[11];
        int[] tarjetasRojasVisitante = new int[11];

        System.out.println("---------------------------------------------");
        System.out.println("BIENVENIDOS AL PARTIDO ENTRE " + this.equipoLocal.getNombre() + " vs " + this.equipoVisitante.getNombre());
        System.out.println("---------------------------------------------");

        for (int i = 0; i < 5; i++) {
            if (this.equipoLocal.getMediaStats() > this.equipoVisitante.getMediaStats()) {
                golesEquipo1 = simularGolMayorMedia(minutoActual, golesEquipo1, this.equipoLocal, eventos, ran, true);
                golesEquipo2 = simularGolMenorMedia(minutoActual, golesEquipo2, this.equipoVisitante, eventos, ran, false);
            } else {
                golesEquipo2 = simularGolMayorMedia(minutoActual, golesEquipo2, this.equipoVisitante, eventos, ran, false);
                golesEquipo1 = simularGolMenorMedia(minutoActual, golesEquipo1, this.equipoLocal, eventos, ran, true);
            }
        }

        mostrarEventos(eventos);
        mostrarMarcador(golesEquipo1, golesEquipo2);
        mostrarParadasPorteros(); 
    }

    private int simularGolMayorMedia(int minutoActual, int golesEquipo, Equipo equipo, List<String> eventos, Random ran, boolean esLocal) {
        int dado = ran.nextInt(10);
        if (dado <= 7 && minutoActual < 90) {
            minutoActual += ran.nextInt(1, 24);
            if (minutoActual > 90) return golesEquipo;

            if (porteroAtaja(ran, esLocal)) {
                return golesEquipo;
            }

            golesEquipo++;
            registrarGol(equipo, minutoActual, eventos, ran);
        }
        return golesEquipo;
    }

    private int simularGolMenorMedia(int minutoActual, int golesEquipo, Equipo equipo, List<String> eventos, Random ran, boolean esLocal) {
        int dado = ran.nextInt(10);
        if (dado <= 4 && minutoActual < 90) {
            minutoActual += ran.nextInt(1, 24);
            if (minutoActual > 90) return golesEquipo;

            if (porteroAtaja(ran, esLocal)) {
                return golesEquipo;
            }

            golesEquipo++;
            registrarGol(equipo, minutoActual, eventos, ran);
        }
        return golesEquipo;
    }

    private boolean porteroAtaja(Random ran, boolean esLocal) {
        int dadoPortero = ran.nextInt(10);  
        if (dadoPortero <= 4) {  
            if (esLocal) {
                paradasPorteroVisitante++;
            } else {
                paradasPorteroLocal++;
            }
            return true;  
        }
        return false;
    }

    private void registrarGol(Equipo equipo, int minuto, List<String> eventos, Random ran) {
        int marcarGol = ran.nextInt(1, 11);
        Jugador goleador = equipo.getJugadores()[marcarGol - 1];
        eventos.add(minuto + ": Gol del " + equipo.getNombre() + " (" + goleador.getNombre() + " " + goleador.getApellido() + ")");

        if (ran.nextInt(10) <= 7) {
            int darAsistencia;
            do {
                darAsistencia = ran.nextInt(1, 11);
            } while (darAsistencia == marcarGol);
            Jugador asistente = equipo.getJugadores()[darAsistencia - 1];
            eventos.add(minuto + ": Asistencia del " + equipo.getNombre() + " (" + asistente.getNombre() + " " + asistente.getApellido() + ")");
        }
    }

    private void mostrarEventos(List<String> eventos) {
        eventos.sort(Comparator.comparingInt(e -> Integer.parseInt(e.split(":")[0])));
        eventos.forEach(System.out::println);
    }

    private void mostrarMarcador(int golesEquipo1, int golesEquipo2) {
        System.out.println("Marcador final: " + this.equipoLocal.getNombre() + " " + golesEquipo1 + " - " + golesEquipo2 + " " + this.equipoVisitante.getNombre());
    }

    private void mostrarParadasPorteros() {
        System.out.println("Resumen de porteros:");
        System.out.println("Portero de " + equipoLocal.getNombre() + " realizó " + paradasPorteroLocal + " paradas.");
        System.out.println("Portero de " + equipoVisitante.getNombre() + " realizó " + paradasPorteroVisitante + " paradas.");
    }
}
