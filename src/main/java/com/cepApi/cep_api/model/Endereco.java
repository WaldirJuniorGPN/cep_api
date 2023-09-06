package com.cepApi.cep_api.model;

import com.cepApi.cep_api.dto.request.DadosCadastroEndereco;
import com.cepApi.cep_api.dto.request.DadosEnderecoCompleto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Endereco")
@Table(name = "enderecos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private Integer ibge;

    public Endereco(DadosEnderecoCompleto dados) {
        this.cep = dados.cep();
        this.logradouro = dados.logradouro();
        this.complemento = dados.complemento();
        this.bairro = dados.bairro();
        this.uf = dados.uf();
        this.localidade = dados.localidade();
        this.ibge = dados.ibge();
    }
}
