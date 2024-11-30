package desafio;

import java.util.ArrayList;

// Classe que gerencia o estoque de produtos
public class Estoque {
    ArrayList<Produto> produtos; // Lista para armazenar os produtos no estoque

    // Construtor da classe Estoque, inicializa a lista de produtos
    public Estoque() {
        this.produtos = new ArrayList<>(); // Criação de uma lista vazia para armazenar os produtos
    }

    // Método para adicionar um produto ao estoque
    public void adicionarProduto(Produto produto) {
        produtos.add(produto); // Adiciona o produto à lista de produtos
    }

    // Método para consultar um produto pelo nome
    public Produto consultarProduto(String nome) {
        for (Produto p : produtos) { // Percorre todos os produtos na lista
            if (p.getNome().equalsIgnoreCase(nome)) { // Compara o nome do produto, ignorando diferenças entre maiúsculas e minúsculas
                return p; // Retorna o produto se encontrado
            }
        }
        return null; // Retorna null se o produto não for encontrado
    }

    // Método para remover um produto do estoque pelo nome
    public void removerProduto(String nome) {
        Produto produto = consultarProduto(nome); // Consulta se o produto existe no estoque
        if (produto != null) { // Verifica se o produto foi encontrado
            produtos.remove(produto); // Remove o produto da lista
        } else { // Caso o produto não seja encontrado
            System.out.println("Produto não encontrado."); // Mensagem de erro
        }
    }

    // Método para exibir todos os produtos do estoque
    public void exibirEstoque() {
        if (produtos.isEmpty()) { // Verifica se a lista de produtos está vazia
            System.out.println("Estoque vazio."); // Mensagem indicando estoque vazio
        } else { // Caso existam produtos no estoque
            for (Produto p : produtos) { // Percorre todos os produtos na lista
                System.out.println(p); // Exibe os detalhes de cada produto
            }
        }
    }
}