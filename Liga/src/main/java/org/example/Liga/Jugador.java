package org.example.Liga;

public class Jugador extends Persona
{
    private int goles;
    private Posicion posicion;
    private int tarjetasAmarillas;
    private int tarjetasRojas;
    private int stats;

    public Jugador(String nombre, String apellido, Continente continente, int stats, Posicion posicion)
    {
        super(nombre, apellido, continente);
        this.goles = 0;
        this.tarjetasAmarillas = 0;
        this.tarjetasRojas = 0;
        this.stats = stats;
        this.posicion = posicion;
    }

    public Jugador(String nombre, String apellido, Continente continente, int goles, Posicion posicion, int tarjetasAmarillas, int tarjetasRojas, int stats) 
    {
        super(nombre, apellido, continente);
        this.goles = goles;
        this.posicion = posicion;
        this.tarjetasAmarillas = tarjetasAmarillas;
        this.tarjetasRojas = tarjetasRojas;
        this.stats = stats;
    }

    public int getGoles() 
    {
        return goles;
    }

    public void setGoles(int goles) 
    {
        this.goles = goles;
    }

    public Posicion getPosicion() 
    {
        return posicion;
    }

    public void setPosicion(Posicion posicion) 
    {
        this.posicion = posicion;
    }

    public int getTarjetasAmarillas() 
    {
        return tarjetasAmarillas;
    }

    public void setTarjetasAmarillas(int tarjetasAmarillas) 
    {
        this.tarjetasAmarillas = tarjetasAmarillas;
    }

    public int getTarjetasRojas() 
    {
        return tarjetasRojas;
    }

    public void setTarjetasRojas(int tarjetasRojas) 
    {
        this.tarjetasRojas = tarjetasRojas;
    }

    public int getStats() 
    {
        return stats;
    }

    public void setStats(int stats) 
    {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "Jugador [nombre= " + super.getNombre() + " apellido= " + super.getApellido() + " continente= " + super.getContinente() +" goles=" + goles + ", posicion=" + posicion + ", tarjetasAmarillas=" + tarjetasAmarillas
                + ", tarjetasRojas=" + tarjetasRojas + ", stats=" + stats + "] \n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Jugador other = (Jugador) obj;
        if (goles != other.goles)
            return false;
        if (posicion != other.posicion)
            return false;
        if (tarjetasAmarillas != other.tarjetasAmarillas)
            return false;
        if (tarjetasRojas != other.tarjetasRojas)
            return false;
        if (stats != other.stats)
            return false;
        return true;
    }

    

    
}
