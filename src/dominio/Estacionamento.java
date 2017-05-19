package dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Estacionamento {

    Vaga[][] vagas = new Vaga[60][2];
    private int ocupacao;

    public Estacionamento() {
        for (int i = 0; i < vagas.length; i++) {
            for (int j = 0; j < vagas[i].length; j++) {
                vagas[i][j] = new Vaga();
            }
        }
        this.ocupacao = 0;
    }

    public void realizarCheckIn(Veiculo v, int horaEntrada) throws VagasEsgotadasException, HoraInvalidaException {
        if (validarHorario(horaEntrada) == true) {
            if (!v.estacionar(this, horaEntrada))
                throw new VagasEsgotadasException("AS VAGAS ESTÃO ESGOTADAS");
            
        } else {
            throw new HoraInvalidaException ("O HORARIO INFORMADO NÃO É VALIDO");
        }
    }

    public double realizarCheckOut(Veiculo v, int horarioSaida) throws HoraInvalidaException {
        if (validarHorario(horarioSaida) == true) {
            return CalculadoraDeValorCheckOut.calcularValorCheckout
                            (v, horarioSaida, v.realizarCheckOut(this, horarioSaida));
           
        } else {
            throw new HoraInvalidaException("O HORARIO INFORMADO NÃO É VALIDO");
        }
    }

    private boolean validarHorario(int horario) {
        if (horario >= 0 && horario <= 23) {
            return true;
        } else {
            return false;
        }
    }

    public List<Veiculo> getListaDeVeiculos() {
        List<Veiculo> lista = new ArrayList<>();

        for (int i = 0; i < vagas.length; i++) {
            for (int j = 0; j < vagas[i].length; j++) {
                if (vagas[i][j].veiculo != null
                        && !lista.contains(vagas[i][j].veiculo)) {
                    lista.add(vagas[i][j].veiculo);
                }
            }
        }
        Collections.sort(lista);
        return lista;
    }

    public Vaga[][] getVagas() {
        return vagas;
    }

    public void setVagas(Vaga[][] vagas) {
        this.vagas = vagas;
    }

    public int getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(int ocupacao) {
        this.ocupacao = ocupacao;
    }
    

}
