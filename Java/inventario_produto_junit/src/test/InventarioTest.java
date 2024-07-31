package com.example;
import java.util.List;

import com.example.Inventario;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class InventarioTest {
    private Inventario inventario;

    @Before
    public void setup(){
        inventario = new Inventario();
    }

    @Test
    public void testAdicionar(){
      Produto produto = new Produto(1, "teste",10, "teste", 99.99 );
      Inventario.adicionar(produto);
      List<produto> list = inventario.listar();
      assertEquals(1, lista.size());
    }

    @Test
    public void testeAdicionar(){
      testeAdicionar();
      inventario.atualizar(1, 20, 200);
      List<Produto>lista = inventario.listar();
      Produto produtoAtualizado = lista.get(inde)
    }
}
