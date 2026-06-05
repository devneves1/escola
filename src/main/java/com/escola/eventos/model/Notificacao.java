package com.escola.eventos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notificacoes")
public class Notificacao {

    @Id
    private String id;
    private String usuarioId;
    private String eventoId;
    private String mensagem;
    private String dataEnvio;
    private boolean lida;

    public void setId(String id){
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

    public void setMensagem(String mensagem){
        this.mensagem = mensagem;
    }
    public String getMensagem(){
        return mensagem;
    }

    public void setDataEnvio(String dataEnvio){
        this.dataEnvio = dataEnvio;
    }
    public String getDataEnvio(){
        return dataEnvio;
    }

    public void setLida(boolean lida){
        this.lida = lida;
    }
    public boolean isLida(){
        return lida;
    }
}
