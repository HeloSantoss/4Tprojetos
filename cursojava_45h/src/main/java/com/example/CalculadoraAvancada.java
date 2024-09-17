package com.example;

import java.util.InputMismatchException;
import java.util.Scanner;

// Classe base para operações
abstract class Operacao {
    abstract double calcular(double a, double b) throws Exception;
}

// Subclasse para operação de soma
class Soma extends Operacao {
    @Override
    double calcular(double a, double b) {
        return a + b;
    }
}

// Subclasse para operação de subtração
class Subtracao extends Operacao {
    @Override
    double calcular(double a, double b) {
        return a - b;
    }
}

// Subclasse para operação de multiplicação
class Multiplicacao extends Operacao {
    @Override
    double calcular(double a, double b) {
        return a * b;
    }
}

// Subclasse para operação de divisão
class Divisao extends Operacao {
    @Override
    double calcular(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Erro: Divisão por zero.");
        }
        return a / b;
    }
}

// Subclasse para operação de raiz quadrada
class RaizQuadrada extends Operacao {
    @Override
    double calcular(double a, double b) throws ArithmeticException {
        if (a < 0) {
            throw new ArithmeticException("Erro: Raiz quadrada de número negativo.");
        }
        return Math.sqrt(a);
    }
}

public class CalculadoraAvancada {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma operação:");
            System.out.println("1. Soma");
            System.out.println("2. Subtração");
            System.out.println("3. Multiplicação");
            System.out.println("4. Divisão");
            System.out.println("5. Raiz Quadrada");
            System.out.println("6. Sair");

            int opcao;
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next(); // Limpar o buffer
                continue;
            }

            switch (opcao) {
                case 1: // Soma
                case 2: // Subtração
                case 3: // Multiplicação
                case 4: // Divisão
                    System.out.print("Digite o primeiro número: ");
                    double num1 = obterNumero(scanner);

                    System.out.print("Digite o segundo número: ");
                    double num2 = obterNumero(scanner);

                    Operacao operacao = obterOperacao(opcao);
                    try {
                        double resultado = operacao.calcular(num1, num2);
                        System.out.println("Resultado: " + resultado);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5: // Raiz Quadrada
                    System.out.print("Digite o número: ");
                    double num = obterNumero(scanner);

                    Operacao raiz = new RaizQuadrada();
                    try {
                        double resultado = raiz.calcular(num, 0);
                        System.out.println("Resultado: " + resultado);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6: // Sair
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

    private static double obterNumero(Scanner scanner) {
        double numero;
        while (true) {
            try {
                numero = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.next(); // Limpar o buffer
            }
        }
        return numero;
    }

    private static Operacao obterOperacao(int opcao) {
        switch (opcao) {
            case 1:
                return new Soma();
            case 2:
                return new Subtracao();
            case 3:
                return new Multiplicacao();
            case 4:
                return new Divisao();
            default:
                throw new IllegalArgumentException("Operação não suportada.");
        }
    }
}
