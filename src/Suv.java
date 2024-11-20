public class Suv extends Veiculo {

    // Construtor da classe
    public Suv(String marca, String modelo, double tarifaDiaria) {
        super(marca, modelo, tarifaDiaria);
    }

    // Sobrescreve o método 'exibirDetalhes' para adicionar o tipo 'SUV'
    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Tipo: SUV");
    }
}
