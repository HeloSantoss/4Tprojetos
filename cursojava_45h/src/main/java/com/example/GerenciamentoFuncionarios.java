package com.example;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoFuncionarios {
    private List<Funcionario> funcionarios;

    public GerenciamentoFuncionarios() {
        funcionarios = new ArrayList<>();
    }

    // Adiciona um novo funcionário
    public void adicionarFuncionario(String nome, int idade, double salario) {
        funcionarios.add(new Funcionario(nome, idade, salario));
    }

    // Remove um funcionário pelo nome
    public void removerFuncionario(String nome) throws Exception {
        Funcionario funcionario = buscarFuncionario(nome);
        if (funcionario != null) {
            funcionarios.remove(funcionario);
        } else {
            throw new Exception("Funcionário com o nome " + nome + " não encontrado.");
        }
    }

    // Lista todos os funcionários
    public void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario);
            }
        }
    }

    // Calcula a média salarial dos funcionários
    public double calcularMediaSalarial() {
        if (funcionarios.isEmpty()) {
            return 0;
        }
        double somaSalarios = 0;
        for (Funcionario funcionario : funcionarios) {
            somaSalarios += funcionario.getSalario();
        }
        return somaSalarios / funcionarios.size();
    }

    // Busca um funcionário pelo nome
    private Funcionario buscarFuncionario(String nome) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nome)) {
                return funcionario;
            }
        }
        return null;
    }
}
