package dominio;

public class Moto extends Veiculo {

    public Moto(String placa, String modelo, String nome, String cpf) {
        super(placa, modelo, nome, cpf);
        this.valorHora = 1.5;
    }

    @Override
    public boolean estacionar(Estacionamento est, int horaEntrada) {
        boolean estacionado = procuraVagaComMoto(est, horaEntrada);

        int i = 0;

        while (i < est.vagas.length && !estacionado) {
            int j = 0;
            while (j < est.vagas[i].length && !estacionado) {
                if (est.vagas[i][j].veiculo == null) {
                    est.vagas[i][j].veiculo = this;
                    est.vagas[i][j].setHoraEntrada(horaEntrada);
                    estacionado = true;
                    est.setOcupacao(est.getOcupacao() + 1);
                }
                j++;
            }
            i++;
        }
        return estacionado;
    }

    public boolean procuraVagaComMoto(Estacionamento est, int horaEntrada) {
        boolean estacionado = false;
        int i = 0;

        while (i < est.vagas.length && !estacionado) {

            int contDeVagasVazias = 0;

            for (int j = 0; j < est.vagas[i].length; j++) {
                if (est.vagas[i][j].veiculo == null) {
                    contDeVagasVazias++;
                }
            }

            if (contDeVagasVazias == 1) {
                int j = 0;
                while (j < est.vagas[i].length && !estacionado) {
                    if (est.vagas[i][j].veiculo == null) {
                        est.vagas[i][j].veiculo = this;
                        est.vagas[i][j].setHoraEntrada(horaEntrada);
                        estacionado = true;
                        est.setOcupacao(est.getOcupacao() + 1);
                    }
                    j++;
                }
            }

            i++;
        }
        return estacionado;
    }

    @Override
    public int realizarCheckOut(Estacionamento est, int horaSaida) {
        int horaEntrada = 0;
        int i = 0;
        boolean removido = false;

        while (i < est.vagas.length && !removido) {
            for (int j = 0; j < est.vagas[i].length; j++) {
                if (est.vagas[i][j].veiculo == this) {
                    horaEntrada = est.vagas[i][j].getHoraEntrada();
                    est.vagas[i][j].veiculo = null;

                    est.setOcupacao(est.getOcupacao() - 1);
                    j = est.vagas[i].length;
                    removido = true;
                }
            }
            i++;
        }
        return horaEntrada;
    }

}
