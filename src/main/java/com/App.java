package com;

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

    public static void main(String[] args) {
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
                                System.out.println("Compacto cadastrado com sucesso!");
                                break;

                            case 0:
                                try {
                                    System.out.println("Voltando ao menu principal...");
                                } catch (RuntimeException e) {
                                    System.out
                                            .println("Ocorreu um erro ao voltar ao menu principal: " + e.getMessage());
                                }
                                break;

                            default:
                                try {
                                    System.out.println("Opção inválida, digite novamente.");
                                } catch (RuntimeException e) {
                                    System.out.println(
                                            "Ocorreu * um erro ao processar a opção inválida: " + e.getMessage());
                                }
                                break;
                        }
                    } while (opcaoCadastro != 0);
                    break;

                case 2:
                    try {
                        System.out.println("\n=== VEÍCULOS CADASTRADOS ===");

                        if (listaVeiculos == null || listaVeiculos.isEmpty()) {
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
                            } else {
                                throw new RuntimeException("Opção inválida, tente novamente.");
                            }
                        }
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 0:
                    try {
                        System.out.println("Você escolheu a opção 0. Saindo do programa...");
                    } catch (RuntimeException e) {
                        System.out.println("Ocorreu um erro ao voltar ao menu principal: " + e.getMessage());
                    }
                    break;

                default:
                    try {
                        System.out.println("Opção inválida, digite novamente.");
                    } catch (RuntimeException e) {
                        System.out.println("Ocorreu um erro ao processar a opção inválida: " + e.getMessage());
                    }
                    break;

            }

        } while (opcao != 0);

        scanner.close();
    }
}