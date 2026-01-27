package com.example.spring.mapper;

import com.example.spring.dto.ProdutoRequestDTO;
import com.example.spring.dto.ProdutoResponseDTO;
import com.example.spring.model.Produto;

public class ProdutoMapper {

    public static Produto toEntity(ProdutoRequestDTO dto) {
        Produto p = new Produto();
        p.setNome(dto.getNome());
        p.setPreco(dto.getPreco());
        return p;
    }

    public static ProdutoResponseDTO toResponse(Produto p) {
        return new ProdutoResponseDTO(p.getId(), p.getNome(), p.getPreco());
    }
}