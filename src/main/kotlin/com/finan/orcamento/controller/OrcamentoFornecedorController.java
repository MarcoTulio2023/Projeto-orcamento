package com.finan.orcamento.controller;

import com.finan.orcamento.model.OrcamentoFornecedorModel;
import com.finan.orcamento.model.enums.FornecedorModel;
import com.finan.orcamento.repositories.FornecedorRepository;
import com.finan.orcamento.service.OrcamentoFornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/fornecedororcamento")
public class OrcamentoFornecedorController {

    @Autowired
    private OrcamentoFornecedorService orcamentoFornecedorService;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @GetMapping("/novo")
    public String novoFornecedorOrcamento(Model model) {
        List<FornecedorModel> fornecedor = fornecedorRepository.findAll(); // Carrega os fornecedores cadastrados
        OrcamentoFornecedorModel orcamentoFornecedorModel = new OrcamentoFornecedorModel();
        model.addAttribute("orcamentoFornecedorModel", orcamentoFornecedorModel); // Corrigido para 'orcamentoFornecedorModel'
        model.addAttribute("fornecedor", fornecedor); // Passa a lista de fornecedores para o formulário
        return "fornecedorOrcamento";
    }


    @PostMapping("/salvar")
    public String salvarOrcamentoFornecedor(@ModelAttribute OrcamentoFornecedorModel orcamentoFornecedorModel, @RequestParam("fornecedorId") Long fornecedorId, Model model) {
        FornecedorModel fornecedor = fornecedorRepository.findById(fornecedorId)
                .orElseThrow(() -> new IllegalArgumentException("Fornecedor não encontrado"));
        orcamentoFornecedorModel.setFornecedor(fornecedor); // Associa o fornecedor ao orçamento

        orcamentoFornecedorService.cadastrarOrcamento(orcamentoFornecedorModel);

        List<OrcamentoFornecedorModel> orcamentos = orcamentoFornecedorService.buscarCadastro();
        model.addAttribute("orcamentos", orcamentos);

        return "orcamentoFornecedorSucesso";
    }


    @GetMapping("/sucesso")
    public String orcamentoSucesso(Model model) {
        List<OrcamentoFornecedorModel> orcamento = orcamentoFornecedorService.buscarCadastro();
        model.addAttribute("orcamento", orcamento);
        return "orcamentoFornecedorSucesso";
    }
}
