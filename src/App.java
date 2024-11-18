import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        List<Suv> listSuv = new ArrayList<>();
        List<Sedan> listSedan = new ArrayList<>();

        List<Veiculos> listVeiculos = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("1- Cadastrar Veículo");
            System.out.println("2- Exibir Veículos Cadastrados");
            System.out.println("0- Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    int opcaoCadastro;
                    do {
                        System.out.println("\nCADASTRAR VEÍCULO");
                        System.out.println("1- Suv");
                        System.out.println("2- Sedan");
                        System.out.println("0- Voltar");
                        System.out.print("Escolha uma opção: ");
                        opcaoCadastro = scanner.nextInt();
                        scanner.nextLine(); 

                        switch (opcaoCadastro) {
                            case 1: 
                                System.out.print("Qual a placa? ");
                                String placaSuv = scanner.nextLine();
                                System.out.print("Qual a marca? ");
                                String marcaSuv = scanner.nextLine();
                                System.out.print("Qual o valor? ");
                                double precoSuv = scanner.nextDouble();
                                System.out.print("Qual o desconto? ");
                                double descontoSuv = scanner.nextDouble();
                                scanner.nextLine();

                                Suv suv = new Suv(placaSuv, marcaSuv, precoSuv, descontoSuv);
                                listSuv.add(suv); 
                                listVeiculos.add(suv); 
                                System.out.println("Suv cadastrado com sucesso!");
                                break;

                            case 2: 
                                System.out.print("Qual a placa? ");
                                String placaSedan = scanner.nextLine();
                                System.out.print("Qual a marca? ");
                                String marcaSedan = scanner.nextLine();
                                System.out.print("Qual o valor? ");
                                double precoSedan = scanner.nextDouble();
                                System.out.print("Qual o desconto? ");
                                double descontoSedan = scanner.nextDouble();
                                scanner.nextLine();

                                Sedan sedan = new Sedan(placaSedan, marcaSedan, precoSedan, descontoSedan);
                                listSedan.add(sedan); 
                                listVeiculos.add(sedan);  
                                System.out.println("Sedan cadastrado com sucesso!");
                                break;

                            case 0:
                                System.out.println("Voltando ao menu principal...");
                                break;

                            default:
                                System.out.println("Opção inválida, digite novamente.");
                                break;
                        }
                    } while (opcaoCadastro != 0);
                    break;

                case 2:
                    System.out.println("\n=== VEÍCULOS CADASTRADOS ===");
                    if (listVeiculos.isEmpty()) {
                        System.out.println("Nenhum veículo cadastrado.");
                    } else {
                        System.out.println("\n=== Todos os veículos ===");
                        for (Veiculos veiculo : listVeiculos) {
                            veiculo.status();
                            System.out.println("----------------------------");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida, digite novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
