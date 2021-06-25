package com.grupofds.projetoTF.aplicacao.dtos;

public class PercentualResolvidoByBairroDTO {

    private String bairro;
    private double percentualResolvido;
    
    public PercentualResolvidoByBairroDTO(String bairro, double percentualResolvido) {
        this.bairro = bairro;
        this.percentualResolvido = percentualResolvido;
    }

    public String getBairro() {
        return bairro;
    }

    public double getPercentualResolvido() {
        return percentualResolvido;
    }

}
