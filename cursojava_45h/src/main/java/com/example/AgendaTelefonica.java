package com.example;

import java.util.InputMismatchException;
import java.util.Scanner;

// Exceção personalizada para quando o contato não é encontrado
class ContatoNaoEncontradoException extends Exception {
    public ContatoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}

// Exceção personalizada para quando a agenda está cheia
class AgendaCheiaException extends Exception {
    public AgendaCheiaException(String mensagem) {
        super(mensagem);
    }
}

// Classe que representa um contato
class Contato {
    private String nome;
    private String telefone;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Telefone: " + telefone;
    }
}

// Classe que gerencia a agenda
class Agenda {
    private Contato[] contatos;
    private int tamanho;
    private static final int LIMITE = 100;

    public Agenda() {
        contatos = new Contato[LIMITE];
        tamanho = 0;
    }

    public void adicionarContato(String nome, String telefone) throws AgendaCheiaException {
        if (tamanho >= LIMITE) {
            throw new AgendaCheiaException("Agenda está cheia. Não é possível adicionar mais contatos.");
        }
        contatos[tamanho++] = new Contato(nome, telefone);
    }

    public void removerContato(String nome) throws ContatoNaoEncontradoException {
        int index = buscarIndiceContato(nome);
        if (index == -1) {
            throw new ContatoNaoEncontradoException("Contato com o nome " + nome + " não encontrado.");
        }
        for (int i = index; i < tamanho - 1; i++) {
            contatos[i] = contatos[i + 1];
        }
        contatos[--tamanho] = null;
    }

    public Contato buscarContato(String nome) throws ContatoNaoEncontradoException {
        int index = buscarIndiceContato(nome);
        if (index == -1) {
            throw new ContatoNaoEncontradoException("Contato com o nome " + nome + " não encontrado.");
        }
        return contatos[index];
    }

    public void listarContatos() {
        if (tamanho == 0) {
            System.out.println("Agenda vazia.");
            return;
        }
        for (int i = 0; i < tamanho; i++) {
            System.out.println(contatos[i]);
        }
    }

    private int buscarIndiceContato(String nome) {
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                return i;
            }
        }
        return -1;
    }
}

// Classe principal para interação com o usuário
public class AgendaTelefonica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Remover Contato");
            System.out.println("3. Buscar Contato");
            System.out.println("4. Listar Contatos");
            System.out.println("5. Sair");

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
                case 1: // Adicionar Contato
                    System.out.print("Digite o nome do contato: ");
                    String nomeAdicionar = scanner.nextLine();
                    System.out.print("Digite o telefone do contato: ");
                    String telefoneAdicionar = scanner.nextLine();
                    try {
                        agenda.adicionarContato(nomeAdicionar, telefoneAdicionar);
                        System.out.println("Contato adicionado com sucesso.");
                    } catch (AgendaCheiaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2: // Remover Contato
                    System.out.print("Digite o nome do contato a ser removido: ");
                    String nomeRemover = scanner.nextLine();
                    try {
                        agenda.removerContato(nomeRemover);
                        System.out.println("Contato removido com sucesso.");
                    } catch (ContatoNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3: // Buscar Contato
                    System.out.print("Digite o nome do contato a ser buscado: ");
                    String nomeBuscar = scanner.nextLine();
                    try {
                        Contato contato = agenda.buscarContato(nomeBuscar);
                        System.out.println("Contato encontrado: " + contato);
                    } catch (ContatoNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4: // Listar Contatos
                    agenda.listarContatos();
                    break;

                case 5: // Sair
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
