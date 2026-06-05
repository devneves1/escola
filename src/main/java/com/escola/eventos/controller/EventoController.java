package com.escola.eventos.controller;

import com.escola.eventos.model.Evento;
import com.escola.eventos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoRepository eventoR;

    @GetMapping
    public List<Evento> listarEventos(){
        return eventoR.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Evento> buscarId(@PathVariable String id){
        return eventoR.findById(id);
    }

    @PostMapping
    public ResponseEntity<Evento> criarEvento(@RequestBody Evento evento){
        Evento criado = eventoR.save(evento);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PostMapping
    public ResponseEntity<Evento> atualizarEvento(@PathVariable String id, @RequestBody Evento evento){
        evento.setId(id);
        Evento atualizado = eventoR.save(evento);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarEvento(@PathVariable String id){
        eventoR.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
