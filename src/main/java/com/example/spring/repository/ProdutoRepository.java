package com.example.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
