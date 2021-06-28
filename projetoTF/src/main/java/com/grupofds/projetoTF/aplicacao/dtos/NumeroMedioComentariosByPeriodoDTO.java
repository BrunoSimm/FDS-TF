package com.grupofds.projetoTF.aplicacao.dtos;

import java.time.LocalDateTime;

public class NumeroMedioComentariosByPeriodoDTO {

    private LocalDateTime periodoInicial;
    private LocalDateTime periodoFinal;
    private double mediaComentarios;
    
    public NumeroMedioComentariosByPeriodoDTO(LocalDateTime periodoInicial, LocalDateTime periodoFinal,
            double mediaComentarios) {
        this.periodoInicial = periodoInicial;
        this.periodoFinal = periodoFinal;
        this.mediaComentarios = mediaComentarios;
    }

    public LocalDateTime getPeriodoInicial() {
        return periodoInicial;
    }
    
    public LocalDateTime getPeriodoFinal() {
        return periodoFinal;
    }

    public double getMediaComentarios() {
        return mediaComentarios;
    }

}
