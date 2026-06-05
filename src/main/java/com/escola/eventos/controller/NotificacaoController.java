package com.escola.eventos.controller;

import com.escola.eventos.model.Notificacao;
import com.escola.eventos.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController {

    @Autowired
    public NotificacaoRepository notificacaoR;

    @GetMapping
    public List<Notificacao> listarNotificacoes(){
        return notificacaoR.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Notificacao> buscarId(@PathVariable String id){
        return notificacaoR.findById(id);
    }

    @PostMapping
    public ResponseEntity<Notificacao> criarNotificacao(@RequestBody Notificacao notificacao){
        Notificacao criada = notificacaoR.save(notificacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }

    @PutMapping
    public ResponseEntity<Notificacao> atualizarNotificacao(@PathVariable String id, @RequestBody Notificacao notificacao){
        notificacao.setId(id);
        Notificacao atualizada = notificacaoR.save(notificacao);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarNotificacao(@PathVariable String id){
        notificacaoR.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
