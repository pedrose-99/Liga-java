package Humano;

public class Persona 
{
    private String nombre;
    private String apellido;
    private int edad;
    private Continente continente;
    
    public Persona(String nombre, String apellido, int edad, Continente continente)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.continente = continente;
    }
    
}
