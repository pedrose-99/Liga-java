package Liga;
import java.util.List;

public class Jornada {
    private int numerojornada;
    private List <Partido> partidos;


    public Jornada(int numerojornada, List<Partido> partidos) {
        this.numerojornada = numerojornada;
        this.partidos = partidos;
    }

    public int getNumerojornada() {
        return numerojornada;
    }
    public void setNumerojornada(int numerojornada) {
        this.numerojornada = numerojornada;
    }
    public List<Partido> getPartidos() {
        return partidos;
    }
    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    



    
    
}
