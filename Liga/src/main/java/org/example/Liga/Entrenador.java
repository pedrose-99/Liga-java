package org.example.Liga;

public class Entrenador extends Persona 
{
    private int experiencia;


    public Entrenador(String nombre, String apellido, Continente continente, int experiencia)
    {
        super(nombre, apellido, continente);
        this.experiencia = experiencia;

    }
}