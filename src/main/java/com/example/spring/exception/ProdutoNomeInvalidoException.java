package com.example.spring.exception;

public class ProdutoNomeInvalidoException extends BusinessException {
    public ProdutoNomeInvalidoException() {
        super("Nome do produto é obrigatório.");
    }
}
