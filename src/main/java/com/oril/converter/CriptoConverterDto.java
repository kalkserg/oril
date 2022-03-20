package com.oril.converter;

import com.oril.dto.CriptoDto;
import com.oril.model.Cripto;

public final class CriptoConverterDto {

    public static Cripto convertToCripto(CriptoDto criptoDto) {
        Cripto newCripto = new Cripto();
        newCripto.setDate(criptoDto.getDate());
        newCripto.setCurr1(criptoDto.getCurr1());
        newCripto.setCurr2(criptoDto.getCurr2());
        newCripto.setLprice(criptoDto.getLprice());
        return newCripto;
    }

    public static CriptoDto convertToCriptoDto(Cripto cripto) {
        CriptoDto newCriptoDto = new CriptoDto();
        newCriptoDto.setDate(cripto.getDate());
        newCriptoDto.setCurr1(cripto.getCurr1());
        newCriptoDto.setCurr2(cripto.getCurr2());
        newCriptoDto.setLprice(cripto.getLprice());
        return newCriptoDto;
    }
}
