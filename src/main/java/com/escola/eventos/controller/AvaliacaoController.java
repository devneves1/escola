package com.escola.eventos.controller;

import com.escola.eventos.model.Avaliacao;
import com.escola.eventos.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoRepository avaliacaoR;

    @GetMapping
    public List<Avaliacao> listarAvaliacoes(){
        return avaliacaoR.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Avaliacao> buscarId(@PathVariable String id){
        return avaliacaoR.findById(id);
    }

    @PostMapping
    public ResponseEntity<Avaliacao> criarAvaliacao(@RequestBody Avaliacao avaliacao){
        Avaliacao criada = avaliacaoR.save(avaliacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }

    @PutMapping
    public ResponseEntity<Avaliacao> atualizarAvaliacao(@PathVariable String id, @RequestBody Avaliacao avaliacao){
        avaliacao.setId(id);
        Avaliacao atualizada = avaliacaoR.save(avaliacao);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarAvaliacao(@PathVariable String id){
        avaliacaoR.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
