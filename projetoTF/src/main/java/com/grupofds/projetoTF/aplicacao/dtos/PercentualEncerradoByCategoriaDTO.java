package com.grupofds.projetoTF.aplicacao.dtos;

public class PercentualEncerradoByCategoriaDTO {

    private String categoria;
    private double percentualEncerrado;
    
    public PercentualEncerradoByCategoriaDTO(String categoria, double percentualEncerrado) {
        this.categoria = categoria;
        this.percentualEncerrado = percentualEncerrado;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPercentualEncerrado() {
        return percentualEncerrado;
    }

}
