package desafio;

import java.util.ArrayList;

public class Estoque {
    ArrayList<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public Produto consultarProduto(String nome) {
        for (Produto p : produtos) {
            if(p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    public void removerProduto(String nome) {
        Produto produto = consultarProduto(nome);
        if(produto != null) {
            produtos.remove(produto);
        } else {
            System.out.println("Produto não encontrado");
        }
    }

    public void exibirEstoque() {
        if(produtos.isEmpty()) {
            System.out.println("Estoque vazio");
        } else {
            for(Produto p : produtos){
                System.out.println(p);
            }
        }
    }
}
