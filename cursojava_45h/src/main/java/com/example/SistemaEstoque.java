package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// Classe que representa um item de estoque
class Item {
    private String nome;
    private int quantidade;

    public Item(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return nome + ":" + quantidade;
    }
}

// Classe que gerencia o estoque
class Estoque {
    private List<Item> itens;
    private static final String ARQUIVO_ESTOQUE = "estoque.txt";

    public Estoque() {
        itens = new ArrayList<>();
        carregarEstoque();
    }

    // Adiciona um item ao estoque
    public void adicionarItem(String nome, int quantidade) {
        itens.add(new Item(nome, quantidade));
        salvarEstoque();
    }

    // Remove um item do estoque
    public void removerItem(String nome) {
        itens.removeIf(item -> item.getNome().equalsIgnoreCase(nome));
        salvarEstoque();
    }

    // Lista todos os itens no estoque
    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Estoque vazio.");
        } else {
            for (Item item : itens) {
                System.out.println(item);
            }
        }
    }

    // Salva o estoque em um arquivo
    private void salvarEstoque() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_ESTOQUE))) {
            for (Item item : itens) {
                writer.write(item.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o estoque: " + e.getMessage());
        }
    }

    // Carrega o estoque a partir de um arquivo
    private void carregarEstoque() {
        File file = new File(ARQUIVO_ESTOQUE);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Erro ao criar o arquivo de estoque: " + e.getMessage());
            }
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_ESTOQUE))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(":");
                if (partes.length == 2) {
                    String nome = partes[0];
                    int quantidade = Integer.parseInt(partes[1]);
                    itens.add(new Item(nome, quantidade));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar o estoque: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro no formato dos dados do arquivo de estoque: " + e.getMessage());
        }
    }
}

// Classe principal para interação com o usuário
public class SistemaEstoque {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque();
        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar Item");
            System.out.println("2. Remover Item");
            System.out.println("3. Listar Itens");
            System.out.println("4. Sair");

            int opcao;
            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next(); // Limpar o buffer
                continue;
            }

            switch (opcao) {
                case 1: // Adicionar Item
                    System.out.print("Digite o nome do item: ");
                    String nomeAdicionar = scanner.nextLine();
                    System.out.print("Digite a quantidade do item: ");
                    int quantidadeAdicionar;
                    try {
                        quantidadeAdicionar = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer
                    } catch (InputMismatchException e) {
                        System.out.println("Quantidade inválida. Por favor, insira um número inteiro.");
                        scanner.next(); // Limpar o buffer
                        continue;
                    }
                    estoque.adicionarItem(nomeAdicionar, quantidadeAdicionar);
                    System.out.println("Item adicionado com sucesso.");
                    break;

                case 2: // Remover Item
                    System.out.print("Digite o nome do item a ser removido: ");
                    String nomeRemover = scanner.nextLine();
                    estoque.removerItem(nomeRemover);
                    System.out.println("Item removido com sucesso.");
                    break;

                case 3: // Listar Itens
                    estoque.listarItens();
                    break;

                case 4: // Sair
                    continuar = false;
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}
