package com.escola.eventos.controller;

import com.escola.eventos.model.Local;
import com.escola.eventos.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locais")
public class LocalController {

    @Autowired
    public LocalRepository localR;

    @GetMapping
    public List<Local> listarLocais(){
        return localR.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Local> buscarId(@PathVariable String id){
        return localR.findById(id);
    }

    @PostMapping
    public ResponseEntity<Local> criarLocal(@RequestBody Local local){
        Local criado = localR.save(local);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PutMapping
    public ResponseEntity<Local> atualizarLocal(@PathVariable String id, @RequestBody Local local){
        local.setId(id);
        Local atualizado = localR.save(local);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarLocal(@PathVariable String id){
        localR.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
