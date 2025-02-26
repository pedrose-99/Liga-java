package org.example.Liga;

import com.github.javafaker.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Main
{
	public static Jugador crearJugador(Posicion posicion)
	{
		Random ran = new Random();
		String firstName;
		String lastName;
		int media;
		Faker fakerEs = new Faker(new Locale("es"));
		Faker fakerEn = new Faker(Locale.ENGLISH);
		Faker fakerAs = new Faker(Locale.JAPAN);
		Faker fakerAF = new Faker(new Locale("en", "NG"));
		Faker fakerCN = new Faker(Locale.CANADA_FRENCH);
		Faker fakerBR = new Faker(new Locale("pt-BR"));
		int dado1;
		Jugador jugador;
		Continente continente;

		dado1 = ran.nextInt(6);
		switch (dado1) {
			case 1:
				firstName = fakerEs.name().firstName();
				lastName = fakerEs.name().lastName();
				dado1 = ran.nextInt(99);
				continente = Continente.EUROPA;
				break;
			case 2:
				firstName = fakerAs.name().firstName();
				lastName = fakerAs.name().lastName();
				dado1 = ran.nextInt(99);
				continente = Continente.ASIA;
				break;			
			case 3:
			//HACER JAVAFAKER FRANCES
				firstName = fakerCN.name().firstName();
				lastName = fakerCN.name().lastName();
				dado1 = ran.nextInt(99);
				continente = Continente.NORTEAMERICA;
				break;
			case 4:
			//HAcer JAVAFAKER SUDAMERICA
				firstName = fakerBR.name().firstName();
				lastName = fakerBR.name().lastName();
				dado1 = ran.nextInt(99);
				continente = Continente.SUDAMERICA;
				break;
			
			case 5:
				firstName = fakerAF.name().firstName();
				lastName = fakerAF.name().lastName();
				dado1 = ran.nextInt(99);
				continente = Continente.AFRICA;
				break;
			
			default:
				firstName = fakerEn.name().firstName();
				lastName = fakerEn.name().lastName();
				dado1 = ran.nextInt(99);
				continente = Continente.OCEANIA;
				break;
		}
		jugador = new Jugador(firstName, lastName, continente, dado1, posicion);
		return jugador;
	}

	public static Equipo crearEquipo(String nombre)
	{
		int i;
		Equipo equipoPrueba;
		Jugador[] jugadores = new Jugador[25];

		i = 0;
		jugadores[i] = crearJugador(Posicion.PORTERO);
		i++;
		while (i <= 4)
		{
			jugadores[i] = crearJugador(Posicion.DEFENSA);
			i++;
		}
		while (i <= 18)
		{
			jugadores[i] = crearJugador(Posicion.MEDIOCAMPISTA);
			i++;
		}
		while (i <= 24)
		{
			jugadores[i] = crearJugador(Posicion.DELANTERO);
			i++;
		}
		equipoPrueba = new Equipo(nombre, jugadores);
		equipoPrueba.calcularMediaEquipo();

		return (equipoPrueba);
	}

	public static Equipo[] crearLiga()
	{
		Equipo[] arrayEquipos = new Equipo[20];
		int i;

		i = 0;
        String[] equipos = {
            "Real Madrid",
            "Barcelona",
            "Atlético de Madrid",
            "Sevilla",
            "Valencia",
            "Villarreal",
            "Real Sociedad",
            "Betis",
            "Athletic Bilbao",
            "Getafe",
            "Espanyol",
            "Osasuna",
            "Alavés",
            "Levante",
            "Celta de Vigo",
            "Granada",
            "Cadiz",
            "Elche",
            "Mallorca",
            "Rayo Vallecano"
        };
		for (String equipo: equipos)
		{
			arrayEquipos[i] = crearEquipo(equipo);
			i++;
		}
		return arrayEquipos;
	}

	public static void generarCalendario()
	{
		Equipo[] liga = crearLiga();

		List<Equipo> ligaCopia = new ArrayList<>(Arrays.asList(liga));
		for (int j = 0; j < (ligaCopia.size() - 1); j++)
		{
			for (int i = 0; i < (ligaCopia.size()/2); i++)
			{
				
			}
		}
			Collections.rotate(ligaCopia.subList(1, 20), 1);

	}

	public static void main(String[] args)
	{
		
		generarCalendario();
	}
}
