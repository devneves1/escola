package com.escola.eventos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "avaliacoes")
public class Avaliacao {
    @Id
    private String id;
    private String usuariosId;
    private String eventoId;
    private int nota;
    private String dataAvaliacao;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }

    public void setUsuariosId(String usuariosId){
        this.usuariosId = usuariosId;
    }
    public String getUsuariosId(){
        return usuariosId;
    }

    public void setEventoId(String eventoId){
        this.eventoId = eventoId;
    }
    public String getEventoId(){
        return eventoId;
    }

    public void setNota(int nota){
        this.nota = nota;
    }
    public int getNota(){
        return nota;
    }

    public void setDataAvaliacao(String dataAvaliacao){
        this.dataAvaliacao = dataAvaliacao;
    }
    public String getDataAvaliacao(){
        return dataAvaliacao;
    }

}
