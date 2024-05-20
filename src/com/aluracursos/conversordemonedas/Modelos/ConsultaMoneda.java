package com.aluracursos.conversordemonedas.Modelos;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    public Monedas buscarMoneda(String monedaOrigen, String monedaDestino){

        String url="https://v6.exchangerate-api.com/v6/40a16a688ce5bae3ec5bad31/pair/"+monedaOrigen+"/"+monedaDestino;

        URI direccion=URI.create(url);

        HttpClient client= HttpClient.newHttpClient();
        HttpRequest request= HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response= null;

            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Monedas.class);

        } catch (Exception e) {
            throw new RuntimeException("No hubo resultado posible para estas monedas");
        }
    }

}
