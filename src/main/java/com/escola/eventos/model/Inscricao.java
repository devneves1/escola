package com.escola.eventos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "/incricoes")
public class Inscricao {

    @Id
    private String id;
    private String usuarioId;
    private String eventoId;
    private String dataInscricao;
    private String status;

    public void setId(String id){
        this.id =id;
    }
    public String getId(){
        return id;
    }

    public void setUsuarioId(String usuarioId){
        this.usuarioId = usuarioId;
    }
    public String getUsuarioId(){
        return usuarioId;
    }

    public void setEventoId(String eventoId){
        this.eventoId = eventoId;
    }
    public String getEventoId(){
        return eventoId;
    }

    public void setDataInscricao(String dataInscricao){
        this.dataInscricao = dataInscricao;
    }
    public String getDataInscricao(){
        return dataInscricao;
    }

    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return status;
    }

}
