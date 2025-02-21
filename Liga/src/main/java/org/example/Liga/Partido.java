package org.example.Liga;

import java.util.Arrays;
import java.util.Random;

public class Partido 
{
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int[] resultado;
    private int numeroGoles;

    
    public Partido(Equipo equipoLocal, Equipo equipoVisitante, int[] resultado, int numeroGoles) 
    {
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


    public void simularPartido()
    {
        Random ran = new Random();
        int golesEquipo1 = 0;
        int golesEquipo2 = 0;
        int dado1;
        int dado2;

        for(int i = 0 ; i < 5; i++)
        {
            if(this.equipoLocal.getMediaStats() > this.equipoVisitante.getMediaStats())
            {
                dado1 = ran.nextInt(10);
                dado2 = ran.nextInt(10);
                if(dado1 <= 6)
                {
                    golesEquipo1 ++;
                    System.out.println("El " +this.equipoLocal.getNombre()+ " ha metido gol");
                }
                if(dado2 <= 4)
                {
                    golesEquipo2 ++;
                    System.out.println("El " +this.equipoVisitante.getNombre()+ " ha metido gol");
                    
                }
            }
        }
        System.out.println("Marcador: " +this.equipoLocal.getNombre() + " " +golesEquipo1+ " - " + golesEquipo2+ " " +this.equipoVisitante.getNombre());
        

    
        
    }

    @Override
    public String toString() {
        return "Partido [equipoLocal= " + equipoLocal + ", equipoVisitante= " + equipoVisitante + ", resultado= "
                + Arrays.toString(resultado) + ", numeroGoles= " + numeroGoles + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Partido other = (Partido) obj;
        if (equipoLocal == null) {
            if (other.equipoLocal != null)
                return false;
        } else if (!equipoLocal.equals(other.equipoLocal))
            return false;
        if (equipoVisitante == null) {
            if (other.equipoVisitante != null)
                return false;
        } else if (!equipoVisitante.equals(other.equipoVisitante))
            return false;
        if (!Arrays.equals(resultado, other.resultado))
            return false;
        if (numeroGoles != other.numeroGoles)
            return false;
        return true;
    }

}
