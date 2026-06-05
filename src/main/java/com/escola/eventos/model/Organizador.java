package com.escola.eventos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "organizadores")
public class Organizador {
    @Id
    private String id;
    private String nome;
    private String email;
    private String cargo;
    private int telefone;
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

    public void setEmail(String email){
        this.email= email;
    }
    public String getEmail(){
        return email;
    }

    public void setCargo(String cargo){
        this.cargo = cargo;
    }
    public String getCargo(){
        return cargo;
    }

    public void setTelefone(int telefone){
        this.telefone = telefone;
    }
    public int getTelefone(){
        return telefone;
    }

    public void setAtivo(boolean ativo){
        this.ativo = ativo;
    }
    public boolean isAtivo(){
        return ativo;
    }
}
