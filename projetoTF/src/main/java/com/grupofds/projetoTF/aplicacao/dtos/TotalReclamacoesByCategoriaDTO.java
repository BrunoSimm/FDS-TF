package com.grupofds.projetoTF.aplicacao.dtos;

public class TotalReclamacoesByCategoriaDTO {

    private String categoria;
    private long totalReclamacoes;
    
    public TotalReclamacoesByCategoriaDTO(String categoria, long totalReclamacoes) {
        this.categoria = categoria;
        this.totalReclamacoes = totalReclamacoes;
    }

    public String getCategoria() {
        return categoria;
    }

    public long getTotalReclamacoes() {
        return totalReclamacoes;
    }
    
}
