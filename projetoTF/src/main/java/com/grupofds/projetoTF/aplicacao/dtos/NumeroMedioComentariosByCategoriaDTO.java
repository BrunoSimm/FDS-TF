package com.grupofds.projetoTF.aplicacao.dtos;

public class NumeroMedioComentariosByCategoriaDTO {
    
    private String categoria;
    private double mediaComentarios;
    
    public NumeroMedioComentariosByCategoriaDTO(String categoria, double mediaComentarios) {
        this.categoria = categoria;
        this.mediaComentarios = mediaComentarios;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getMediaComentarios() {
        return mediaComentarios;
    }

}
