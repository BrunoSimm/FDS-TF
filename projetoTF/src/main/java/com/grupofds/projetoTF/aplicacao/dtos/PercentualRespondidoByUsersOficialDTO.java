package com.grupofds.projetoTF.aplicacao.dtos;

public class PercentualRespondidoByUsersOficialDTO {

    private long userId;
    private double percentualRespondido;
    
    public PercentualRespondidoByUsersOficialDTO(long userId, double percentualRespondido) {
        this.userId = userId;
        this.percentualRespondido = percentualRespondido;
    }

    public long getUserId() {
        return userId;
    }

    public double getPercentualRespondido() {
        return percentualRespondido;
    }
    
}
