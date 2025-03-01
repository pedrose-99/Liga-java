package org.example.Liga;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import org.example.Liga.liga.Equipo;
import org.example.Liga.liga.Liga;

import com.github.javafaker.Faker;

public class Main
{
	public static void opcionesLiga()
	{
		System.out.println("\nBIENVENIDO AL SIMULADOR DE LA XTART LEAGUE");
        System.out.println("\nSELECCIONA UNA OPCIÓN PARA COMENZAR TU AVENTURA Y DISFRUTAR DE NUESTRA LIGA MIXTA");
        System.out.println("1. Jugar con una liga");
        System.out.println("2. Jugar con varias ligas");
        System.out.println("3. Salir");
        System.out.print("Elige una opción: ");
	}

	public static void main(String[] args)
	{
		String[] equipos1 = {"Barcelona", "Real Madrid", "Atletico de Madrid", "Sevilla", "Valencia", "Villarreal", "Real Sociedad", "Betis", "Athletic Bilbao", "Getafe", "Espanyol", "Osasuna", "Alavés", "Levante", "Celta de Vigo", "Granada", "Cadiz", "Elche", "Mallorca", "Rayo Vallecano"};
        int opcion;
		int numJornadaLiga = 0;
		int numJornadaPremier = 0;

        do {
			opcionesLiga();
			opcion = GestionNumero.gestionNumero();
            switch (opcion) 
            {
                case 1:
                    //Jugar con una liga
					Liga liga = new Liga(equipos1);
					liga.menuLiga();
                    break;
                case 2:
					//Jugar con varias ligas
					VariasLigas.jugarConVariasLigas();
                    break;
                case 3:
                //Salir
                    break ;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
                    break ;
            }
        } while (opcion != 3);


	}

}
