package com.example.api_user.service;

import com.example.api_user.model.Produto;
import com.example.api_user.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto createProduto(String nome, double preco) {
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setPreco(preco);
        return produtoRepository.save(produto);
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public void update(Long id, String nome, double preco) {
        produtoRepository.findById(id).ifPresent(produto -> {
            produto.setNome(nome);
            produto.setPreco(preco);
            produtoRepository.save(produto);
        });
    }

    public void deletarPorId(Long id) {
        produtoRepository.deleteById(id);
    }
}
