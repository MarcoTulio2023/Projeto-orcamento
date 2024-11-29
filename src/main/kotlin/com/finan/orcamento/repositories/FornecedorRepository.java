package com.finan.orcamento.repositories;

import com.finan.orcamento.model.enums.FornecedorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<FornecedorModel, Long> {

}
