package com.oril.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Cripto")
public class Cripto {
    @Id
    private String id;
    private String curr1;
    private String curr2;
    private Double lprice;
    private Date date;

    @Override
    public String toString() {
        return "Cripto{" +
                "id=" + id +
                ", curr1='" + curr1 + '\'' +
                ", curr2='" + curr2 + '\'' +
                ", lprice=" + lprice +
                ", date=" + date +
                '}';
    }
}
