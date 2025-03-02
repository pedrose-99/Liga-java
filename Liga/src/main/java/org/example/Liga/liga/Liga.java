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

import com.github.javafaker.Faker;

public class Liga 
{
    private String nombre;
    private ArrayList<Equipo> equipos = new ArrayList<>();
    private ArrayList<Jornada> jornadas = new ArrayList<>();


    public Liga(String[] equipos)
    {
        Faker fakerEs = new Faker(new Locale("es"));
        this.nombre = fakerEs.pokemon().name();
        this.equipos = this.crearArrayEquipos(equipos);
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

	public void imprimirJornadas(ArrayList<Jornada> jornadas)
	{
		for (Jornada jornadaPrueba : jornadas)
		{
			System.out.println("--------------------------------------------------------------");
			System.out.println("JORNADA " + jornadaPrueba.getNumJornada());
			for (Partido partidoPrueba : jornadaPrueba.getPartidos())
			{
				System.out.println(partidoPrueba.getEquipoLocal().getNombre() + " vs " + partidoPrueba.getEquipoVisitante().getNombre());
			}
			System.out.println("--------------------------------------------------------------");
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
				Collections.rotate(equipos.subList(1, 20), 1);
			}
		}

		return (jornadas);
	}

    public void BienvenidoAlSimulador() //Esto en un bucle para ver que has elegido una de las 4 opciones.
    {
        System.out.println("\nBIENVENIDO AL SIMULADOR DE LA XTART LEAGUE");
        System.out.println("\nSELECCIONA UNA OPCIÓN PARA COMENZAR TU AVENTURA Y DISFRUTAR DE NUESTRA LIGA " + this.nombre.toUpperCase());
        System.out.println("1. Ver Clasificación");
        System.out.println("2. Simular Jornada");
        System.out.println("3. Ver Jornadas");
        System.out.println("4. Ver equipos");
        System.out.println("5. Salir");
        System.out.print("Elige una opción: ");
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

for (Equipo equipo : this.equipos) {
    System.out.println(PrintTexto.CYAN + i + ". " + equipo.getNombre() + "-------------" + equipo.getPuntos());
    i++; 
}

System.out.println(PrintTexto.BLUE + "---------------------------");
}
        

public void verEquipos(ArrayList<Equipo> equipos) {
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

    public  ArrayList<Equipo>  crearArrayEquipos(String[] equipos)
	{
        Equipo equipoAux = new Equipo();
        ArrayList<Equipo> equiposLiga = new ArrayList<>();

		for (String equipo: equipos)
		{
            equiposLiga.add(equipoAux.crearEquipo(equipo));
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
}