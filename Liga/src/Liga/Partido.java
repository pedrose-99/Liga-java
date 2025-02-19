package Liga;

public class Partido {
    String equipolocal;
    String equipovisitante;
    int resultado;
    int numgoles;
    void simularpartidos(int Partido){

}
    public Partido(String equipolocal, String equipovisitante, int resultado, int numgoles) {
        this.equipolocal = equipolocal;
        this.equipovisitante = equipovisitante;
        this.resultado = resultado;
        this.numgoles = numgoles;
    }
    public String getEquipolocal() {
        return equipolocal;
    }
    public void setEquipolocal(String equipolocal) {
        this.equipolocal = equipolocal;
    }
    public String getEquipovisitante() {
        return equipovisitante;
    }
    public void setEquipovisitante(String equipovisitante) {
        this.equipovisitante = equipovisitante;
    }
    public int getResultado() {
        return resultado;
    }
    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
    public int getNumgoles() {
        return numgoles;
    }
    public void setNumgoles(int numgoles) {
        this.numgoles = numgoles;
    }

    
}