package com.grupofds.projetoTF.aplicacao.dtos;

import java.time.LocalDateTime;

public class NumeroMedioComentariosByPeriodoDTO {

    private LocalDateTime periodo;
    private double mediaComentarios;
    
    public NumeroMedioComentariosByPeriodoDTO(LocalDateTime periodo, double mediaComentarios) {
        this.periodo = periodo;
        this.mediaComentarios = mediaComentarios;
    }

    public LocalDateTime getPeriodo() {
        return periodo;
    }

    public double getMediaComentarios() {
        return mediaComentarios;
    }

}
