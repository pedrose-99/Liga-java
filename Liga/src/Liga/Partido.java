package Liga;

public class Partido {
    int equipolocal;
    int equipovisitante;
    int resultado;
    int numgoles;
    void simularpartidos(int Partido){

}
    public Partido(int equipolocal, int equipovisitante, int resultado, int numgoles) {
        this.equipolocal = equipolocal;
        this.equipovisitante = equipovisitante;
        this.resultado = resultado;
        this.numgoles = numgoles;
    }
    public int getEquipolocal() {
        return equipolocal;
    }
    public void setEquipolocal(int equipolocal) {
        this.equipolocal = equipolocal;
    }
    public int getEquipovisitante() {
        return equipovisitante;
    }
    public void setEquipovisitante(int equipovisitante) {
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