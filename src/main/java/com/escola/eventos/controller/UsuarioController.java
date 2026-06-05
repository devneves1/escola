package com.escola.eventos.controller;

import com.escola.eventos.model.Organizador;
import com.escola.eventos.model.Usuario;
import com.escola.eventos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    public UsuarioRepository usuarioR;

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarioR.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> buscarId(@PathVariable String id){
        return usuarioR.findById(id);
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario){
        Usuario criado = usuarioR.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PutMapping
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable String id, @RequestBody Usuario usuario){
        usuario.setId(id);
        Usuario atualizado = usuarioR.save(usuario);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuario(@PathVariable String id){
        usuarioR.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
