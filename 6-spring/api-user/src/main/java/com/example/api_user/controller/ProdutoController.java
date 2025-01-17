package com.example.api_user.controller;

import com.example.api_user.model.Produto;
import com.example.api_user.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public Produto criarProduto(@RequestParam String nome, @RequestParam double preco) {
        return produtoService.createProduto(nome, preco);
    }

    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Produto> buscarPorId(@PathVariable Long id){
        return produtoService.buscarPorId(id);
    }

    @PutMapping("/edit/{id}")
    public void produtoEditar(@PathVariable Long id, @RequestParam String nome, @RequestParam double preco){
        produtoService.update(id, nome, preco);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id) {
        produtoService.deletarPorId(id);
    }
}