/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 

package com.exemple;


public class Calculadora {
    // Soma
    public int soma(int a, int b) {
        return a + b;
    }

    // Subtração
    public int subtracao(int a, int b) {
        return a - b;
    }

    // Multiplicação
    public int multiplicacao(int a, int b) {
        return a * b;
    }

    // Divisão
    public double divisao(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor não pode ser zero.");
        }
        return a / b;
    }

    // Raiz Quadrada
    public double raizQuadrada(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Não é possível calcular a raiz quadrada de um número negativo.");
        }
        return Math.sqrt(a);
    }
}
