package com.cepApi.cep_api.controller;

import com.cepApi.cep_api.dto.request.DadosCadastroEndereco;
import com.cepApi.cep_api.dto.request.DadosEnderecoCompleto;
import com.cepApi.cep_api.dto.response.DadosDetalhamentoEndereco;
import com.cepApi.cep_api.model.Endereco;
import com.cepApi.cep_api.repository.EnderecoRepository;
import com.cepApi.cep_api.service.ConsumoAPI;
import com.cepApi.cep_api.service.ConverteDados;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository repository;
    @Autowired
    private ConsumoAPI consumoAPI;
    @Autowired
    private ConverteDados conversor;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroEndereco dados, UriComponentsBuilder uriComponentsBuilder) {
        var json = consumoAPI.obterEndereco(dados);
        var dadosEnderecoCompleto = conversor.obterDados(json, DadosEnderecoCompleto.class);
        var endereco = new Endereco(dadosEnderecoCompleto);
        repository.save(endereco);
        var uri = uriComponentsBuilder.path("/endereco/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoEndereco(endereco));
    }
}
