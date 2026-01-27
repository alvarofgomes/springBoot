package com.example.spring.ui;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.spring.dto.ProdutoRequestDTO;
import com.example.spring.dto.ProdutoResponseDTO;
import com.example.spring.service.ProdutoService;

@Controller
@RequestMapping("/ui/produtos")
public class ProdutoUIController {

    private final ProdutoService service;

    public ProdutoUIController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public String tela(@RequestParam(required = false) Long editId, Model model) {
        List<ProdutoResponseDTO> produtos = service.listar();
        model.addAttribute("produtos", produtos);
        
        ProdutoResponseDTO formProduto = null;
        if (editId != null) {
            formProduto = service.buscarPorId(editId);
        }
        model.addAttribute("formProduto", formProduto);

        return "produtos";
    }

    @PostMapping
    public String adicionar(@RequestParam String nome, @RequestParam Double preco) {
        service.salvar(new ProdutoRequestDTO(nome, preco));
        return "redirect:/ui/produtos";
    }

    @PostMapping("/{id}/update")
    public String atualizar(@PathVariable Long id,
                            @RequestParam String nome,
                            @RequestParam Double preco) {
        service.atualizar(id, new ProdutoRequestDTO(nome, preco));
        return "redirect:/ui/produtos";
    }

    @PostMapping("/{id}/delete")
    public String remover(@PathVariable Long id) {
        service.remover(id);
        return "redirect:/ui/produtos";
    }
}
