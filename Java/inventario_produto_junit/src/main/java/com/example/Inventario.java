package com.example;

import com.example.Produto;
import java.util.ArrayList;
import java.util.List;

public class Inventario{

    private List<Produto> list;

    public Inventario() {
        list = new ArrayList<>();
    }

    public void adicionar(Produto produto) {
        list.add(produto);
    }
//deletar
    public void remover(Produto produto, int id) {
        list.removeif(produtos -> produto.getId()==id);
    }
//atualizar
    public void atualizar(int id, int quantidade, double preco) {
    for(Produto produto : list){
        if(produto.getId()==id){
            produto.setQuantidade(quantidade);
            produto.serPreco(preco);
            break;
        }
    }
}
//listar
    public List<Produto> listar(){
        return new ArrayList<>(list);
    }
}



    

