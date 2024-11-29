package com.finan.orcamento.model.enums;

import com.finan.orcamento.service.ICMSOrcamento.*;

public enum IcmsEstados {
    ICMS_MG(new IcmsMG()),
    ICMS_SP(new IcmsSP()),
    ICMS_RJ(new IcmsRJ()),
    ICMS_RS(new IcmsRS()),
    ICMS_PR(new IcmsPR()),
    ICMS_SC(new IcmsSC()),
    ICMS_BA(new IcmsBA()),
    ICMS_DF(new IcmsDF()),
    ICMS_GO(new IcmsGO()),
    ICMS_PA(new IcmsPA()),
    ICMS_MT(new IcmsMT()),
    ICMS_PE(new IcmsPE()),
    ICMS_CE(new IcmsCE()),
    ICMS_ES(new IcmsES()),
    ICMS_MS(new IcmsMS()),
    ICMS_AM(new IcmsAM()),
    ICMS_MA(new IcmsMA()),
    ICMS_RN(new IcmsRN()),
    ICMS_PB(new IcmsPB()),
    ICMS_AL(new IcmsAL()),
    ICMS_PI(new IcmsPI()),
    ICMS_RO(new IcmsRO()),
    ICMS_SE(new IcmsSE()),
    ICMS_TO(new IcmsTO()),
    ICMS_AC(new IcmsAC()),
    ICMS_AP(new IcmsAP()),
    ICMS_RR(new IcmsRR());

    private final IcmsStrategy strategy;

    IcmsEstados(IcmsStrategy strategy) {
        this.strategy = strategy;
    }

    public IcmsStrategy getStrategy() {
        return this.strategy;
    }

}