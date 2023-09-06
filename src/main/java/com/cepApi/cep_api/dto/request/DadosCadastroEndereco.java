package com.cepApi.cep_api.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroEndereco(
        @NotNull
        @Min(8)
        Integer cep
) {
}
