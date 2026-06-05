package com.escola.eventos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.escola.eventos.model.Avaliacao;


public interface AvaliacaoRepository extends MongoRepository<Avaliacao, String>{

}
