package com.example.spring.service;

import java.util.List;
import com.example.spring.dto.ProdutoRequestDTO;
import com.example.spring.dto.ProdutoResponseDTO;

public interface ProdutoService {
    ProdutoResponseDTO salvar(ProdutoRequestDTO dto);
    List<ProdutoResponseDTO> listar();
    ProdutoResponseDTO buscarPorId(Long id);
    ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO dto);
    void remover(Long id);
}
