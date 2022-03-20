package com.oril.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CriptoDto {
    private String curr1;
    private String curr2;
    private Double lprice;
    private Date date;

    @Override
    public String toString() {
        return "CriptoDto{" +
                "curr1='" + curr1 + '\'' +
                ", curr2='" + curr2 + '\'' +
                ", lprice=" + lprice +
                ", date=" + date +
                '}';
    }
}
