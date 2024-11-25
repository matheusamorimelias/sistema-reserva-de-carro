package com.devonigiri;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final String ARQUIVO_JSON = "veiculos.json";
    private static List<Veiculo> listaVeiculos = new ArrayList<>();
    private static List<Veiculo> listaReserva = new ArrayList<>();

    public static void main(String[] args) {
        carregarVeiculos();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("1- Cadastrar Veículo");
            System.out.println("2- Exibir Veículos Cadastrados");
            System.out.println("3- Reservar Veículo");
            System.out.println("4- Atualizar Veiculo");
            System.out.println("5- Devolver Veiculo");
            System.out.println("6- Excluir Veículo Cadastrado");
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
                        System.out.println("3- Compacto");
                        System.out.println("0- Voltar");
                        System.out.print("Escolha uma opção: ");
                        opcaoCadastro = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoCadastro) {
                            case 1:
                                System.out.print("Qual a marca? ");
                                String marcaSuv = scanner.nextLine();
                                System.out.print("Qual o modelo? ");
                                String modeloSuv = scanner.nextLine();
                                System.out.print("Qual o valor da tarifa diária? ");
                                double tarifaSuv = scanner.nextDouble();
                                scanner.nextLine();
                                Veiculo suv = new Suv(marcaSuv, modeloSuv, tarifaSuv);
                                listaVeiculos.add(suv);
                                salvarVeiculos();
                                System.out.println("SUV cadastrado com sucesso!");
                                break;

                            case 2:
                                System.out.print("Qual a marca? ");
                                String marcaSedan = scanner.nextLine();
                                System.out.print("Qual o modelo? ");
                                String modeloSedan = scanner.nextLine();
                                System.out.print("Qual o valor da tarifa diária? ");
                                double tarifaSedan = scanner.nextDouble();
                                scanner.nextLine();
                                Veiculo sedan = new Sedan(marcaSedan, modeloSedan, tarifaSedan);
                                listaVeiculos.add(sedan);
                                salvarVeiculos();
                                System.out.println("Sedan cadastrado com sucesso!");
                                break;

                            case 3:
                                System.out.print("Qual a marca? ");
                                String marcaCompacto = scanner.nextLine();
                                System.out.print("Qual o modelo? ");
                                String modeloCompacto = scanner.nextLine();
                                System.out.print("Qual o valor da tarifa diária? ");
                                double tarifaCompacto = scanner.nextDouble();
                                scanner.nextLine();
                                Veiculo compacto = new Compacto(marcaCompacto, modeloCompacto, tarifaCompacto);
                                listaVeiculos.add(compacto);
                                salvarVeiculos();
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
                    try {
                        System.out.println("\n=== VEÍCULOS CADASTRADOS ===");

                        if (listaVeiculos.isEmpty()) {
                            throw new RuntimeException("Nenhum veículo cadastrado.");
                        } else {
                            for (Veiculo veiculo : listaVeiculos) {
                                veiculo.exibirDetalhes();
                                System.out.println("----------------------------");
                            }
                        }
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("\n=== RESERVAR VEÍCULO ===");
                    try {
                        if (listaVeiculos.isEmpty()) {
                            throw new RuntimeException("Nenhum veículo disponível para reserva.");
                        } else {
                            for (int i = 0; i < listaVeiculos.size(); i++) {
                                Veiculo veiculo = listaVeiculos.get(i);
                                System.out.println((i + 1) + "- ");
                                veiculo.exibirDetalhes();
                            }

                            System.out.print("Escolha o número do veículo para reserva: ");
                            int escolha = scanner.nextInt();
                            scanner.nextLine();

                            if (escolha >= 1 && escolha <= listaVeiculos.size()) {
                                Veiculo veiculoEscolhido = listaVeiculos.get(escolha - 1);

                                System.out.println("\nReserva confirmada!");
                                veiculoEscolhido.exibirDetalhes();

                                listaVeiculos.remove(veiculoEscolhido);
                                listaReserva.add(veiculoEscolhido);

                                salvarVeiculos();
                                System.out.println("Veículo reservado e alteração salva.");
                            } else {
                                throw new RuntimeException("Opção inválida, tente novamente.");
                            }
                        }
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("\nAtualizando Veículos Cadastrados");
                    try {
                        System.out.println("\n=== VEÍCULOS CADASTRADOS ===");
                        if (listaVeiculos.isEmpty()) {
                            throw new RuntimeException("Nenhum veículo cadastrado.");
                        } else {

                            for (int i = 0; i < listaVeiculos.size(); i++) {
                                Veiculo veiculo = listaVeiculos.get(i);
                                System.out.println((i + 1) + "- " + veiculo.getMarca() + " " + veiculo.getModelo());
                            }

                            System.out.print("Escolha o número do veículo para atualizar: ");
                            int escolha = scanner.nextInt();
                            scanner.nextLine();

                            if (escolha < 1 || escolha > listaVeiculos.size()) {
                                throw new RuntimeException("Opção inválida.");
                            }

                            Veiculo veiculoEscolhido = listaVeiculos.get(escolha - 1);

                            System.out.print("Nova marca: ");
                            String novaMarca = scanner.nextLine();
                            System.out.print("Novo modelo: ");
                            String novoModelo = scanner.nextLine();
                            System.out.print("Nova tarifa diária: ");
                            double novaTarifa = scanner.nextDouble();
                            scanner.nextLine();

                            veiculoEscolhido.setMarca(novaMarca);
                            veiculoEscolhido.setModelo(novoModelo);
                            veiculoEscolhido.setTarifaDiaria(novaTarifa);

                            salvarVeiculos();
                            System.out.println("Veículo atualizado com sucesso!");
                        }
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("\n=== Devolver Veículo Cadastrado ===");
                    try {
                        if (listaReserva.isEmpty()) {
                            throw new RuntimeException("Nenhum veículo reservado para devolver.");
                        } else {
                            System.out.println("\n=== VEÍCULOS RESERVADOS ===");
                            for (int i = 0; i < listaReserva.size(); i++) {
                                Veiculo veiculo = listaReserva.get(i);
                                System.out.println((i + 1) + "- ");
                                veiculo.exibirDetalhes();
                                System.out.println("----------------------------");
                            }

                            System.out.print("Escolha o número do veículo para devolver: ");
                            int escolha = scanner.nextInt();
                            scanner.nextLine();

                            if (escolha >= 1 && escolha <= listaReserva.size()) {
                                Veiculo veiculoDevolvido = listaReserva.get(escolha - 1);

                                System.out.println("\nVeículo devolvido com sucesso!");
                                veiculoDevolvido.exibirDetalhes();

                                listaReserva.remove(veiculoDevolvido);
                                listaVeiculos.add(veiculoDevolvido);

                                salvarVeiculos();
                                System.out.println("Alterações salvas com sucesso.");
                            } else {
                                throw new RuntimeException("Opção inválida, tente novamente.");
                            }
                        }
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("\n=== Excluindo Veículo Cadastrado ===");
                    try {
                        System.out.println("\n=== VEÍCULOS CADASTRADOS ===");
                        if (listaVeiculos.isEmpty()) {
                            throw new RuntimeException("Nenhum veículo cadastrado.");
                        } else {
                            for (int i = 0; i < listaVeiculos.size(); i++) {
                                Veiculo veiculo = listaVeiculos.get(i);
                                System.out.println((i + 1) + "- ");
                                veiculo.exibirDetalhes();
                            }

                            System.out.print("Escolha o número do veículo para excluir: ");
                            int escolha = scanner.nextInt();
                            scanner.nextLine();

                            if (escolha < 1 || escolha > listaVeiculos.size()) {
                                throw new RuntimeException("Opção inválida.");
                            }

                            Veiculo veiculoEscolhido = listaVeiculos.get(escolha - 1);
                            listaVeiculos.remove(veiculoEscolhido);

                            salvarVeiculos();
                            System.out.println("Veículo excluído com sucesso!");
                        }
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    private static void carregarVeiculos() {
        File arquivo = new File(ARQUIVO_JSON);
        if (arquivo.exists()) {
            try (Reader reader = new FileReader(ARQUIVO_JSON)) {
                Gson gson = new Gson();
                Type tipoListaVeiculos = new TypeToken<List<Veiculo>>(){}.getType();
                listaVeiculos = gson.fromJson(reader, tipoListaVeiculos);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void salvarVeiculos() {
        try (Writer writer = new FileWriter(ARQUIVO_JSON)) {
            Gson gson = new Gson();
            gson.toJson(listaVeiculos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
