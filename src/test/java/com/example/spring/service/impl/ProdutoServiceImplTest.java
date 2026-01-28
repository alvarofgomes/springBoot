package com.example.spring.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.spring.dto.ProdutoRequestDTO;
import com.example.spring.exception.ProdutoNotFoundException;
import com.example.spring.model.Produto;
import com.example.spring.repository.ProdutoRepository;
import com.example.spring.service.impl.ProdutoServiceImpl;
import com.example.spring.service.rules.ProdutoRule.ProdutoRule;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceImplTest {

    @Mock
    ProdutoRepository repository;

    @Mock
    ProdutoRule rule1;

    @Mock
    ProdutoRule rule2;

    ProdutoServiceImpl service;

    @BeforeEach
    void setup() {
        service = new ProdutoServiceImpl(repository, List.of(rule1, rule2));
    }

    @Test
    void salvar_deveValidarRegras_eSalvar() {
        ProdutoRequestDTO dto = new ProdutoRequestDTO("Mouse", 10.0);

        when(repository.save(any(Produto.class)))
                .thenReturn(new Produto(1L, "Mouse", 10.0));

        var resp = service.salvar(dto);

        verify(rule1).validar(dto);
        verify(rule2).validar(dto);
        verify(repository).save(any(Produto.class));

        assertEquals(1L, resp.getId());
        assertEquals("Mouse", resp.getNome());
        assertEquals(10.0, resp.getPreco());
    }

    @Test
    void buscarPorId_quandoNaoExiste_deveLancarExcecao() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ProdutoNotFoundException.class, () -> service.buscarPorId(99L));
    }

    @Test
    void remover_quandoNaoExiste_deveLancarExcecao() {
        when(repository.existsById(5L)).thenReturn(false);

        assertThrows(ProdutoNotFoundException.class, () -> service.remover(5L));
        verify(repository, never()).deleteById(anyLong());
    }
}
