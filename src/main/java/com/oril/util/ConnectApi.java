package com.oril.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oril.dto.CriptoDto;
import org.springframework.stereotype.Component;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Date;

@Component
public class ConnectApi {
    private String urle;

    public String getUrle() {
        return urle;
    }

    public void setUrle(String urle) {
        this.urle = urle;
    }

    public CriptoDto get() {
        HttpsURLConnection con = null;
        try {
            URL url = new URL(urle);
            con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("accept", "*/*");
            con.setRequestProperty("connection", "Keep-Alive");
            con.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            con.setConnectTimeout(30000);
            con.connect();

            int resp = con.getResponseCode();
            if (resp == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                    sb.append("\n");
                }
                br.close();
                ObjectMapper mapper = new ObjectMapper();
                CriptoDto criptoDto = mapper.readValue(sb.toString(), CriptoDto.class);
                criptoDto.setDate(new Date());
                return criptoDto;
            } else {
                System.out.println("Ответ сервера: " + resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.disconnect();
        }
        return null;
    }

}
