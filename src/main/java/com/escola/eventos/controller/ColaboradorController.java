package com.escola.eventos.controller;

import com.escola.eventos.model.Colaborador;
import com.escola.eventos.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorRepository colaboradorR;

    @GetMapping
    public List<Colaborador> listarColaboradores(){
        return colaboradorR.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Colaborador> buscarId(@PathVariable String id){
        return colaboradorR.findById(id);
    }

    @PostMapping
    public ResponseEntity<Colaborador> criarColaborador(@RequestBody Colaborador colaborador){
        Colaborador criado = colaboradorR.save(colaborador);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PutMapping
    public ResponseEntity<Colaborador> atualizarColaborador(@PathVariable String id, @RequestBody Colaborador colaborador){
        colaborador.setId(id);
        Colaborador atualizado = colaboradorR.save(colaborador);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarColaborador(@PathVariable String id){
        colaboradorR.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
