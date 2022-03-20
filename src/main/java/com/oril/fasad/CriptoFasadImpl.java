package com.oril.fasad;

import com.oril.converter.CriptoConverterDto;
import com.oril.dto.CriptoDto;
import com.oril.model.Cripto;
import com.oril.service.CriptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CriptoFasadImpl implements CriptoFasad {

    @Autowired
    CriptoService criptoService;

    @Autowired
    CriptoVerificate criptoVerificate;

    @Override
    public Cripto createCripto(CriptoDto criptoDto) {
        if (!criptoVerificate.isEqualLast(criptoDto)) {
            Cripto cripto = CriptoConverterDto.convertToCripto(criptoDto);
            return cripto;
        }
        return null;
    }

}
