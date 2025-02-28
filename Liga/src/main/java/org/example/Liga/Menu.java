package org.example.Liga;
import java.util.Scanner;

public class Menu 

{
    public void funcionVerLiga()
    {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        opcion = teclado.nextInt();

        switch (opcion) 
        {
            case 1:
                System.out.println();
                break;
            case 2:
                verNombresEquipos();
                break;
            default:
                break;
        }
    }
    public void verNombresEquipos()
    {

    }

    public void BienvenidoAlSimulador()
    {
        System.out.println("\nBIENVENIDO AL SIMULADOR DE LA XTART LEAGUE");
        System.out.println("\nSELECCIONA UNA OPCIÓN PARA COMENZAR TU AVENTURA Y DISFRUTAR DE NUESTRA LIGA MIXTA");
        System.out.println("1. Ver ligas");
        System.out.println("2. Salir");
        System.out.print("Elige una opción: ");
    }

    public void menuLiga()
    {
        
        Scanner teclado = new Scanner(System.in);
        int opcion;
    
        do {
            BienvenidoAlSimulador();

            opcion = teclado.nextInt();
            
            switch (opcion) 
            {
                case 1:
                    //Ver ligas
                    funcionVerLiga();
                    break;
                case 2:
                    //Salir
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        } while (opcion != 2);

        teclado.close(); 
    }
}
    