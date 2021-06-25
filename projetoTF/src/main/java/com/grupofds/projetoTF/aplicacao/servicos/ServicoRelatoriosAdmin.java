package com.grupofds.projetoTF.aplicacao.servicos;

import java.time.LocalDateTime;
import java.util.List;

import com.grupofds.projetoTF.negocio.entidades.Reclamacao;
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
        // TODO: acessar repositorio de usuario
        // TODO: cadê o getCategoriaDeUsuario???????????????
        // if (usuario.categoria)
        return repositorioReclamacoes.getByCategoria(categoria).stream()
            .filter(r -> !r.getData().isBefore(periodoInicial) && !r.getData().isAfter(periodoFinal))
            .count();
    }

    public Long getTotalReclamacoesByBairroAndPeriodo(Long usuarioId, String bairro, LocalDateTime periodoInicial, LocalDateTime periodoFinal) {
        return repositorioReclamacoes.getByBairro(bairro).stream()
            .filter(r -> !r.getData().isBefore(periodoInicial) && !r.getData().isAfter(periodoFinal))
            .count();
    }

    public double getNumeroMedioComentariosByCategoria(Long usuarioId, String categoria) {
        List<Reclamacao> aux = repositorioReclamacoes.getByCategoria(categoria);
        int totalReclamacoes = aux.size();
        int totalComentarios = aux.stream()
            .reduce(0, (soma, reclamacao) -> soma + repositorioComentarios.getByReclamacao(reclamacao.getId()).size(), Integer::sum);
        return (double) (totalComentarios / totalReclamacoes);
    }

    public double getNumeroMedioComentariosByBairro(Long usuarioId, String bairro) {
        List<Reclamacao> aux = repositorioReclamacoes.getByBairro(bairro);
        int totalReclamacoes = aux.size();
        int totalComentarios = aux.stream()
            .reduce(0, (soma, reclamacao) -> soma + repositorioComentarios.getByReclamacao(reclamacao.getId()).size(), Integer::sum);
        return (double) (totalComentarios / totalReclamacoes);
    }

    public double getNumeroMedioComentariosByPeriodo(Long usuarioId, LocalDateTime periodo) {
        //TODO: comentario deve ter DATA/HORA?

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
