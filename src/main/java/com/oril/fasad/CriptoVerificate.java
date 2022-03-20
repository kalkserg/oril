package com.oril.fasad;

import com.oril.dto.CriptoDto;
import com.oril.model.Cripto;
import com.oril.service.CriptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class CriptoVerificate {

    @Autowired
    private CriptoService criptoService;

    public boolean isEqualLast(CriptoDto criptoDto) {
        Cripto lastCripo = criptoService.getLast(criptoDto.getCurr1(), criptoDto.getCurr2());
        if (lastCripo == null) return false;
        return lastCripo.getLprice().equals(criptoDto.getLprice());
    }
}
