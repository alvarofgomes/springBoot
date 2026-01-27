package com.example.spring.dto;

public class ProdutoRequestDTO {
    private String nome;
    private Double preco;

    public ProdutoRequestDTO() {}

    public ProdutoRequestDTO(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }
}
