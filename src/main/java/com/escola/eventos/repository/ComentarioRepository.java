package com.escola.eventos.repository;

import com.escola.eventos.model.Comentario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComentarioRepository extends MongoRepository<Comentario, String> {
}
