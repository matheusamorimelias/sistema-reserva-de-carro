package com.devonigiri;

public class Suv extends Veiculo {
    private String direcaoAutomatica; 
    public Suv(String marca, String modelo, double tarifaDiaria, String direcaoAutomatica) {
        super(marca, modelo, tarifaDiaria);
        this.direcaoAutomatica = direcaoAutomatica;
    }
    public String getDirecaoAutomatica() {
        return direcaoAutomatica;
    }

    public void setDirecaoAutomatica(String direcaoAutomatica) {
        this.direcaoAutomatica = direcaoAutomatica;
    }



    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Direção Automática: " + getDiasReservados());
        System.out.println("Tipo: SUV");
    }
    
}
