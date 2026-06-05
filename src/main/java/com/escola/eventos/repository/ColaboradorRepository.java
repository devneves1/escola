package com.escola.eventos.repository;

import com.escola.eventos.model.Colaborador;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ColaboradorRepository extends MongoRepository<Colaborador, String>{
}
