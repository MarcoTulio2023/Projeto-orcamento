package com.finan.orcamento.service.ICMSOrcamento;

import java.math.BigDecimal;

public class IcmsBA implements IcmsStrategy{
    @Override
    public BigDecimal calcular(BigDecimal valorOrcamento) {
        return valorOrcamento.multiply(new BigDecimal("0.205"));
    }
}
