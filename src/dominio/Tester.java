package dominio;

public class Tester {

    public static void main(String[] args) {

        Estacionamento est = new Estacionamento();

        Veiculo c1 = new Carro("MIC-4294", "Gol", "Ximbinha", "9999");
        Veiculo c2 = new Carro("MBV-2352", "Fiesta", "Gabriel", "084.787.969-08");
        Veiculo c3 = new Carro("ABK-1872", "Ka", "Amanda" , "098.715.249-19");
        Veiculo c4 = new Carro("NWD-3576", "Fusion", "Tania", "408.367.537-17");
        Veiculo c5 = new Carro("RBG-2311", "C3", "Noeli", "682.829.319-34");

        Veiculo m1 = new Moto("ABC-1234", "CG 125", "Jellyson", "421.377.112-28");
        Veiculo m2 = new Moto("DDG-9712", "BIZ", "Luan","341.555.326-92");
        Veiculo m3 = new Moto("GHF-0449", "Falcon", "Davi","486.521.112-36");
        Veiculo m4 = new Moto("ZXV-6911", "Hornet","João","642.222.157-22");

        try {
            est.realizarCheckIn(c2, 10);
            est.realizarCheckIn(m1, 0);
            est.realizarCheckIn(m2, -2);
        } catch (VagasEsgotadasException ex) {
            System.out.println(ex.getMessage());
        } catch (HoraInvalidaException ex) {
            System.out.println(ex.getMessage());
        }

        for (int i = 0; i < est.vagas.length; i++) {
            System.out.println("Vaga" + i);
            for (int j = 0; j < est.vagas[i].length; j++) {
                if (est.vagas[i][j].veiculo != null) {
                    System.out.println(est.vagas[i][j].veiculo);
                }
            }
        }

        System.out.println("------------------------");

        try {
            System.out.println(est.realizarCheckOut(c2, 12));
        } catch (HoraInvalidaException ex) {
            System.out.println(ex.getMessage());
        }

        for (int i = 0; i < est.vagas.length; i++) {
            System.out.println("Vaga" + i);
            for (int j = 0; j < est.vagas[i].length; j++) {
                if (est.vagas[i][j].veiculo != null) {
                    System.out.println(est.vagas[i][j].veiculo);
                }
            }
        }

        System.out.println("-----------------------------");

        try {
            est.realizarCheckIn(m3, 0);
        } catch (VagasEsgotadasException ex) {
            System.out.println(ex.getMessage());
        } catch (HoraInvalidaException ex) {
            System.out.println(ex.getMessage());
        }

        for (int i = 0; i < est.vagas.length; i++) {
            System.out.println();
            System.out.println("Vaga" + i);
            for (int j = 0; j < est.vagas[i].length; j++) {
                if (est.vagas[i][j].veiculo != null) {
                    System.out.println(est.vagas[i][j].veiculo);
                }
            }
        }

        System.out.println("");
        System.out.println("LISTA ORGANIZADA POR PLACAA");
        for (Veiculo v :est.getListaDeVeiculos()){
            System.out.println(v);
        }
        
    }

}
