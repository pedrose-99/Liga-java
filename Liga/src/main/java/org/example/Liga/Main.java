package org.example.Liga;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import org.example.Liga.liga.Equipo;
import org.example.Liga.liga.Liga;
import com.github.javafaker.Faker;

public class Main {
    public static void opcionesLiga() {
        System.out.println(PrintTexto.RED + "\nBIENVENIDO AL SIMULADOR DE LA XTART LEAGUE" + PrintTexto.RESET);
        System.out.println(PrintTexto.GREEN + "\nSELECCIONA UNA OPCIÓN PARA COMENZAR TU AVENTURA Y DISFRUTAR DE NUESTRA LIGA MIXTA" + PrintTexto.RESET);
        System.out.println(PrintTexto.YELLOW + "1. Jugar con una liga" + PrintTexto.RESET);
        System.out.println(PrintTexto.BLUE + "2. Jugar con varias ligas" + PrintTexto.RESET);
        System.out.println(PrintTexto.PURPLE + "3. Salir" + PrintTexto.RESET);
        System.out.print(PrintTexto.CYAN + "Elige una opción: " + PrintTexto.RESET);
    }

    public static void main(String[] args) {
        String[] equipos1 = {
            "Barcelona", "Real Madrid", "Atletico de Madrid", "Sevilla", "Valencia", 
            "Villarreal", "Real Sociedad", "Betis", "Athletic Bilbao", "Getafe", 
            "Espanyol", "Osasuna", "Alavés", "Levante", "Celta de Vigo", 
            "Granada", "Cadiz", "Elche", "Mallorca", "Rayo Vallecano"
        };
        
        int opcion;
        
        do {
            opcionesLiga();
            opcion = GestionNumero.gestionNumero();
            switch (opcion) {
                case 1:
                    System.out.println(PrintTexto.GREEN + "Iniciando la liga..." + PrintTexto.RESET);
                    Liga liga = new Liga(equipos1);
                    liga.menuLiga();
                    break;
                case 2:
                    System.out.println(PrintTexto.GREEN + "Iniciando varias ligas..." + PrintTexto.RESET);
                    VariasLigas.jugarConVariasLigas();
                    break;
                case 3:
                    System.out.println(PrintTexto.RED + "Saliendo del simulador. ¡Hasta la próxima!" + PrintTexto.RESET);
                    break;
                default:
                    System.out.println(PrintTexto.RED + "Opción no válida, intenta de nuevo." + PrintTexto.RESET);
                    break;
            }
        } while (opcion != 3);
    }
}