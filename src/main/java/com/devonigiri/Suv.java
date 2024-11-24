package com.devonigiri;

public class Suv extends Veiculo {
    public Suv(String marca, String modelo, double tarifaDiaria) {
        super(marca, modelo, tarifaDiaria);
    }


    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Tipo: SUV");
    }
    
}
