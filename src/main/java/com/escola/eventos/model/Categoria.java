package com.escola.eventos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categorias")
    public class Categoria{

    @Id
    private String id;
    private String nome;
    private String descricao;
    private boolean ativo;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return descricao;
    }

    public void setAtivo(boolean ativo){
        this.ativo = ativo;
    }
    public boolean isAtivo(){
        return ativo;
    }

}