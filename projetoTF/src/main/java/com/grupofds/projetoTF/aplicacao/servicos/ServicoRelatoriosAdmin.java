package com.grupofds.projetoTF.aplicacao.servicos;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.grupofds.projetoTF.negocio.entidades.Comentario;
import com.grupofds.projetoTF.negocio.entidades.Reclamacao;
import com.grupofds.projetoTF.negocio.entidades.StatusReclamacoes;
import com.grupofds.projetoTF.negocio.entidades.usuarios.CategoriaDeUsuario;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioComentarios;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioReclamacoes;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioUsuarios;

import org.springframework.beans.factory.annotation.Autowired;

public class ServicoRelatoriosAdmin {
    private IRepositorioReclamacoes repositorioReclamacoes;
    private IRepositorioComentarios repositorioComentarios;
    private IRepositorioUsuarios repositorioUsuarios;

    @Autowired
    public ServicoRelatoriosAdmin(IRepositorioReclamacoes repositorioReclamacoes,
            IRepositorioComentarios repositorioComentarios,
            IRepositorioUsuarios repositorioUsuarios) {
        this.repositorioReclamacoes = repositorioReclamacoes;
        this.repositorioComentarios = repositorioComentarios;
        this.repositorioUsuarios = repositorioUsuarios;
    }

    public Long getTotalReclamacoesByCategoriaAndPeriodo(Long usuarioId, String categoria, LocalDateTime periodoInicial, LocalDateTime periodoFinal) {
        this.validaUsuario(usuarioId);
        return repositorioReclamacoes.getByCategoria(categoria).stream()
            //.filter(r -> !r.getData().isBefore(periodoInicial) && !r.getData().isAfter(periodoFinal)) => LOGICA PARA A FUNÇÃO DE REPOSITORIO
            .filter(repositorioReclamacoes.getByPeriodo(periodoInicial, periodoFinal)::contains)
            .count();
    }

    public Long getTotalReclamacoesByBairroAndPeriodo(Long usuarioId, String bairro, LocalDateTime periodoInicial, LocalDateTime periodoFinal) {
        this.validaUsuario(usuarioId);
        return repositorioReclamacoes.getByBairro(bairro).stream()
            .filter(repositorioReclamacoes.getByPeriodo(periodoInicial, periodoFinal)::contains)
            .count();
    }

    public double getNumeroMedioComentariosByCategoria(Long usuarioId, String categoria) {
        this.validaUsuario(usuarioId);
        List<Reclamacao> aux = repositorioReclamacoes.getByCategoria(categoria);
        int totalReclamacoes = aux.size();
        int totalComentarios = aux.stream()
            .reduce(0, (soma, reclamacao) -> soma + repositorioComentarios.getByReclamacao(reclamacao.getId()).size(), Integer::sum);
        return (double) (totalComentarios / totalReclamacoes);
    }

    public double getNumeroMedioComentariosByBairro(Long usuarioId, String bairro) {
        this.validaUsuario(usuarioId);
        List<Reclamacao> aux = repositorioReclamacoes.getByBairro(bairro);
        int totalReclamacoes = aux.size();
        int totalComentarios = aux.stream()
            .reduce(0, (soma, reclamacao) -> soma + repositorioComentarios.getByReclamacao(reclamacao.getId()).size(), Integer::sum);
        return (double) (totalComentarios / totalReclamacoes);
    }

    public double getNumeroMedioComentariosByPeriodo(Long usuarioId, LocalDateTime periodoInicial, LocalDateTime periodoFinal) {
        this.validaUsuario(usuarioId);
        //TODO: a media eh sobre reclamacoes???
        List<Comentario> aux = repositorioComentarios.getByPeriodo(periodoInicial, periodoFinal);
        int totalComentarios = aux.size();
        int totalReclamacoes = aux.stream()
            .map(Comentario::getReclamacao)
            .collect(Collectors.toSet())
            .size();
        return (double) (totalComentarios / totalReclamacoes);
    }

    public double getPercentualResolvidoByCategoria(Long usuarioId, String categoria) {
        this.validaUsuario(usuarioId);
        List<Reclamacao> aux = repositorioReclamacoes.getByCategoria(categoria);
        int totalReclamacoes = aux.size();
        int totalReclamacoesResolvidas = (int) aux.stream()
            .filter(r -> r.getStatus() == StatusReclamacoes.RESOLVIDA)
            .count();
        return (double) (totalReclamacoesResolvidas / totalReclamacoes);
    }
    
    public double getPercentualResolvidoByBairro(Long usuarioId, String bairro) {
        this.validaUsuario(usuarioId);
        List<Reclamacao> aux = repositorioReclamacoes.getByBairro(bairro);
        int totalReclamacoes = aux.size();
        int totalReclamacoesResolvidas = (int) aux.stream()
            .filter(r -> r.getStatus() == StatusReclamacoes.RESOLVIDA)
            .count();
        return (double) (totalReclamacoesResolvidas / totalReclamacoes);
    }

    public double getPercentualEncerradoByCategoria(Long usuarioId, String categoria) {
        this.validaUsuario(usuarioId);
        List<Reclamacao> aux = repositorioReclamacoes.getByCategoria(categoria);
        int totalReclamacoes = aux.size();
        int totalReclamacoesEncerradas = (int) aux.stream()
            .filter(r -> r.getStatus() == StatusReclamacoes.ENCERRADA)
            .count();
        return (double) (totalReclamacoesEncerradas / totalReclamacoes);
    }

    public double getPercentualEncerradoByBairro(Long usuarioId, String bairro) {
        this.validaUsuario(usuarioId);
        List<Reclamacao> aux = repositorioReclamacoes.getByBairro(bairro);
        int totalReclamacoes = aux.size();
        int totalReclamacoesEncerradas = (int) aux.stream()
            .filter(r -> r.getStatus() == StatusReclamacoes.ENCERRADA)
            .count();
        return (double) (totalReclamacoesEncerradas / totalReclamacoes);
    }

    public double getPercentualRespondidoByUserOficial(Long usuarioId, Long idUsuarioOficial) {
        this.validaUsuario(usuarioId);
        List<Reclamacao> aux = repositorioReclamacoes.getReclamacoes();
        int totalReclamacoes = aux.size();
        int totalReclamacoesRespondidas = (int) aux.stream()
            .filter(r -> r.getComentarios().stream().anyMatch(c -> c.getUsuario().getCategoriaDeUsuario() == CategoriaDeUsuario.USUARIO_OFICIAL))
            .count();
        return (double) (totalReclamacoesRespondidas / totalReclamacoes);

    }

    public double getPercentualEncerradasByUserOficial(Long usuarioId, Long idUsuarioOficial) {
        this.validaUsuario(usuarioId);
        List<Reclamacao> aux = repositorioReclamacoes.getReclamacoes();
        int totalReclamacoes = aux.size();
        int totalReclamacoesEncerradas = (int) aux.stream()
            .filter(r -> r.getStatus() == StatusReclamacoes.ENCERRADA)
            .count();
        return (double) (totalReclamacoesEncerradas / totalReclamacoes);

    }

    private void validaUsuario(Long usuarioId) {
        if (repositorioUsuarios.getById(usuarioId).getCategoriaDeUsuario() != CategoriaDeUsuario.ADMINISTRADOR) {
            // TODO: decidir sobre excecoes
            throw new IllegalArgumentException("Usuario sem permissao de acesso a funcao.");
        }
    }

}
