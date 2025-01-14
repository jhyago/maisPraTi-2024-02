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

    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Produto> buscarPorId(@PathVariable Long id){
        return produtoService.buscarPorId(id);
    }

    @PostMapping
    public Object produtoSalvar(@RequestBody Produto produto){
        return produtoService.salvar(produto);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id) {
        produtoService.deletarPorId(id);
    }
}