package org.example.Liga.liga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.example.Liga.GestionNumero;
import org.example.Liga.PrintTexto;
import org.example.Liga.personas.Jugador;
import org.example.Liga.personas.Portero;

import com.github.javafaker.Faker;

public class Liga 
{
    private String nombre;
    private ArrayList<Equipo> equipos = new ArrayList<>();
    private ArrayList<Jornada> jornadas = new ArrayList<>();


    public Liga(String[] equipos, boolean mundial)
    {
        Faker fakerEs = new Faker(new Locale("es"));
        if (mundial)
        {
            this.nombre = "MUNDIAL";
        }
        else
        {
            this.nombre = fakerEs.pokemon().name();
        }
        this.equipos = this.crearArrayEquipos(equipos, mundial);
        this.jornadas = this.generarCalendario(this.equipos);

    }

    public Liga (String nombre, ArrayList<Equipo> equipos, ArrayList<Jornada> jornadas)
    {
        this.nombre = nombre;
        this.equipos = equipos;
        this.jornadas = jornadas;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }


    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }


    public ArrayList<Jornada> getJornadas() {
        return jornadas;
    }


    public void setJornadas(ArrayList<Jornada> jornadas) {
        this.jornadas = jornadas;
    }


    public void aniadirJornada(Jornada jornada)
    {
        this.jornadas.add(jornada);
    }


    public void maximoGoleador()
    {
        Jugador masGoles = null;
        
        for (Equipo equipo : this.equipos) 
        {
            for (Jugador jugador : equipo.getJugadores()) 
            {
                if (masGoles == null || jugador.getGoles() > masGoles.getGoles()) 
                {
                    masGoles = jugador;
                }
            }
        }
        System.out.println("Máximo goleador y pichichi de la liga: " + masGoles.getNombre() + " con " + masGoles.getGoles() + " goles.");
    }
    public void maximoAsistente()
    {
        Jugador masAsistencias = null;
        
        for (Equipo equipo : this.equipos) 
        {
            for (Jugador jugador : equipo.getJugadores()) 
            {
                if (masAsistencias == null || jugador.getAsistencias() > masAsistencias.getAsistencias()) 
                {
                    masAsistencias = jugador;
                }
            }
        }
        System.out.println("Máximo asistente de la liga: " + masAsistencias.getNombre() + " con " + masAsistencias.getAsistencias() + " asistencias.");
    }
    public void masRojas()
    {
        Jugador masExpulsado = null;
        
        for (Equipo equipo : this.equipos) 
        {
            for (Jugador jugador : equipo.getJugadores()) 
            {
                if (masExpulsado == null || jugador.getTarjetasRojas() > masExpulsado.getTarjetasRojas()) 
                {
                    masExpulsado = jugador;
                }
            }
        }
        System.out.println("Máximo expulsado y más guarro de la liga: " + masExpulsado.getNombre() + " con " + masExpulsado.getTarjetasRojas() + " tarjetas rojas.");
    }
    public void masAmarillas()
    {
        Jugador masSancionado = null;
        
        for (Equipo equipo : this.equipos) 
        {
            for (Jugador jugador : equipo.getJugadores()) 
            {
                if (masSancionado == null || jugador.getTarjetasAmarillas() > masSancionado.getTarjetasAmarillas()) 
                {
                    masSancionado = jugador;
                }
            }
        }
        System.out.println("Más sancionado de la liga: " + masSancionado.getNombre() + " con " + masSancionado.getTarjetasAmarillas() + " tarjetas amarillas.");
    }
    public void maximasParadas()
    {
        Portero masParadas = null;
        
        for (Equipo equipo : this.equipos) 
        {
            for (Portero portero : equipo.getPortero()) 
            {
                if (masParadas == null || portero.getParadas()() > masParadas.getParadas()) 
                {
                    masParadas = portero;
                }
            }
        }
        System.out.println("Más paradas de la liga y trofeo zamora: " + masParadas.getNombre() + " con " + masParadas.getParadas() + " paradas.");
    }

    public void calcularMaximos() 
    {
        maximoGoleador();
        maximoAsistente();
        maximasParadas();
        masAmarillas();
        masRojas();
    }

	public void imprimirJornadas(ArrayList<Jornada> jornadas)
	{
		for (Jornada jornadaPrueba : jornadas)
		{
			System.out.println(PrintTexto.BLUE + "--------------------------------------------------------------");
			System.out.println(PrintTexto.RED + "JORNADA " + jornadaPrueba.getNumJornada());
			for (Partido partidoPrueba : jornadaPrueba.getPartidos())
			{
				System.out.println(PrintTexto.GREEN +partidoPrueba.getEquipoLocal().getNombre() + " vs " + partidoPrueba.getEquipoVisitante().getNombre());
			}
			System.out.println(PrintTexto.CYAN + "--------------------------------------------------------------");
		}
	}

    public  ArrayList<Jornada> generarCalendario(List<Equipo> equipos)
	{
		Partido partido;
		ArrayList<Jornada> jornadas = new ArrayList<>();
		Jornada jornada;
		int numJornada;

		Collections.shuffle(equipos);
		numJornada = 1;
		for (int z = 0; z < 2; z++)
		{
			for (int j = 0; j < (equipos.size() - 1); j++)
			{
				jornada = new Jornada(numJornada);
				for (int i = 0; i < (equipos.size()/2); i++)
				{
					if (z == 0)
					{
						partido = new Partido(equipos.get(i), equipos.get(equipos.size() - 1 - i));
					}
					else
					{
						partido = new Partido(equipos.get(equipos.size() - 1 - i), equipos.get(i));
					}
					jornada.aniadirPartido(partido);
				}
				jornadas.add(jornada);
				numJornada++;
				Collections.rotate(equipos.subList(1, equipos.size()), 1);
			}
		}

		return (jornadas);
	}

    public void BienvenidoAlSimulador() //Esto en un bucle para ver que has elegido una de las 4 opciones.
    {
        System.out.println(PrintTexto.BOLD + PrintTexto.WHITE + "\nBIENVENIDO AL SIMULADOR DE LA XTART LEAGUE");
        System.out.println( PrintTexto.YELLOW + "\nSELECCIONA UNA OPCIÓN PARA COMENZAR TU AVENTURA Y DISFRUTAR DE NUESTRA LIGA " + this.nombre.toUpperCase());
        System.out.println(PrintTexto.CYAN + "1. Ver Clasificación");
        System.out.println(PrintTexto.GREEN + "2. Simular Jornada");
        System.out.println(PrintTexto.PURPLE + "3. Ver Jornadas");
        System.out.println(PrintTexto.RED + "4. Ver equipos");
        System.out.println(PrintTexto.BOLD + "5. Salir");
        System.out.print(PrintTexto.RESET + "Elige una opción: ");
    }

    public  void verClasificacion(int numJornada)
    {
        Collections.sort(this.equipos, new Comparator<Equipo>() {
            @Override
            public int compare(Equipo p1, Equipo p2) {
                return new Integer(p2.getPuntos()).compareTo(new Integer(p1.getPuntos()));
            }
        });

        int i = 1;

        System.out.println(PrintTexto.BLUE + "---------------------------");
        System.out.println(PrintTexto.RED + "Clasificación Jornada " + numJornada + " Liga " + this.nombre.toUpperCase());
        System.out.println(PrintTexto.YELLOW + "----- EQUIPOS ---------------- PT--------------");

        for (Equipo equipo : this.equipos) 
        {
            System.out.println(PrintTexto.CYAN + i + ". " + equipo.getNombre() + "-------------" + equipo.getPuntos());
            i++; 
        }

        System.out.println(PrintTexto.BLUE + "---------------------------");
    }
        

    public void verEquipos(ArrayList<Equipo> equipos) 
    {
        System.out.println(PrintTexto.BLUE + "-----------------------" );
        System.out.println(PrintTexto.BLUE + "-----------------------");
        System.out.println(PrintTexto.YELLOW + "Equipos de la liga " );
        System.out.println(PrintTexto.BLUE + "-----------------------" );
        System.out.println(PrintTexto.BLUE + "-----------------------" );

        for (Equipo equipo : equipos) {
            System.out.println(PrintTexto.GREEN + "-----------------------" );
            System.out.println(PrintTexto.CYAN + equipo.getNombre() + PrintTexto.RESET + PrintTexto.RED + " media del equipo: " + equipo.getMediaStats());
        }
    }

    public  ArrayList<Equipo>  crearArrayEquipos(String[] equipos, boolean mundial)
	{
        Equipo equipoAux = new Equipo();
        ArrayList<Equipo> equiposLiga = new ArrayList<>();
        int i = 0;

		for (String equipo: equipos)
		{
            if (mundial)
            {
                i++;
            }
            equiposLiga.add(equipoAux.crearEquipo(equipo, i));
            
		}
		return equiposLiga;
	}

    public  void menuVariasLigas(int numJornada) 
    {
        int opcion;
        ArrayList<Equipo> equiposClasificacion;

        do {
            if (numJornada == this.jornadas.size())
            {
                opcion = 5;
                System.out.println("-----------------------");
                System.out.println("-----------------------");
                System.out.println("La liga "+ this.nombre.toUpperCase() +" ha acabado.");
                equiposClasificacion = this.getEquipos();
                verClasificacion( numJornada);
                System.out.println("-----------------------");
            }
            else
            {
                BienvenidoAlSimulador();
                opcion = GestionNumero.gestionNumero();
            }
            switch (opcion) 
            {
                case 1:
                    //Ver Clasificacion
                    equiposClasificacion = this.getEquipos();
                    verClasificacion(numJornada);
                    break;
                case 2:
                    //Simular Jornada
                    this.getJornadas().get(numJornada).simularJornada();
                    break;
                case 3:
                //Imprimir jornadas
                    this.imprimirJornadas(jornadas);
                    break ;
                case 4:
                //Ver equipos y sus medias
                    verEquipos(this.getEquipos());
                    break ;
                case 5:
                    //Salir
                    break ;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
                    break ;
            }
        } while (opcion != 5 && opcion != 2);
    }


    public  void menuLiga() 
    {
        int opcion;
        int numJornada;
        ArrayList<Equipo> equiposClasificacion;

        numJornada = 0;
        do {
            if (numJornada == this.jornadas.size())
            {
                opcion = 5;
                System.out.println("-----------------------");
                System.out.println("-----------------------");
                System.out.println("La liga ha acabado.");
                equiposClasificacion = this.getEquipos();
                verClasificacion( numJornada);
                System.out.println("-----------------------");
            }
            else
            {
                BienvenidoAlSimulador();
                opcion = GestionNumero.gestionNumero();
            }
            switch (opcion) 
            {
                case 1:
                    //Ver Clasificacion
                    equiposClasificacion = this.getEquipos();
                    verClasificacion( numJornada);
                    break;
                case 2:
                    //Simular Jornada
                    this.getJornadas().get(numJornada).simularJornada();
                    numJornada++;
                    break;
                case 3:
                //Imprimir jornadas
                    this.imprimirJornadas(jornadas);
                    break ;
                case 4:
                //Ver equipos y sus medias
                    verEquipos(this.getEquipos());
                    break ;
                case 5:
                    //Salir
                    break ;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
                    break ;
            }
        } while (opcion!=5);
    }

    public int eliminatiroaMundial(int index1, int index2, int numPuntos, Partido partidoAux)
    {
        int equipoGanador;
        equipoGanador = 0;
        if (numPuntos == (this.equipos.get(index1).getPuntos()))
        {
            System.out.println("Gano Equipo " + index2);
            equipoGanador = index2;
        }
        else if ((numPuntos + 1) == this.equipos.get(index1).getPuntos())
        {
            System.out.println("Hubo empate, ir a penaltis");
            //Funcion penaltis
            equipoGanador = partidoAux.simularPenaltis(index1, index2);
        }
        else
        {
            System.out.println("Gano equipo " + index1);
            equipoGanador = index1;
        }
        return equipoGanador;
    }
    public void eliminatorias()
    {
        int numPuntos1 = this.equipos.get(0).getPuntos();
        int numPuntos2 = this.equipos.get(1).getPuntos();
        int[] indexGanadores = new int[2];
        Partido partidoaux;

        System.out.println("prueba a ver que equipos juegan y si esta bien:");
        System.out.println("SEMIFINALES");
        System.out.println("Equipo 1: " +this.equipos.get(0).getNombre() +" vs Equipo 4: " + this.equipos.get(3).getNombre());
        partidoaux = new Partido(this.equipos.get(0), this.equipos.get(3));
        partidoaux.simularPartido();
        indexGanadores[0] = eliminatiroaMundial(0,3, numPuntos1, partidoaux);
        System.out.println("SEMIFINALES");
        System.out.println("Equipo 2: " +this.equipos.get(1).getNombre() +" vs Equipo 3: " + this.equipos.get(2).getNombre());
        partidoaux = new Partido(this.equipos.get(1), this.equipos.get(2));
        partidoaux.simularPartido();
        indexGanadores[1] = eliminatiroaMundial(1,2, numPuntos1, partidoaux);
        System.out.println("FINAL");
        System.out.println("Equipo : " +this.equipos.get(indexGanadores[0]).getNombre() +" vs Equipo : " + this.equipos.get(indexGanadores[1]).getNombre());
        partidoaux = new Partido(this.equipos.get(indexGanadores[0]), this.equipos.get(indexGanadores[1]));
        partidoaux.simularPartido();
        numPuntos1 = this.equipos.get(indexGanadores[0]).getPuntos();
        indexGanadores[0] = eliminatiroaMundial(indexGanadores[0], indexGanadores[1], numPuntos1, partidoaux);
    }
}