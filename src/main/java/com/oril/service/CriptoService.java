package com.oril.service;

import com.oril.model.Cripto;

import java.util.List;

public interface CriptoService {

    Cripto saveCripto(Cripto cripto);

    Double getMinPrice(String curr);

    Double getMaxPrice(String curr);

    Cripto getLast(String curr1, String curr2);

    List<Cripto> getListPrices(String curr1, String page, String size);

    List<String[]> getReport();
}
