package com.example;
import java.util.Scanner;

public class AprovacaoAluno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Definição do número de disciplinas
        int numDisciplinas = 4;
        double[] notas = new double[numDisciplinas];
        double soma = 0;

        // Captura das notas
        System.out.println("Digite as notas para as 4 disciplinas:");
        for (int i = 0; i < numDisciplinas; i++) {
            while (true) {
                System.out.print("Nota da disciplina " + (i + 1) + ": ");
                if (scanner.hasNextDouble()) {
                    double nota = scanner.nextDouble();
                    if (nota >= 0 && nota <= 10) {
                        notas[i] = nota;
                        soma += nota;
                        break;
                    } else {
                        System.out.println("Nota inválida. A nota deve estar entre 0 e 10.");
                    }
                } else {
                    System.out.println("Entrada inválida. Digite um número.");
                    scanner.next(); // Limpar o buffer
                }
            }
        }

        // Cálculo da média
        double media = soma / numDisciplinas;

        // Verificação de bônus
        boolean todasNotasAcimaDeNove = true;
        for (double nota : notas) {
            if (nota <= 9) {
                todasNotasAcimaDeNove = false;
                break;
            }
        }
        if (todasNotasAcimaDeNove) {
            media *= 1.1; // Aplica 10% de bônus
        }

        // Determinação do status do aluno
        String status;
        if (media >= 7) {
            status = "Aprovado";
        } else if (media >= 5) {
            status = "Recuperação";
        } else {
            status = "Reprovado";
        }

        // Exibição dos resultados
        System.out.println("\nNotas:");
        for (int i = 0; i < numDisciplinas; i++) {
            System.out.println("Disciplina " + (i + 1) + ": " + notas[i]);
        }
        System.out.printf("Média final: %.2f\n", media);
        System.out.println("Status do aluno: " + status);

        scanner.close();
    }
}


