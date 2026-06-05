package com.escola.eventos.repository;

import com.escola.eventos.model.Notificacao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificacaoRepository extends MongoRepository<Notificacao, String> {

}
