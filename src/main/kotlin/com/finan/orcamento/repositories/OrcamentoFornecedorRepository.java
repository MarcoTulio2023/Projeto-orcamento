package com.finan.orcamento.repositories;

import com.finan.orcamento.model.OrcamentoFornecedorModel;
import com.finan.orcamento.model.OrcamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrcamentoFornecedorRepository extends JpaRepository<OrcamentoFornecedorModel, Long> {
}
