package com.cepApi.cep_api.service;

import com.cepApi.cep_api.dto.request.DadosCadastroEndereco;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ConsumoAPI {
    private final String URL_INICIO = "http://viacep.com.br/ws/";
    private final String URL_FINAL = "/json/";

    public String obterEndereco(DadosCadastroEndereco dados) {

        var urlCompleta = URL_INICIO + dados.cep() + URL_FINAL;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlCompleta))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        return json;
    }
}

