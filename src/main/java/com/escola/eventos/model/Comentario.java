package com.escola.eventos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comentarios")
public class Comentario {

    @Id
    private String id;
    private String usuarioId;
    private String eventoId;
    private String texto;
    private String dataComentario;

    public void setId(String id) {
        this.id = id;
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

    public void setTexto(String texto){
        this.texto = texto;
    }
    public String getTexto(){
        return texto;
    }

    public void setDataComentario(String dataComentario){
        this.dataComentario = dataComentario;
    }
    public String getDataComentario(){
        return dataComentario;
    }
}
