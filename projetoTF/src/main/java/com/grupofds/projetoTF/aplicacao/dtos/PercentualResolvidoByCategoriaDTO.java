package com.grupofds.projetoTF.aplicacao.dtos;

public class PercentualResolvidoByCategoriaDTO {

    private String categoria;
    private double percentualResolvido;
    
    public PercentualResolvidoByCategoriaDTO(String categoria, double percentualResolvido) {
        this.categoria = categoria;
        this.percentualResolvido = percentualResolvido;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPercentualResolvido() {
        return percentualResolvido;
    }

}
