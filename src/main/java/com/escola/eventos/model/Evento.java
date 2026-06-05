package com.escola.eventos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "eventos")
public class Evento {

    @Id
    private String id;
    private String nome;
    private String data;
    private String horario;
    private String categoriaId;
    private String localId;
    private String organizadorId;
    private int vagas;
    private String status;

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

    public void setData(String data){
        this.data = data;
    }
    public String getData(){
        return data;
    }

    public void setHorario(String horario){
        this.horario = horario;
    }
    public String getHorario(){
        return horario;
    }

    public void setCategoriaId(String categoriaId){
        this.categoriaId = categoriaId;
    }
    public String getCategoriaId(){
        return categoriaId;
    }

    public void setLocalId(String localId){
        this.localId = localId;
    }
    public String getLocalId(){
        return localId;
    }

    public void setOrganizadorId(String organizadorId){
        this.organizadorId = organizadorId;
    }
    public String getOrganizadorId(){
        return organizadorId;
    }

    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return status;
    }
}
