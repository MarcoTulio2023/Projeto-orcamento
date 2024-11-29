package com.finan.orcamento.controller;

import com.finan.orcamento.model.OrcamentoModel;
import com.finan.orcamento.model.UsuarioModel;
import com.finan.orcamento.repositories.UsuarioRepository;
import com.finan.orcamento.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orcamento")
public class OrcamentoController {

    @Autowired
    private OrcamentoService orcamentoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/novo")
    public String novoOrcamentoForm(Model model) {
        List<UsuarioModel> usuarios = usuarioRepository.findAll(); // Carrega os usuários cadastrados
        OrcamentoModel orcamentoModel = new OrcamentoModel();
        model.addAttribute("orcamentoModel", orcamentoModel);
        model.addAttribute("usuarios", usuarios); // Passa a lista de usuários para o formulário
        return "orcamentoForm";
    }

    @PostMapping("/salvar")
    public String salvarOrcamento(@ModelAttribute OrcamentoModel orcamentoModel, @RequestParam("usuarioId") Long usuarioId, Model model) {
        UsuarioModel usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        orcamentoModel.setUsuario(usuario); // Associa o usuário ao orçamento
        OrcamentoModel novoOrcamento = orcamentoService.cadastrarOrcamento(orcamentoModel);
        List<OrcamentoModel> orcamentos = orcamentoService.buscarCadastro();
        model.addAttribute("orcamentos", orcamentos);

        return "orcamentoSucesso";
    }

    @GetMapping("/sucesso")
    public String orcamentoSucesso(Model model) {
        List<OrcamentoModel> orcamentos = orcamentoService.buscarCadastro();
        model.addAttribute("orcamentos", orcamentos);
        return "orcamentoSucesso";
    }
}
