package com.escola.eventos.controller;

import com.escola.eventos.model.Inscricao;
import com.escola.eventos.repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {

    @Autowired
    private InscricaoRepository inscricaoR;

    @GetMapping
    public List<Inscricao> listarInscricoes(){
        return inscricaoR.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Inscricao> buscarId(@PathVariable String id){
        return inscricaoR.findById(id);
    }

    @PostMapping
    public ResponseEntity<Inscricao> criarInscricao(@RequestBody Inscricao inscricao){
        Inscricao criada = inscricaoR.save(inscricao);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }

    @PutMapping
    public ResponseEntity<Inscricao> atualizarInscricao(@PathVariable String id, @RequestBody Inscricao inscricao){
        inscricao.setId(id);
        Inscricao atualizada = inscricaoR.save(inscricao);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarInscricao(@PathVariable String id){
        inscricaoR.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
