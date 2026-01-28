package com.example.spring.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.spring.dto.ProdutoRequestDTO;
import com.example.spring.dto.ProdutoResponseDTO;
import com.example.spring.exception.ProdutoNotFoundException;
import com.example.spring.mapper.ProdutoMapper;
import com.example.spring.model.Produto;
import com.example.spring.service.ProdutoService;
import com.example.spring.service.rules.ProdutoRule.ProdutoRule;

@Service
@Primary // essa define a implementação principal caso queira trocar só adicionar na outra 
public class ProdutoServiceInMemoryImpl implements ProdutoService {

    private final List<ProdutoRule> rules;
    private final List<Produto> bancoFake = new ArrayList<>();
    private final AtomicLong seq = new AtomicLong(1);

    public ProdutoServiceInMemoryImpl(List<ProdutoRule> rules) {
        this.rules = rules;
    }

    private void validar(ProdutoRequestDTO dto) {
        rules.forEach(r -> r.validar(dto));
    }

    @Override
    public ProdutoResponseDTO salvar(ProdutoRequestDTO dto) {
        validar(dto);

        Produto p = ProdutoMapper.toEntity(dto);
        p.setId(seq.getAndIncrement());
        bancoFake.add(p);

        return ProdutoMapper.toResponse(p);
    }

    @Override
    public List<ProdutoResponseDTO> listar() {
        return bancoFake.stream().map(ProdutoMapper::toResponse).toList();
    }

    @Override
    public ProdutoResponseDTO buscarPorId(Long id) {
        Produto p = bancoFake.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProdutoNotFoundException(id));

        return ProdutoMapper.toResponse(p);
    }

    @Override
    public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO dto) {
        validar(dto);

        Produto p = bancoFake.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProdutoNotFoundException(id));

        p.setNome(dto.getNome());
        p.setPreco(dto.getPreco());

        return ProdutoMapper.toResponse(p);
    }

    @Override
    public void remover(Long id) {
        boolean removed = bancoFake.removeIf(p -> p.getId().equals(id));
        if (!removed) {
            throw new ProdutoNotFoundException(id);
        }
    }
}
