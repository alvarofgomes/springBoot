package com.example.spring.service.rules.ProdutoRule;

import org.springframework.stereotype.Component;

import com.example.spring.dto.ProdutoRequestDTO;
import com.example.spring.exception.ProdutoNomeInvalidoException;

@Component
public class NomeObrigatorioRule implements ProdutoRule {

    @Override
    public void validar(ProdutoRequestDTO dto) {
        if (dto.getNome() == null || dto.getNome().trim().isEmpty()) {
            throw new ProdutoNomeInvalidoException();
        }
    }
}
