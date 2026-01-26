package com.example.spring.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.spring.model.Produto;
import com.example.spring.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String hello() {
        return "API de produtos rodando com Spring Boot + JPA + PostgreSQL";
    }

    @GetMapping
    public List<Produto> listarProdutos() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Produto adicionarProduto(@RequestBody Produto produto) {
        return service.salvar(produto);
    }

    @DeleteMapping("/{id}")
    public String removerProduto(@PathVariable Long id) {
        service.remover(id);
        return "Produto removido com sucesso";
    }
    
    @PutMapping("/{id}")
    public Produto atualizarProduto(
            @PathVariable Long id,
            @RequestBody Produto produto) {

        return service.atualizar(id, produto);
    }

    
}
