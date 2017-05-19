package dominio;

public class CalculadoraDeValorCheckOut {
    
    public static double calcularValorCheckout(Veiculo veiculo, int horaSaida, int horaEntrada){
        double valorPirmeiraHora = 2;
        
        int horasEstacionadas = horaSaida - horaEntrada;
        
        return  ((horasEstacionadas - 1) * veiculo.getValorHora()) + valorPirmeiraHora;
    }
    
}
