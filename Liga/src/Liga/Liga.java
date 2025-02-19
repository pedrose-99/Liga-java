package Liga;
import java.util.List;
import Entidades.Equipo;

public class Liga {
    String nombre;
    List<Equipo> equipos;
    List<Jornada> jornadas;

    
    public Liga(String nombre, List<Equipo> equipos, List<Jornada> jornadas) {
        this.nombre = nombre;
        this.equipos = equipos;
        this.jornadas = jornadas;
    }
}


