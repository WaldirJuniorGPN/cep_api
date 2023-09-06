package com.cepApi.cep_api.repository;

import com.cepApi.cep_api.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
