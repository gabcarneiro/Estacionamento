package dominio;

import java.util.Objects;

public abstract class Veiculo implements Comparable<Veiculo> {

    protected String placa;
    protected String modelo;
    protected double valorHora;
    protected String nomeProprietario;
    protected String cpfProprietario;

    public Veiculo(String placa, String modelo, String nome, String cpf) {
        this.placa = placa;
        this.modelo = modelo;
        this.nomeProprietario = nome;
        this.cpfProprietario = cpf;
    }

    public abstract boolean estacionar(Estacionamento est, int horaEntrada);

    public abstract int realizarCheckOut(Estacionamento est, int horaSaida);

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public void setCpfProprietario(String cpfProprietario) {
        this.cpfProprietario = cpfProprietario;
    }

    public double getValorHora() {
        return valorHora;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.placa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Veiculo other = (Veiculo) obj;
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Veiculo{" + "placa=" + placa + ", modelo=" + modelo + '}';
    }

    @Override
    public int compareTo(Veiculo v) {
        return this.getPlaca().compareTo(v.getPlaca());
    }
}
