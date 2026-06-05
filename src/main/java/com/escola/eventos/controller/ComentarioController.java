package com.escola.eventos.controller;

import com.escola.eventos.model.Comentario;
import com.escola.eventos.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioRepository comentarioR;

    @GetMapping
    public List<Comentario> listarComentarios(){
        return comentarioR.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Comentario> buscarId(@PathVariable String id){
        return comentarioR.findById(id);
    }

    @PostMapping
    public ResponseEntity<Comentario> criarComentario(@RequestBody Comentario comentario){
        Comentario criado = comentarioR.save(comentario);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PutMapping
    public ResponseEntity<Comentario> atualizarComentario(@PathVariable String id, @RequestBody Comentario comentario){
        comentario.setId(id);
        Comentario atualizado = comentarioR.save(comentario);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarComentario(@PathVariable String id){
        comentarioR.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
