package com.grupofds.projetoTF.aplicacao.dtos;

public class PercentualEncerradoByBairroDTO {

    private String bairro;
    private double percentualEncerrado;
    
    public PercentualEncerradoByBairroDTO(String bairro, double percentualEncerrado) {
        this.bairro = bairro;
        this.percentualEncerrado = percentualEncerrado;
    }

    public String getBairro() {
        return bairro;
    }

    public double getPercentualEncerrado() {
        return percentualEncerrado;
    }

}
