package com.example.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring.model.Produto;
import com.example.spring.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listar() {
        return repository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
    
    public Produto atualizar(Long id, Produto produtoAtualizado) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setNome(produtoAtualizado.getNome());
        produto.setPreco(produtoAtualizado.getPreco());

        return repository.save(produto);
    }

    
}
