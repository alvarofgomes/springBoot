package com.example.spring.exception;

public class ProdutoPrecoInvalidoException extends BusinessException {
    public ProdutoPrecoInvalidoException() {
        super("Preço do produto deve ser maior que zero.");
    }
}
