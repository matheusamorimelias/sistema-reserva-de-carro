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
                                System.out.print("Tem direção automatica? ");
                                String direcaoAutomatica = scanner.nextLine();
                                System.out.print("Qual o valor da tarifa diária? ");
                                double tarifaSuv = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.println("\n Cadastrando...:");
                                System.out.println("Marca: " + marcaSuv);
                                System.out.println("Modelo: " + modeloSuv);
                                System.out.println("Direção Automática: " + direcaoAutomatica);
                                System.out.println("Tarifa diária: R$ " + tarifaSuv);


                                System.out.print("Deseja confirmar o cadastro? (S/N): ");
                                String confirmacao = scanner.nextLine();

                                if (confirmacao.equalsIgnoreCase("S")) {
                                    System.out.println("Cadastro confirmado!");
                                    Veiculo suv = new Suv(marcaSuv, modeloSuv, tarifaSuv, direcaoAutomatica);
                                    listaVeiculos.add(suv);
                                    salvarVeiculos();
                                    System.out.println("SUV cadastrado com sucesso!");
            
                                } else {
                                    System.out.println("Cadastro cancelado.");
                                }
                                
                                break;

                            case 2:
                                System.out.print("Qual a marca? ");
                                String marcaSedan = scanner.nextLine();
                                System.out.print("Qual o modelo? ");
                                String modeloSedan = scanner.nextLine();
                                System.out.print("Tem AR Condicionado? ");
                                String arcondicionado = scanner.nextLine();
                                System.out.print("Qual o valor da tarifa diária? ");
                                double tarifaSedan = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.println("\n Cadastrando...:");
                                System.out.println("Marca: " + marcaSedan);
                                System.out.println("Modelo: " + modeloSedan);
                                System.out.println("AR Condicionado: " + arcondicionado);

                                System.out.println("Tarifa diária: R$ " + tarifaSedan);


                                System.out.print("Deseja confirmar o cadastro? (S/N): ");
                                String confirmacao2 = scanner.nextLine();

                                if (confirmacao2.equalsIgnoreCase("S")) {
                                    System.out.println("Cadastro confirmado!");
                                    Veiculo sedan = new Sedan(marcaSedan, modeloSedan, tarifaSedan, arcondicionado);
                                    listaVeiculos.add(sedan);
                                    salvarVeiculos();
                                    System.out.println("Sedan cadastrado com sucesso!");
                                } else {
                                    System.out.println("Cadastro cancelado.");
                                }
                                
                                break;
                            case 3:
                                System.out.print("Qual a marca? ");
                                String marcaCompacto = scanner.nextLine();
                                System.out.print("Qual o modelo? ");
                                String modeloCompacto = scanner.nextLine();
                                System.out.print("Tem GPS? ");
                                String gps = scanner.nextLine();
                                System.out.print("Qual o valor da tarifa diária? ");
                                double tarifaCompacto = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.println("\n Cadastrando...:");
                                System.out.println("Marca: " + marcaCompacto);
                                System.out.println("Modelo: " + modeloCompacto);
                                System.out.println("GPs: " + gps);
                                System.out.println("Tarifa diária: R$ " + tarifaCompacto);


                                System.out.print("Deseja confirmar o cadastro? (S/N): ");
                                String confirmacao3 = scanner.nextLine();

                                if (confirmacao3.equalsIgnoreCase("S")) {
                                    System.out.println("Cadastro confirmado!");
                                    Veiculo compacto = new Compacto(marcaCompacto, modeloCompacto, tarifaCompacto, gps);
                                    listaVeiculos.add(compacto);
                                    salvarVeiculos();
                                    System.out.println("Compacto cadastrado com sucesso!");
            
                                } else {
                                    System.out.println("Cadastro cancelado.");
                                }
                                
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
                            int escolha = -1;
                            while (escolha <= 0 || escolha > listaVeiculos.size()) {
                                for (int i = 0; i < listaVeiculos.size(); i++) {
                                    Veiculo veiculo = listaVeiculos.get(i);
                                    System.out.println("Veículos Disponiveis Para a Reserva");
                                    System.out.println((i + 1) + "- ");
                                    veiculo.exibirDetalhes();
                                }
                
                                System.out.print("Escolha o número do veículo para reserva: ");
                                escolha = scanner.nextInt();
                                scanner.nextLine();
                
                                if (escolha <= 0 || escolha > listaVeiculos.size()) {
                                    System.out.println("Opção inválida, tente novamente.");
                                }
                            }
                
                            Veiculo veiculoEscolhido = listaVeiculos.get(escolha - 1);
                
                            System.out.println("\nReserva confirmada!");
                            veiculoEscolhido.exibirDetalhes();
                            System.out.println("-------------------------");                
                            listaVeiculos.remove(veiculoEscolhido);
                            listaReserva.add(veiculoEscolhido);
                            salvarVeiculos();
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
                            int escolha = -1;
                            for (int i = 0; i < listaVeiculos.size(); i++) {
                                Veiculo veiculo = listaVeiculos.get(i);
                                System.out.println((i + 1) + "- " + veiculo.getMarca() + " " + veiculo.getModelo());
                            }
                                while (escolha <= 0 || escolha > listaVeiculos.size()) {
                                    System.out.print("Escolha o número do veículo para atualizar: ");
                                    escolha = scanner.nextInt();
                                    scanner.nextLine();  
                    
                                    if (escolha < 1 || escolha > listaVeiculos.size()) {
                                        System.out.println("Opção inválida. Por favor, escolha uma opção Valida válido.");
                                        escolha = scanner.nextInt();
                                        scanner.nextLine();
                                    }
                                }
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
                    }catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("\n=== Devolver Veículo Cadastrado ===");
                    try {
                        if (listaReserva.isEmpty()) {
                            throw new RuntimeException("Nenhum veículo reservado para devolver.");
                        } else {
                            int escolha = -1;
                            System.out.println("\n=== VEÍCULOS RESERVADOS ===");
                            for (int i = 0; i < listaReserva.size(); i++) {
                                Veiculo veiculo = listaReserva.get(i);
                                System.out.println((i + 1) + "- ");
                                veiculo.exibirDetalhes();
                                System.out.println("----------------------------");
                            }
                
                            
                            while (escolha <= 0 || escolha > listaReserva.size()) {
                                System.out.print("Escolha o número do veículo para devolver: ");
                                escolha = scanner.nextInt();
                                scanner.nextLine();
                
                                if (escolha <= 0 || escolha > listaReserva.size()) {
                                    System.out.println("Opção inválida, tente novamente.");
                                }
                            }
                
                            Veiculo veiculoDevolvido = listaReserva.get(escolha - 1);
                
                            System.out.print("Quantos dias o veículo foi reservado? ");
                            int diasDevolucao = scanner.nextInt();
                            scanner.nextLine();
                
                            if (diasDevolucao <= 0) {
                                throw new RuntimeException("O número de dias de devolução deve ser maior que zero.");
                            }
                
                            double valorTotal = veiculoDevolvido.getTarifaDiaria() * diasDevolucao;
                            System.out.println("O valor total da reserva é: R$ " + valorTotal);
                
                            System.out.println("\nVeículo devolvido com sucesso!");
                            veiculoDevolvido.exibirDetalhes();
                            listaReserva.remove(veiculoDevolvido);
                            listaVeiculos.add(veiculoDevolvido);
                
                            salvarVeiculos();
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
                            throw new RuntimeException("Nenhum veículo cadastrado ou reservado.");
                        } else {
                            for (int i = 0; i < listaVeiculos.size(); i++) {
                                System.out.println("== Veículos Cadastrados e Reservados ==");
                                Veiculo veiculo = listaVeiculos.get(i);
                                System.out.println((i + 1) + "- ");
                                veiculo.exibirDetalhes();
                                System.out.println("----------------------------");
                            }

                            System.out.print("Escolha o número do veículo para excluir: ");
                            int escolha = scanner.nextInt();
                            scanner.nextLine();

                            if (escolha < 1 || escolha > listaVeiculos.size()) {
                                throw new RuntimeException("Opção inválida.");
                            }
                            Veiculo veiculoEscolhido = listaVeiculos.get(escolha - 1);
                            System.out.print("Tem certeza que deseja excluir este veículo? (S/N): ");
                            String confirmar = scanner.nextLine().toUpperCase();
                            if (confirmar.equals("S")) {
                                listaVeiculos.remove(veiculoEscolhido);
                                salvarVeiculos();
                                System.out.println("Veículo excluído com sucesso.");
                            } else {
                                System.out.println("Processo de Exclusão cancelado.");
                            }
                        }
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void carregarVeiculos() {
        try {
            File file = new File(ARQUIVO_JSON);
            if (file.exists()) {
                FileReader reader = new FileReader(file);
                Gson gson = new Gson();
                Type listType = new TypeToken<List<Veiculo>>() {
                }.getType();
                listaVeiculos = gson.fromJson(reader, listType);
                reader.close();
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados do arquivo.");
        }
    }

    private static void salvarVeiculos() {
        try {
            FileWriter writer = new FileWriter(ARQUIVO_JSON);
            Gson gson = new Gson();
            String json = gson.toJson(listaVeiculos);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados no arquivo.");
        }
    }
}
