package com.example;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Produto {
    // Atributos
    private int id;
    private String nome;
    private int quantidade;
    private String categoria;
    private double preco;
}