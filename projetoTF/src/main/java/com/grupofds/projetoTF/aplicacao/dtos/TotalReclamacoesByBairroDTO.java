package com.grupofds.projetoTF.aplicacao.dtos;

public class TotalReclamacoesByBairroDTO {
    
    private String bairro;
    private long totalReclamacoes;
    
    public TotalReclamacoesByBairroDTO(String bairro, long totalReclamacoes) {
        this.bairro = bairro;
        this.totalReclamacoes = totalReclamacoes;
    }

    public String getBairro() {
        return bairro;
    }

    public long getTotalReclamacoes() {
        return totalReclamacoes;
    }    

}
