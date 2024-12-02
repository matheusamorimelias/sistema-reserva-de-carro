package com.devonigiri;

public class Compacto extends Veiculo {
    private String gps;
    public Compacto(String marca, String modelo, double tarifaDiaria, String gps) {
        super(marca, modelo, tarifaDiaria);
        this.gps = gps;
    }
    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }
    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("GPS: " + getGps());
        System.out.println("Tipo: Compacto");
    }
    
}
