package com.example.spring.service.rules.ProdutoRule;

import com.example.spring.dto.ProdutoRequestDTO;

public interface ProdutoRule {
    void validar(ProdutoRequestDTO dto);
}
