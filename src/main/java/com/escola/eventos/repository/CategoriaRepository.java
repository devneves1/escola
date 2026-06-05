package com.escola.eventos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.escola.eventos.model.Categoria;

public interface CategoriaRepository extends MongoRepository<Categoria, String>{

}