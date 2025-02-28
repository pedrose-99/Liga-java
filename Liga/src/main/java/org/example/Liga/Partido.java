package org.example.Liga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Partido 
{
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int[] resultado;
    private int numeroGoles;

    public Partido(Equipo equipoLocal, Equipo equipoVisitante)
    {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }
    
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
    public int[] getResultado() 
    {
        return resultado;
    }
    public void setResultado(int[] resultado) 
    {
        this.resultado = resultado;
    }
    public int getNumeroGoles() 
    {
        return numeroGoles;
    }
    public void setNumeroGoles(int numeroGoles) 
    {
        this.numeroGoles = numeroGoles;
    }

    public void simularPartido()
    {
        Random ran = new Random();
        int golesEquipo1 = 0;
        int golesEquipo2 = 0;
        int minutoActual = 0;
        int marcarGol;
        int darAsistencia;
        List<String> eventos = new ArrayList<>();
        
        
        int[] tarjetasAmarillasLocal = new int[11];
        int[] tarjetasRojasLocal = new int[11];
        int[] tarjetasAmarillasVisitante = new int[11];
        int[] tarjetasRojasVisitante = new int[11];
        
        for (int i = 0; i < 5; i++) 
        {
            if (this.equipoLocal.getMediaStats() > this.equipoVisitante.getMediaStats()) 
            {
                int dado1 = ran.nextInt(10);
                int dado2 = ran.nextInt(10);
                int dado3 = ran.nextInt(10);
                
                if (dado1 <= 7 && minutoActual < 90) 
                {
                    minutoActual += ran.nextInt(1, 17);
                    if (minutoActual > 90) break;
                    
                    golesEquipo1++;
                    marcarGol = ran.nextInt(1, 11);
                    eventos.add(minutoActual + ": Gol del " + this.equipoLocal.getNombre() + " (Jugador " + marcarGol + ")");
                    
                    if (dado3 <= 7) 
                    {
                        do 
                        {
                            darAsistencia = ran.nextInt(0, 11);
                        } 
                        while (darAsistencia == marcarGol);
                        eventos.add(minutoActual + ": Asistencia del " + this.equipoLocal.getNombre() + " (Jugador " + darAsistencia + ")");
                    }
                }
                
                if (dado2 <= 3 && minutoActual < 90) 
                {
                    minutoActual += ran.nextInt(1, 17);
                    if (minutoActual > 90) break;
                    golesEquipo2++;
                    marcarGol = ran.nextInt(1, 11);
                    eventos.add(minutoActual + ": Gol del " + this.equipoVisitante.getNombre() + " (Jugador " + marcarGol + ")");
                    
                    if (dado3 <= 7)
                    {
                        do 
                        {
                            darAsistencia = ran.nextInt(0, 11);
                        } 
                        while (darAsistencia == marcarGol);
                        eventos.add(minutoActual + ": Asistencia del " + this.equipoVisitante.getNombre() + " (Jugador " + darAsistencia + ")");
                    }
                }
            }
            
        
            if (ran.nextInt(10) < 3 && minutoActual < 90) 
            {
                int jugador = ran.nextInt(0, 11);
                boolean esLocal = ran.nextBoolean();
                
                int minutoTarjeta = minutoActual + ran.nextInt(1, 5); 
                if (minutoTarjeta > 90) minutoTarjeta = 90;
                
                if (esLocal) {
                    if (tarjetasRojasLocal[jugador] == 0) 
                    {
                        tarjetasAmarillasLocal[jugador]++;
                        eventos.add(minutoTarjeta + ": Tarjeta amarilla para " + this.equipoLocal.getNombre() + " (Jugador " + jugador + ")");
                        if (tarjetasAmarillasLocal[jugador] == 2) 
                        {
                            tarjetasRojasLocal[jugador] = 1;
                            eventos.add(minutoTarjeta + ": ¡Expulsión! Tarjeta roja para " + this.equipoLocal.getNombre() + " (Jugador " + jugador + ")");
                        }
                    }
                } 
                else 
                {
                    if (tarjetasRojasVisitante[jugador] == 0) 
                    {
                        tarjetasAmarillasVisitante[jugador]++;
                        eventos.add(minutoTarjeta + ": Tarjeta amarilla para " + this.equipoVisitante.getNombre() + " (Jugador " + jugador + ")");
                        if (tarjetasAmarillasVisitante[jugador] == 2) 
                        {
                            tarjetasRojasVisitante[jugador] = 1;
                            eventos.add(minutoTarjeta + ": ¡Expulsión! Tarjeta roja para " + this.equipoVisitante.getNombre() + " (Jugador " + jugador + ")");
                        }
                    }
                }
            }
        }
        
        eventos.sort(Comparator.comparingInt(e -> Integer.parseInt(e.split(":")[0])));
        
        
        for (String evento : eventos) 
        {
            System.out.println(evento);
        }
        
        System.out.println("Marcador: " + this.equipoLocal.getNombre() + " " + golesEquipo1 + " - " + golesEquipo2 + " " + this.equipoVisitante.getNombre());
        System.out.println("Jugadores amonestados:");
        for (int i = 0; i < 11; i++) 
        {
            if (tarjetasAmarillasLocal[i] > 0 || tarjetasRojasLocal[i] > 0) 
            {
                System.out.println("Jugador " + i + " del " + this.equipoLocal.getNombre() + " - Amarillas: " + tarjetasAmarillasLocal[i] + " | Rojas: " + tarjetasRojasLocal[i]);
            }
            if (tarjetasAmarillasVisitante[i] > 0 || tarjetasRojasVisitante[i] > 0) 
            {
                System.out.println("Jugador " + i + " del " + this.equipoVisitante.getNombre() + " - Amarillas: " + tarjetasAmarillasVisitante[i] + " | Rojas: " + tarjetasRojasVisitante[i]);
            }
        }
        if (golesEquipo1 > golesEquipo2)
        {
            this.equipoLocal.setPuntos(this.equipoLocal.getPuntos() + 3);
        }
        else if (golesEquipo2 > golesEquipo1)
        {
            this.equipoVisitante.setPuntos(this.equipoVisitante.getPuntos() + 3);
        }
        else
        {
            this.equipoLocal.setPuntos(this.equipoLocal.getPuntos() + 1);
            this.equipoVisitante.setPuntos(this.equipoVisitante.getPuntos() + 1);
        }
        
    }
@Override
public boolean equals(Object obj) 
{
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    
    Partido other = (Partido) obj;
    
    return Objects.equals(equipoLocal, other.equipoLocal) &&
           Objects.equals(equipoVisitante, other.equipoVisitante) &&
           Arrays.equals(resultado, other.resultado) &&
           numeroGoles == other.numeroGoles;
}


}
