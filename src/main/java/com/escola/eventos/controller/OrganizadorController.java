package com.escola.eventos.controller;

import com.escola.eventos.model.Notificacao;
import com.escola.eventos.model.Organizador;
import com.escola.eventos.repository.OrganizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/organizadores")
public class OrganizadorController {

    @Autowired
    public OrganizadorRepository organizadorR;

    @GetMapping
    public List<Organizador> listarOrganizadores(){
        return organizadorR.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Organizador> buscarId(@PathVariable String id){
        return organizadorR.findById(id);
    }

    @PostMapping
    public ResponseEntity<Organizador> criarOrganizador(@RequestBody Organizador organizador){
        Organizador criado = organizadorR.save(organizador);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PutMapping
    public ResponseEntity<Organizador> atualizarOrganizador(@PathVariable String id, @RequestBody Organizador organizador){
        organizador.setId(id);
        Organizador atualizado = organizadorR.save(organizador);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarOrganizador(@PathVariable String id){
        organizadorR.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
