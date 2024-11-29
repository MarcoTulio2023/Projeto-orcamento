package com.finan.orcamento.model;

import com.finan.orcamento.model.enums.FornecedorModel;
import com.finan.orcamento.model.enums.IcmsEstados;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orcamentofornecedor")
public class OrcamentoFornecedorModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id", nullable = false)
    private FornecedorModel fornecedor;

    @Enumerated(EnumType.STRING)
    private IcmsEstados icmsEstados;

    @Column(name="valor_orcamento")
    private BigDecimal valorOrcamento;

    @Column(name="valor_icms")
    private BigDecimal valorICMS;

    public void calcularIcms() {
        this.valorICMS = this.icmsEstados.getStrategy().calcular(this.valorOrcamento);
    }

    public BigDecimal getValorFinal() {
        if (valorOrcamento != null && valorICMS != null) {
            return valorOrcamento.add(valorICMS);
        }
        return BigDecimal.ZERO;
    }
}
