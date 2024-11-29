package com.finan.orcamento.service;

import com.finan.orcamento.model.OrcamentoFornecedorModel;
import com.finan.orcamento.repositories.OrcamentoFornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrcamentoFornecedorService {

    @Autowired
    private OrcamentoFornecedorRepository orcamentoFornecedorRepository;

    public List<OrcamentoFornecedorModel> buscarCadastro() {
        return orcamentoFornecedorRepository.findAll();
    }

    public OrcamentoFornecedorModel buscaId(Long id) {
        Optional<OrcamentoFornecedorModel> obj = orcamentoFornecedorRepository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            throw new RuntimeException("Orçamento não encontrado");
        }
    }

    public OrcamentoFornecedorModel cadastrarOrcamento(OrcamentoFornecedorModel orcamentoFornecedorModel) {
        if (orcamentoFornecedorModel.getValorOrcamento() == null) {
            throw new IllegalArgumentException("O valor do orçamento não pode ser nulo.");
        }
        if (orcamentoFornecedorModel.getIcmsEstados() == null) {
            throw new IllegalArgumentException("O estado do ICMS não pode ser nulo.");
        }
        orcamentoFornecedorModel.calcularIcms();
        return orcamentoFornecedorRepository.save(orcamentoFornecedorModel);
    }

    public OrcamentoFornecedorModel atualizaCadastro(OrcamentoFornecedorModel orcamentoFornecedorModel, Long id) {
        OrcamentoFornecedorModel newOrcamentoFornecedorModel = buscaId(id);
        newOrcamentoFornecedorModel.setValorOrcamento(orcamentoFornecedorModel.getValorOrcamento());
        newOrcamentoFornecedorModel.setValorICMS(orcamentoFornecedorModel.getValorICMS());
        return orcamentoFornecedorRepository.save(newOrcamentoFornecedorModel);
    }

    public void deletaOrcamento(Long id) {
        orcamentoFornecedorRepository.deleteById(id);
    }
}
