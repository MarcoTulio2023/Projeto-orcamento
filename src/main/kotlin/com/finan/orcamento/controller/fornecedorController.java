package com.finan.orcamento.controller;

import com.finan.orcamento.model.UsuarioModel;
import com.finan.orcamento.model.enums.FornecedorModel;
import com.finan.orcamento.repositories.FornecedorRepository;
import com.finan.orcamento.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/fornecedor")
public class fornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @GetMapping
    public String getFornecedorCadastro(Model model) {
        model.addAttribute("fornecedorModel", new FornecedorModel());
        return "fornecedorCadastro";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<FornecedorModel> cadastraFornecedor(@ModelAttribute FornecedorModel fornecedorModel) {
        return ResponseEntity.ok(fornecedorService.cadastrarFornecedor(fornecedorModel));
    }

    @GetMapping("/sucesso")
    public String fornecedorSucesso(Model model){
        List<FornecedorModel> fornecedores = fornecedorService.buscarFornecedor();
        model.addAttribute("fornecedores", fornecedores);
        model.addAttribute("fornecedorModel", new FornecedorModel());
        return "fornecedorSucesso";
    }

    @GetMapping("/pesquisa")
    public String listarFornecedor(Model model) {
        List<FornecedorModel> fornecedores = fornecedorService.buscarFornecedor();
        model.addAttribute("fornecedores", fornecedores);
        model.addAttribute("fornecedorModel", new FornecedorModel());
        return "fornecedorCadastro";
    }
}
