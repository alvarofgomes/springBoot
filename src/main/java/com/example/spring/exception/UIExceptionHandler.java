package com.example.spring.exception;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = "com.example.spring.ui")
public class UIExceptionHandler {

    @ExceptionHandler(ProdutoNotFoundException.class)
    public String produtoNaoEncontrado(Model model) {
        model.addAttribute("erro", "Produto não encontrado");
        model.addAttribute("produtos", List.of());
        model.addAttribute("formProduto", null);
        return "produtos";
    }
    
    @ExceptionHandler(BusinessException.class)
    public String business(BusinessException ex, Model model) {
        model.addAttribute("erro", "Dados inválidos: " + ex.getMessage());
        model.addAttribute("produtos", List.of());
        model.addAttribute("formProduto", null);
        return "produtos";
    }
    
}
