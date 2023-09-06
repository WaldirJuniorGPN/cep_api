package com.cepApi.cep_api.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEnderecoCompleto(
        Integer cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf,
        Integer ibge

) {
}
