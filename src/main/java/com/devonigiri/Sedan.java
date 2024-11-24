package com.devonigiri;

public class Sedan extends Veiculo {
    public Sedan(String marca, String modelo, double tarifaDiaria) {
        super(marca, modelo, tarifaDiaria);
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Tipo: Sedan");
    }

}
