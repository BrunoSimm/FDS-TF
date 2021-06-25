package com.grupofds.projetoTF.aplicacao.dtos;

public class NumeroMedioComentariosByBairroDTO {

    private String bairro;
    private double mediaComentarios;
    
    public NumeroMedioComentariosByBairroDTO(String bairro, double mediaComentarios) {
        this.bairro = bairro;
        this.mediaComentarios = mediaComentarios;
    }

    public String getBairro() {
        return bairro;
    }

    public double getMediaComentarios() {
        return mediaComentarios;
    }
 
}
