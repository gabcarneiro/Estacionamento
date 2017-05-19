package dominio;

public class Vaga {

    Veiculo veiculo;
    private int horaEntrada;
    
    public Vaga(){
        this.veiculo=null;
        this.horaEntrada=0;
    }
    
    public int getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(int horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    @Override
    public String toString() {
        return "Vaga{" + "veiculo=" + veiculo + ", horaEntrada=" + horaEntrada + '}';
    }
    
}
