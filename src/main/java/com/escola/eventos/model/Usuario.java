package com.escola.eventos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class Usuario {

    @Id
    private String id;
    private int matricula;
    private String nome;
    private String email;
    private String senha;
    private String tipo;
    private boolean ativo;
    private String disciplina;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }

    public void setMatricula(int matricula){
        this.matricula = matricula;
    }
    public int getMatricula(){
        return matricula;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

    public void setSenha(String senha){
        this.senha  = senha;
    }
    public String getSenha(){
        return senha;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public String getTipo(){
        return tipo;
    }

    public void setAtivo(boolean ativo){
        this.ativo = ativo;
    }
    public boolean isAtivo(){
        return ativo;
    }

    public void setDisciplina(String disciplina){
        this.disciplina = disciplina;
    }
    public String getDisciplina(){
        return disciplina;
    }
}
