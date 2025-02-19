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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Continente getContinente() {
        return continente;
    }

    public void setContinente(Continente continente) {
        this.continente = continente;
    }

    
    

}
