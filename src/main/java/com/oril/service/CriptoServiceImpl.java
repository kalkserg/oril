package com.oril.service;

import com.oril.model.Cripto;
import com.oril.repository.CriptoRepository;
import com.oril.service.exception.ThereIsNoSuchCriptoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CriptoServiceImpl implements CriptoService {

    @Autowired
    private CriptoRepository criptoRepository;

    @Override
    public Cripto saveCripto(Cripto cripto) {
        if (cripto != null) return criptoRepository.save(cripto);
        return null;
    }

    @Override
    public Double getMinPrice(String curr1) {
        try {
            return criptoRepository.findTopByCurr1OrderByLpriceAsc(curr1).getLprice();
        } catch (Exception ex) {
            throw new ThereIsNoSuchCriptoException();
        }
    }

    @Override
    public Double getMaxPrice(String curr1) {
        try {
            return criptoRepository.findTopByCurr1OrderByLpriceDesc(curr1).getLprice();
        } catch (Exception ex) {
            throw new ThereIsNoSuchCriptoException();
        }
    }

    @Override
    public Cripto getLast(String curr1, String curr2) {
        try {
            return criptoRepository.findTopByCurr1AndCurr2OrderByDateDesc(curr1, curr2);
        } catch (Exception ex) {
            throw new ThereIsNoSuchCriptoException();
        }
    }

    @Override
    public List<Cripto> getListPrices(String curr1, String page, String size) {
        List<Cripto> criptos;
        try {
            int ipage = Integer.parseInt(page);
            int isize = Integer.parseInt(size);
            Pageable paging = PageRequest.of(ipage, isize);
            Page<Cripto> pageCripto = criptoRepository.findByCurr1OrderByLpriceAsc(curr1, paging);
            criptos = pageCripto.getContent();
            return criptos;
        } catch (Exception ex) {
            throw new ThereIsNoSuchCriptoException();
        }
    }

    @Override
    public List<String[]> getReport() {
        //Cryptocurrency Name, Min Price, Max Price
        List<String[]> criptos = new ArrayList<>();
        criptos.add(new String[]{"BTC", getMinPrice("BTC").toString(), getMaxPrice("BTC").toString()});
        criptos.add(new String[]{"ETH", getMinPrice("ETH").toString(), getMaxPrice("ETH").toString()});
        criptos.add(new String[]{"XRP", getMinPrice("XRP").toString(), getMaxPrice("XRP").toString()});
        return criptos;
    }


}
