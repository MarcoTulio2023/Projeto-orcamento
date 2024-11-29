package com.finan.orcamento.model.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finan.orcamento.model.OrcamentoFornecedorModel;
import com.finan.orcamento.model.OrcamentoModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="fornecedor")
public class FornecedorModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "razao_social")
    private String razaosocial;

    @Column(name = "nome_fantasia")
    private String nome_fantasia;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "inscricao_estadual")
    private String inscricaoestadual;

    @Column(name = "estado")
    private String estado;

    @JsonIgnore
    @OneToMany(mappedBy = "id")
    private List<OrcamentoModel> orcamentos = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "id")
    private List<OrcamentoFornecedorModel> orcamento = new ArrayList<>();

}

