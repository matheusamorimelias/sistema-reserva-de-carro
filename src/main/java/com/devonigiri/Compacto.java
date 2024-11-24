package com;

public class Compacto extends Veiculo {
    public Compacto(String marca, String modelo, double tarifaDiaria) {
        super(marca, modelo, tarifaDiaria);
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Tipo: Compacto");
    }
    
}
