package com.devonigiri;

public class Sedan extends Veiculo {
    private String arCondicionado;
    public Sedan(String marca, String modelo, double tarifaDiaria, String arCondicionado) {
        super(marca, modelo, tarifaDiaria);
        this.arCondicionado = arCondicionado;
    }
    public String getArCondicionado() {
        return arCondicionado;
    }

    public void setArcondicionado(String arCondicionado) {
        this.arCondicionado = arCondicionado;
    }
    
    

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("AR Condicionado: " + getArCondicionado());
        System.out.println("Tipo: Sedan" );
    }

}
