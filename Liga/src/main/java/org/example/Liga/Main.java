package org.example.Liga;

import com.github.javafaker.*;
import java.util.Locale;
import java.util.Random;


public class Main
{
	public static Jugador crearJugador()
	{
		Random ran = new Random();
		String firstName;
		String lastName;
		int media;
		Faker fakerEs = new Faker(new Locale("es"));
		Faker fakerEn = new Faker(Locale.ENGLISH);
		Faker fakerAs = new Faker(Locale.JAPAN);
		Faker fakerAF = new Faker(new Locale("en", "NG"));
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
				firstName = fakerEs.name().firstName();
				lastName = fakerEs.name().lastName();
				dado1 = ran.nextInt(99);
				continente = Continente.NORTEAMERICA;
				break;
			case 4:
			//HAcer JAVAFAKER SUDAMERICA
				firstName = fakerEs.name().firstName();
				lastName = fakerEs.name().lastName();
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
		jugador = new Jugador(firstName, lastName, continente, dado1);
		return jugador;
	}

	public static void crearEquipo()
	{

	}

	public static void main(String[] args)
	{
		Faker fakerEs = new Faker(new Locale("es"));
		Faker fakerEn = new Faker(Locale.ENGLISH);
		Faker fakerCh = new Faker(Locale.JAPAN);
		Faker fakerAF = new Faker(new Locale("en", "NG"));


		String firstName = fakerEs.name().firstName();
		String lastName = fakerEs.name().lastName();

		System.out.println("Nombre español: "+ firstName + " " + lastName);

		firstName = fakerEn.name().firstName();
		lastName = fakerEn.name().lastName();

		System.out.println("Nombre Ingles: "+ firstName + " " + lastName);

		firstName = fakerCh.name().firstName();
		lastName = fakerCh.name().lastName();

		System.out.println("Nombre Japon: "+ firstName + " " + lastName);

		firstName = fakerAF.name().firstName();
		lastName = fakerAF.name().lastName();

		System.out.println("Nombre Africano: "+ firstName + " " + lastName);
		Jugador jugadorPrueba = crearJugador();
		System.out.println("EL jugador es: " + jugadorPrueba);
	}
}
