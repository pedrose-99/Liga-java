package org.example;
import com.github.javafaker.*;

import java.util.Locale;

public class Main
{
	public static void main(String[] args)
	{

		Faker fakerEs = new Faker(new Locale("es"));
		Faker fakerEn = new Faker(Locale.ENGLISH);
		Faker fakerCh = new Faker(new Locale("hi", "IN"));
		Faker fakerAF = new Faker(new Locale("en", "NG"));


		String firstName = fakerEs.name().firstName();
		String lastName = fakerEs.name().lastName();

		System.out.println("Nombre español: "+ firstName + " " + lastName);

		firstName = fakerEn.name().firstName();
		lastName = fakerEn.name().lastName();
		
		System.out.println("Nombre Ingles: "+ firstName + " " + lastName);

		firstName = fakerCh.name().firstName();
		lastName = fakerCh.name().lastName();
		
		System.out.println("Nombre Indio: "+ firstName + " " + lastName);

		firstName = fakerAF.name().firstName();
		lastName = fakerAF.name().lastName();
		
		System.out.println("Nombre Africano: "+ firstName + " " + lastName);
	}
}