package com.escola.eventos.repository;

import com.escola.eventos.model.Inscricao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InscricaoRepository extends MongoRepository<Inscricao, String> {

}
