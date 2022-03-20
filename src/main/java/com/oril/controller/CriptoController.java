package com.oril.controller;

import com.oril.model.Cripto;
import com.oril.service.CriptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(path = "/cryptocurrencies")
public class CriptoController {

    @Autowired
    private CriptoService criptoService;

    @GetMapping(value = "{urlParameter}")
    public Double getPrice(@PathVariable("urlParameter") String urlParameter, @RequestParam(value = "name", required = true) String curr1) {
        if (urlParameter.equals("minprice")) return criptoService.getMinPrice(curr1);
        else if (urlParameter.equals("maxprice")) return criptoService.getMaxPrice(curr1);
        return null;
    }

    @GetMapping()
    public List<Cripto> getListPrice(@RequestParam(value = "name", required = true) String curr1, @RequestParam(value = "page", defaultValue = "0", required = false) String page, @RequestParam(value = "size", defaultValue = "10", required = false) String size) {
        return criptoService.getListPrices(curr1, page, size);
    }

    @GetMapping(value = "/csv")
    public void getCsvPrice() throws FileNotFoundException {
        File file = new File("cryptocurrencies.csv");
        List<String[]> criptoList = criptoService.getReport();
        try (PrintWriter pw = new PrintWriter(file)) {
            criptoList.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        }
    }

    public String convertToCSV(String[] data) {
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }

    public String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

}
