package com;

public class Veiculo {

    private String marca;          
    private String modelo;         
    private double tarifaDiaria;   

    public Veiculo(String marca, String modelo, double tarifaDiaria) {
        this.marca = marca;
        this.modelo = modelo;
        this.tarifaDiaria = tarifaDiaria;
    }

    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public double getTarifaDiaria() {
        return tarifaDiaria;
    }

    public void setTarifaDiaria(double tarifaDiaria) {
        this.tarifaDiaria = tarifaDiaria;
    }


    public void exibirDetalhes() {
        
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Tarifa Diária: R$ " + this.tarifaDiaria);
    }
    
}
