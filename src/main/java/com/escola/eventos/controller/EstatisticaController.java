package com.escola.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estatisticas")
public class EstatisticaController {

    @Autowired
    private MongoTemplate mongoT;

    @GetMapping("/comentarios-dos-eventos")
    public List<Document> CDE(){

        Aggregation comentarios = Aggregation.newAggregation(
                Aggregation.group("eventoId")
                        .count()
                        .as("totalComentarios")
        );

        return mongoT.aggregate(
                comentarios,
                "comentarios",
                Document.class
        ).getMappedResults();
    }

    @GetMapping("/media-das-avaliacoes")
    public List<Document> MDA(){

        Aggregation notas = Aggregation.newAggregation(
                Aggregation.group("eventoId")
                        .avg("nota")
                        .as("mediaDasNotas")

        );

        return mongoT.aggregate(
                notas,
                "notas",
                Document.class
        ).getMappedResults();
    }

    @GetMapping("/evento-com-categorias")
    public List<Document> ECC(){

        Aggregation categorias = Aggregation.newAggregation(
                Aggregation.lookup(
                        "categorias",
                        "categoriaId",
                        "_id",
                        "categoria"
                )
        );

        return mongoT.aggregate(
                categorias,
                "categorias",
                Document.class
        ).getMappedResults();
    }
}
