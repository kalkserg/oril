package com.oril.util;

import com.oril.dto.CriptoDto;
import com.oril.fasad.CriptoFasad;
import com.oril.model.Cripto;
import com.oril.service.CriptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CollectData {

    @Autowired
    ConnectApi connectApi;

    @Autowired
    CriptoFasad criptoFasad;

    @Autowired
    CriptoService criptoService;

    @Scheduled(fixedRate = 10000)
    public void doGetBTC() {
        connectApi.setUrle("https://cex.io/api/last_price/BTC/USD");
        CriptoDto criptoDto = connectApi.get();
        Cripto cripto = criptoFasad.createCripto(criptoDto);
        criptoService.saveCripto(cripto);
        System.out.println(cripto);
    }

    @Scheduled(fixedRate = 10000)
    public void doGetETH() {
        connectApi.setUrle("https://cex.io/api/last_price/ETH/USD");
        CriptoDto criptoDto = connectApi.get();
        Cripto cripto = criptoFasad.createCripto(criptoDto);
        criptoService.saveCripto(cripto);
        System.out.println(cripto);
    }

    @Scheduled(fixedRate = 10000)
    public void doGetXRP() {
        connectApi.setUrle("https://cex.io/api/last_price/XRP/USD");
        CriptoDto criptoDto = connectApi.get();
        Cripto cripto = criptoFasad.createCripto(criptoDto);
        criptoService.saveCripto(cripto);
        System.out.println(cripto);
    }
}
