import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        List<Veiculo> listaVeiculos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("1- Cadastrar Veículo");
            System.out.println("2- Exibir Veículos Cadastrados");
            System.out.println("3- Reservar Veículo");
            System.out.println("0- Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir o newline após a entrada de um número

            switch (opcao) {
                case 1:
                    int opcaoCadastro;
                    do {
                        System.out.println("\nCADASTRAR VEÍCULO");
                        System.out.println("1- Suv");
                        System.out.println("2- Sedan");
                        System.out.println("3- Compacto");
                        System.out.println("0- Voltar");
                        System.out.print("Escolha uma opção: ");
                        opcaoCadastro = scanner.nextInt();
                        scanner.nextLine(); // Consumir o newline

                        switch (opcaoCadastro) {
                            case 1:
                                System.out.print("Qual a marca? ");
                                String marcaSuv = scanner.nextLine();
                                System.out.print("Qual o modelo? ");
                                String modeloSuv = scanner.nextLine();
                                System.out.print("Qual o valor da tarifa diária? ");
                                double tarifaSuv = scanner.nextDouble();
                                scanner.nextLine(); // Consumir o newline

                                Veiculo suv = new Suv(marcaSuv, modeloSuv, tarifaSuv);
                                listaVeiculos.add(suv);
                                System.out.println("SUV cadastrado com sucesso!");
                                break;

                            case 2:
                                System.out.print("Qual a marca? ");
                                String marcaSedan = scanner.nextLine();
                                System.out.print("Qual o modelo? ");
                                String modeloSedan = scanner.nextLine();
                                System.out.print("Qual o valor da tarifa diária? ");
                                double tarifaSedan = scanner.nextDouble();
                                scanner.nextLine(); // Consumir o newline

                                Veiculo sedan = new Sedan(marcaSedan, modeloSedan, tarifaSedan);
                                listaVeiculos.add(sedan);
                                System.out.println("Sedan cadastrado com sucesso!");
                                break;

                            case 3:
                                System.out.print("Qual a marca? ");
                                String marcaCompacto = scanner.nextLine();
                                System.out.print("Qual o modelo? ");
                                String modeloCompacto = scanner.nextLine();
                                System.out.print("Qual o valor da tarifa diária? ");
                                double tarifaCompacto = scanner.nextDouble();
                                scanner.nextLine(); // Consumir o newline

                                Veiculo compacto = new Compacto(marcaCompacto, modeloCompacto, tarifaCompacto);
                                listaVeiculos.add(compacto);
                                System.out.println("Compacto cadastrado com sucesso!");
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
                    if (listaVeiculos.isEmpty()) {
                        System.out.println("Nenhum veículo cadastrado.");
                    } else {
                        for (Veiculo veiculo : listaVeiculos) {
                            veiculo.exibirDetalhes();
                            System.out.println("----------------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n=== RESERVAR VEÍCULO ===");
                    if (listaVeiculos.isEmpty()) {
                        System.out.println("Nenhum veículo disponível para reserva.");
                    } else {
                        for (int i = 0; i < listaVeiculos.size(); i++) {
                            Veiculo veiculo = listaVeiculos.get(i);
                            System.out.println((i + 1) + "- " + veiculo.getMarca() + " " + veiculo.getModelo());
                        }

                        System.out.print("Escolha o número do veículo para reserva: ");
                        int escolha = scanner.nextInt();
                        scanner.nextLine(); // Consumir o newline
                        
                        if (escolha >= 1 && escolha <= listaVeiculos.size()) {
                            Veiculo veiculoEscolhido = listaVeiculos.get(escolha - 1);
                            System.out.println("\nReserva confirmada!");
                            veiculoEscolhido.exibirDetalhes();
                        } else {
                            System.out.println("Opção inválida, tente novamente.");
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
