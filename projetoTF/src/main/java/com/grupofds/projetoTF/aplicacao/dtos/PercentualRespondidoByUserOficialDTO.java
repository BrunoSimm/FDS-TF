package com.grupofds.projetoTF.aplicacao.dtos;

public class PercentualRespondidoByUserOficialDTO {

    private long userId;
    private String nome;
    private double percentualRespondido;
    
    public PercentualRespondidoByUserOficialDTO(long userId, String nome, double percentualRespondido) {
        this.userId = userId;
        this.nome = nome;
        this.percentualRespondido = percentualRespondido;
    }

    public long getUserId() {
        return userId;
    }

    public String getNome() {
        return nome;
    }

    public double getPercentualRespondido() {
        return percentualRespondido;
    }
    
}
