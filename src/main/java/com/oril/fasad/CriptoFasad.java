package com.oril.fasad;

import com.oril.dto.CriptoDto;
import com.oril.model.Cripto;

public interface CriptoFasad {
    Cripto createCripto(CriptoDto criptoDto);
}
