package com.escola.eventos.controller;

import com.escola.eventos.repository.CategoriaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.escola.eventos.model.Categoria;
import com.escola.eventos.repository.CategoriaRepository;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/categorias")
public class CategoriaController{

    @Autowired
    private CategoriaRepository categoriaR;

    @GetMapping
    public List<Categoria> listarCategorias(){
        return categoriaR.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Categoria> buscarId(@PathVariable String id){
        return categoriaR.findById(id);
    }

    @PostMapping
    public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria){
        Categoria criada = categoriaR.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable String id, @RequestBody Categoria categoria){
        categoria.setId(id);
        Categoria atualizada = categoriaR.save(categoria);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCategoria(@PathVariable String id){
        categoriaR.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}