package com.escola.eventos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "colaboradores")
public class Colaborador {

    @Id
    private String id;
    private String nome;
    private String contato;
    private String eventoId;
    private String contribuicao;
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

    public void setContato(String contato){
        this.contato = contato;
    }
    public String getContato(){
        return contato;
    }

    public void setEventoId(String eventoId){
        this.eventoId = eventoId;
    }
    public String getEventoId(){
        return eventoId;
    }

    public void setContribuicao(String contribuicao){
        this.contribuicao = contribuicao;
    }
    public String getContribuicao(){
        return contribuicao;
    }

    public void setAtivo(boolean ativo){
        this.ativo = ativo;
    }
    public boolean isAtivo(){
        return ativo;
    }
}
