public class Veiculo {
    
    private String marca;          // Atributo para armazenar a marca do veículo.
    private String modelo;         // Atributo para armazenar o modelo do veículo.
    private double tarifaDiaria;   // Atributo para armazenar a tarifa diária do veículo.

    // Construtor da classe para inicializar os atributos.
    public Veiculo(String marca, String modelo, double tarifaDiaria) {
        this.marca = marca;
        this.modelo = modelo;
        this.tarifaDiaria = tarifaDiaria;
    }

    // Getter e Setter para o atributo 'marca'.
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    // Getter e Setter para o atributo 'modelo'.
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // Getter e Setter para o atributo 'tarifaDiaria'.
    public double getTarifaDiaria() {
        return tarifaDiaria;
    }

    public void setTarifaDiaria(double tarifaDiaria) {
        this.tarifaDiaria = tarifaDiaria;
    }

    // Método que exibe os detalhes do veículo.
    public void exibirDetalhes() {
        System.out.println("=== Novo Veículo Cadastrado ===");
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Tarifa Diária: R$ " + this.tarifaDiaria);
    }
}
