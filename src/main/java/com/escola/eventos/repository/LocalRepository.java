package com.escola.eventos.repository;

import com.escola.eventos.model.Local;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocalRepository extends MongoRepository<Local, String> {

}
