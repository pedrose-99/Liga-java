package org.example.Liga;
import java.util.Scanner;

public class Menu 

{
    public void funcionVerLigas()
    {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        opcion = teclado.nextInt();

        switch (opcion) 
        {
            case 1:
                
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:
            
                break;
        
            default:
                break;
        }
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
                    funcionVerLigas();
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
    