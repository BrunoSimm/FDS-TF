package com.grupofds.projetoTF.aplicacao.servicos;

import java.time.LocalDateTime;

import com.grupofds.projetoTF.negocio.repositorios.IRepositorioComentarios;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioReclamacoes;

import org.springframework.beans.factory.annotation.Autowired;

public class ServicoRelatoriosAdmin {
    private IRepositorioReclamacoes repositorioReclamacoes;
    private IRepositorioComentarios repositorioComentarios;

    @Autowired
    public ServicoRelatoriosAdmin(IRepositorioReclamacoes repositorioReclamacoes,
            IRepositorioComentarios repositorioComentarios) {
        this.repositorioReclamacoes = repositorioReclamacoes;
        this.repositorioComentarios = repositorioComentarios;
    }

    public Long getTotalReclamacoesByCategoriaAndPeriodo(Long usuarioId, String categoria, LocalDateTime periodoInicial, LocalDateTime periodoFinal) {
        return repositorioReclamacoes.getByCategoria(categoria).stream()
            .filter(r -> !r.getData().isBefore(periodoInicial) && !r.getData().isAfter(periodoFinal))
            .count();
    }

    public int getTotalReclamacoesByBairroAndPeriodo(Long usuarioId, String bairro, LocalDateTime periodoInicial, LocalDateTime periodoFinal) {
        //TODO: logica
    }

    public double getNumeroMedioComentariosByCategoria(Long usuarioId, String categoria) {
        //TODO: logica
    }

    public double getNumeroMedioComentariosByBairro(Long usuarioId, String bairro) {
        //TODO: logica
    }

    public double getNumeroMedioComentariosByPeriodo(Long usuarioId, LocalDateTime periodo) {
        //TODO: logica
    }

    public double getPercentualResolvidoByCategoria(Long usuarioId, String categoria) {
        //TODO: logica
    }
    
    public double getPercentualResolvidoByBairro(Long usuarioId, String bairro) {
        //TODO: logica        
    }

    public double getPercentualEncerradoByCategoria(Long usuarioId, String categoria) {
        //TODO: logica        
    }

    public double getPercentualEncerradoByBairro(Long usuarioId, String bairro) {
        //TODO: logica
    }

    public double getPercentualRespondidoByUserOficial(Long idUsuarioOficial) {
        //TODO: logica
    }
    
}
