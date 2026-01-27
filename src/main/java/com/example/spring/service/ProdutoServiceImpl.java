package com.example.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring.dto.ProdutoRequestDTO;
import com.example.spring.dto.ProdutoResponseDTO;
import com.example.spring.exception.ProdutoNotFoundException;
import com.example.spring.mapper.ProdutoMapper;
import com.example.spring.model.Produto;
import com.example.spring.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoServiceImpl(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProdutoResponseDTO salvar(ProdutoRequestDTO dto) {
        Produto entity = ProdutoMapper.toEntity(dto);
        Produto salvo = repository.save(entity);
        return ProdutoMapper.toResponse(salvo);
    }

    @Override
    public List<ProdutoResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(ProdutoMapper::toResponse)
                .toList();
    }

    @Override
    public ProdutoResponseDTO buscarPorId(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(id));
        return ProdutoMapper.toResponse(produto);
    }

    @Override
    public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO dto) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(id));

        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());

        Produto salvo = repository.save(produto);
        return ProdutoMapper.toResponse(salvo);
    }

    @Override
    public void remover(Long id) {
        if (!repository.existsById(id)) {
            throw new ProdutoNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
