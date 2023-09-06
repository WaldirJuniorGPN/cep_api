package com.cepApi.cep_api.dto.response;

import com.cepApi.cep_api.model.Endereco;

public record DadosDetalhamentoEndereco(Long id, Integer cep, String logradouro, String complemento, String bairro,
                                        String localidade, String uf, Integer ibge) {
    public DadosDetalhamentoEndereco(Endereco endereco) {
        this(endereco.getId(), endereco.getCep(), endereco.getLogradouro(), endereco.getComplemento(), endereco.getBairro(), endereco.getLocalidade(), endereco.getUf(), endereco.getIbge());
    }
}
