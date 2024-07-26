package com.example2;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(int id) {
        produtos.removeIf(p -> p.getId() == id);
    }

    public void atualizarProduto(Produto produto) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == produto.getId()) {
                produtos.set(i, produto);
                return;
            }
        }
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }
}

