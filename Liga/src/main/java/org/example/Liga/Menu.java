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

    public static void BienvenidoAlSimulador() //Esto en un bucle para ver que has elegido una de las 4 opciones.
    {
        System.out.println("\nBIENVENIDO AL SIMULADOR DE LA XTART LEAGUE");
        System.out.println("\nSELECCIONA UNA OPCIÓN PARA COMENZAR TU AVENTURA Y DISFRUTAR DE NUESTRA LIGA MIXTA");
        System.out.println("1. Ver Clasificación");
        System.out.println("2. Simular Jornada");
        System.out.println("3. Ver máximos goleadores");
        System.out.println("4. Salir");
        System.out.print("Elige una opción: ");
    }

    public static void menuLiga(Liga liga)
    {
        
        Scanner teclado = new Scanner(System.in);
        int opcion;
    
        do {
            BienvenidoAlSimulador();
            opcion = teclado.nextInt(); //Gestion getNumero(mirar mi proyecto de aeropuerto)
            
            switch (opcion) 
            {
                case 1:
                    //Ver Clasificacion
                    
                    break;
                case 2:
                    //Simular Jornada
                    liga.getJornadas().get(1).simularJornada();
                    break;
                case 3:
                    //Ver maximos goleadores.
                    break ;
                case 4:
                    //Salir;
                    break ;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
                    break ; //No se si se tiene que poder
            }
        } while (opcion != 4);

        teclado.close(); 
    }
}
    