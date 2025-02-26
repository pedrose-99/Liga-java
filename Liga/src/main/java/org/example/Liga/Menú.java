package org.example.Liga;
import java.util.Scanner;

public class Menú 

{
    public void menuLiga()
    {
        
        Scanner teclado = new Scanner(System.in);
        int opcion;
    
        do {
            System.out.println("\nBIENVENIDO AL SIMULADOR DE LA XTART LEAGUE");
            System.out.println("\nSELECCIONA UNA OPCIÓN PARA COMENZAR TU AVENTURA Y DISFRUTAR DE NUESTRA LIGA MIXTA");
            System.out.println("1. Saludar");
            System.out.println("2. Mostrar la fecha actual");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = teclado.nextInt();
            
            switch (opcion) 
            {
                case 1:
                    //Empezar liga
                    break;
                case 2:
                    //Consultar equipos
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        } while (opcion != 2);

        teclado.close(); 
    }
}
    