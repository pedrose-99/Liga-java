package org.example;
import com.github.javafaker.*;

public class Main
{
	public static void main(String[] args)
	{
		Faker faker = new Faker();

		String firstName = faker.name().firstName(); // Emory
		String lastName = faker.name().lastName(); // Barton

		System.out.println(firstName + " " + lastName);
	}
}