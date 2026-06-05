package com.escola.eventos.repository;

import com.escola.eventos.model.Organizador;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrganizadorRepository extends MongoRepository<Organizador, String> {
}
