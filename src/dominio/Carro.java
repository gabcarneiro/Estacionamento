package dominio;

public class Carro extends Veiculo {

    public Carro(String placa, String modelo, String nome, String cpf) {
        super(placa, modelo, nome, cpf);
        this.valorHora = 2.5;
    }

    public boolean estacionar(Estacionamento est, int horaEntrada) {
        boolean estacionado = false;
        int i = 0;

        while (i < est.vagas.length && !estacionado) {
            if (est.vagas[i][0].veiculo == null && est.vagas[i][1].veiculo == null) {
                est.vagas[i][0].veiculo = this;
                est.vagas[i][1].veiculo = this;
                est.vagas[i][0].setHoraEntrada(horaEntrada);
                est.vagas[i][1].setHoraEntrada(horaEntrada);
                estacionado =true;
                est.setOcupacao(est.getOcupacao() + 1);
            }
            i++;
        }
        return estacionado ;
    }

    @Override
    public int realizarCheckOut(Estacionamento est, int horaSaida) {
        int horaEntrada =0;
        int i = 0;

        while (i < est.vagas.length) {
            if (est.vagas[i][0].veiculo == this && est.vagas[i][1].veiculo == this) {
                horaEntrada= est.vagas[i][0].getHoraEntrada();
                est.vagas[i][0].veiculo = null;
                est.vagas[i][1].veiculo = null;
                
                est.setOcupacao(est.getOcupacao() - 1);
                i=est.vagas.length;
                
            }
            i++;
        }
        return horaEntrada ;
    }

}
