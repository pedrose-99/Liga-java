package Entidades;

import java.util.Scanner;

public class Partidos 
{
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int[] resultado;
    private int numeroGoles;

    
    public Partidos(Equipo equipoLocal, Equipo equipoVisitante, int[] resultado, int numeroGoles) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.resultado = resultado;
        this.numeroGoles = numeroGoles;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }
    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }
    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }
    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }
    public int[] getResultado() {
        return resultado;
    }
    public void setResultado(int[] resultado) {
        this.resultado = resultado;
    }
    public int getNumeroGoles() {
        return numeroGoles;
    }
    public void setNumeroGoles(int numeroGoles) {
        this.numeroGoles = numeroGoles;
    }

    
    
}
