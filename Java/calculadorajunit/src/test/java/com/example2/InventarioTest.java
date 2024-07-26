package com.example2;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest {
    private Inventario inventario;

    @Before
    public void setUp() {
        inventario = new Inventario();
    }

    @Test
    public void testAdicionarProduto() {
        Produto produto = new Produto(1, "Produto 1", 10);
        inventario.adicionarProduto(produto);
        List<Produto> produtos = inventario.listarProdutos();
        assertEquals(1, produtos.size());
        assertEquals(produto, produtos.get(0));
    }

    @Test
    public void testRemoverProduto() {
        Produto produto = new Produto(1, "Produto 1", 10);
        inventario.adicionarProduto(produto);
        inventario.removerProduto(1);
        List<Produto> produtos = inventario.listarProdutos();
        assertTrue(produtos.isEmpty());
    }

    @Test
    public void testAtualizarProduto() {
        Produto produto = new Produto(1, "Produto 1", 10);
        inventario.adicionarProduto(produto);
        Produto produtoAtualizado = new Produto(1, "Produto Atualizado", 20);
        inventario.atualizarProduto(produtoAtualizado);
        List<Produto> produtos = inventario.listarProdutos();
        assertEquals(1, produtos.size());
        assertEquals(produtoAtualizado, produtos.get(0));
    }
}
