package com.escola.eventos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "locais")
public class Local {

    @Id
    private String id;
    private String nome;
    private int capacidade;
    private String descricao;
    private boolean disponivel;

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

    public void setCapacidade(int capacidade){
        this.capacidade = capacidade;
    }
    public int getCapacidade(){
        return capacidade;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return descricao;
    }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }
    public boolean isDisponivel(){
        return disponivel;
    }
}
