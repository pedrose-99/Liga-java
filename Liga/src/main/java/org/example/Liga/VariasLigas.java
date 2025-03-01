package org.example.Liga;

import java.util.ArrayList;

import org.example.Liga.liga.Liga;

import com.github.javafaker.Faker;

public class VariasLigas 
{
    public static String[] generarEquipos()
	{
		String[] equipos = new String[20];
		Faker faker = new Faker();

		for (int i = 0; i < 20; i++)
		{
			equipos[i] = faker.team().name();

		}
		return equipos;
	}

	public static void simularJornadas(ArrayList<Liga> ligas, int numJornada)
	{
		for(Liga liga : ligas)
		{
			liga.menuVariasLigas(numJornada);
		}
	}

	public static void verClasificaciones(ArrayList<Liga> ligas, int numJornada)
	{
		for(Liga liga : ligas)
		{
			liga.verClasificacion(numJornada);
		}
	}

	public static void opcionesVariasLigas()
	{
		System.out.println("\nBIENVENIDO AL SIMULADOR DE LA XTART LEAGUE");
        System.out.println("\nSELECCIONA UNA OPCIÓN PARA COMENZAR TU AVENTURA Y DISFRUTAR DE NUESTRA LIGA MIXTA");
        System.out.println("1. Ver clasificaciones");
        System.out.println("2. Simular Jornadas");
        System.out.println("3. Ver equipos");
		System.out.println("4. Salir");
        System.out.print("Elige una opción: ");
	}


	public static void verMediaEquipos(ArrayList<Liga> ligas)
	{
		for(Liga liga : ligas)
		{
			liga.verEquipos(liga.getEquipos());
		}
	}

	public static void jugarConVariasLigas()
	{
		int opcion;
		int numJornada;
		ArrayList<Liga> ligas = new ArrayList<>();

		System.out.print("Con cuantas ligas quieres jugar?: ");
		opcion = GestionNumero.gestionNumero();
		numJornada = 0;
		for (int i = 0; i < opcion; i++)
		{
			ligas.add(new Liga(generarEquipos()));
		}

		do {
			opcionesVariasLigas();
			opcion = GestionNumero.gestionNumero();
            switch (opcion) 
            {
                case 1:
					//Ver clasificaciones
					verClasificaciones(ligas, numJornada);
                    break;
                case 2:
					//Simular Jornadas
					simularJornadas(ligas, numJornada);
					numJornada++;
                    break;
                case 3:
					//Ver medias Equipos
					verMediaEquipos(ligas);
                	//Salir
				case 4:
					//Salir
                    break ;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
                    break ;
            }
        } while (opcion != 4);
	}

}
