package org.example.Liga;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        System.out.println("4. Ver equipos");
        System.out.println("5. Salir");
        System.out.print("Elige una opción: ");
    }

    public static void verClasificacion(ArrayList<Equipo> equipos, int numJornada)
    {
        Collections.sort(equipos, new Comparator<Equipo>() {
            @Override
            public int compare(Equipo p1, Equipo p2) {
                return new Integer(p2.getPuntos()).compareTo(new Integer(p1.getPuntos()));
            }
        });

        int i;

        i = 1;
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        System.out.println("Clasificación Jornada " + numJornada);
        System.out.println("----- EQUIPOS ---------------- PT--------------");
        for (Equipo equipo: equipos)
        {
            System.out.println(i + ". " + equipo.getNombre() + "-------------" + equipo.getPuntos());
            i++;
        }
        System.out.println("---------------------------");
        System.out.println("---------------------------");
    }

    public static void verEquipos(ArrayList<Equipo> equipos)
    {
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("Equipos de la liga");
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        for(Equipo equipo : equipos)
        {
            System.out.println("-----------------------");
            System.out.println(equipo.getNombre() + " media del equipo: " + equipo.getMediaStats());
        }
    }

    public static void menuLiga(Liga liga) //Seguramente ira dentro de la clase Liga.
    {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        int numJornada;
        ArrayList<Equipo> equiposClasificacion;

        numJornada = 0;
        do {
            BienvenidoAlSimulador();
            opcion = GestionNumero.gestionNumero(); //Gestion getNumero(mirar mi proyecto de aeropuerto)
            
            switch (opcion) 
            {
                case 1:
                    //Ver Clasificacion
                    equiposClasificacion = liga.getEquipos();
                    verClasificacion(equiposClasificacion, numJornada);
                    break;
                case 2:
                    //Simular Jornada
                    liga.getJornadas().get(numJornada).simularJornada();
                    numJornada++;
                    break;
                case 3:
                    //Ver maximos goleadores
                    break ;
                case 4:
                    verEquipos(liga.getEquipos());
                    break ;
                case 5:
                    //Salir
                    break ;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
                    break ; //No se si se tiene que poder
            }
        } while (opcion != 5);

        teclado.close(); 
    }
}
