package com.example.spring.service.rules.ProdutoRule;

import org.springframework.stereotype.Component;

import com.example.spring.dto.ProdutoRequestDTO;
import com.example.spring.exception.ProdutoPrecoInvalidoException;

@Component
public class PrecoPositivoRule implements ProdutoRule {

    @Override
    public void validar(ProdutoRequestDTO dto) {
        if (dto.getPreco() == null || dto.getPreco() <= 0) {
            throw new ProdutoPrecoInvalidoException();
        }
    }
}