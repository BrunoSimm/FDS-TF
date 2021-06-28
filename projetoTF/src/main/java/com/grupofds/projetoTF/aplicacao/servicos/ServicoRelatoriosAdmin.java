package com.grupofds.projetoTF.aplicacao.servicos;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.grupofds.projetoTF.aplicacao.dtos.PercentualRespondidoByUserOficialDTO;
import com.grupofds.projetoTF.negocio.entidades.Comentario;
import com.grupofds.projetoTF.negocio.entidades.Reclamacao;
import com.grupofds.projetoTF.negocio.entidades.StatusReclamacoes;
import com.grupofds.projetoTF.negocio.entidades.usuarios.CategoriaDeUsuario;
import com.grupofds.projetoTF.negocio.entidades.usuarios.Usuario;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioComentarios;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioReclamacoes;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioUsuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
        this.validaUsuarioAdmin(usuarioId);
        return repositorioReclamacoes.getByCategoria(categoria).stream()
            .filter(repositorioReclamacoes.getByPeriodo(periodoInicial, periodoFinal)::contains)
            .count();
    }

    public Long getTotalReclamacoesByBairroAndPeriodo(Long usuarioId, String bairro, LocalDateTime periodoInicial, LocalDateTime periodoFinal) {
        this.validaUsuarioAdmin(usuarioId);
        return repositorioReclamacoes.getByBairro(bairro).stream()
            .filter(repositorioReclamacoes.getByPeriodo(periodoInicial, periodoFinal)::contains)
            .count();
    }

    public double getNumeroMedioComentariosByCategoria(Long usuarioId, String categoria) {
        this.validaUsuarioAdmin(usuarioId);
        List<Reclamacao> aux = repositorioReclamacoes.getByCategoria(categoria);
        int totalReclamacoes = aux.size();
        int totalComentarios = aux.stream()
            .reduce(0, (soma, reclamacao) -> soma + repositorioComentarios.getByReclamacao(reclamacao.getId()).size(), Integer::sum);
        return (100.0 * totalComentarios / totalReclamacoes);
    }

    public double getNumeroMedioComentariosByBairro(Long usuarioId, String bairro) {
        this.validaUsuarioAdmin(usuarioId);
        List<Reclamacao> aux = repositorioReclamacoes.getByBairro(bairro);
        int totalReclamacoes = aux.size();
        int totalComentarios = aux.stream()
            .reduce(0, (soma, reclamacao) -> soma + repositorioComentarios.getByReclamacao(reclamacao.getId()).size(), Integer::sum);
        return (100.0 * totalComentarios / totalReclamacoes);
    }

    public double getNumeroMedioComentariosByPeriodo(Long usuarioId, LocalDateTime periodoInicial, LocalDateTime periodoFinal) {
        this.validaUsuarioAdmin(usuarioId);
        List<Comentario> aux = repositorioComentarios.getByPeriodo(periodoInicial, periodoFinal);
        int totalComentarios = aux.size();
        int totalReclamacoes = aux.stream()
            .map(Comentario::getReclamacao)
            .collect(Collectors.toSet())
            .size();
        return (100.0 * totalComentarios / totalReclamacoes);
    }

    public double getPercentualResolvidoByCategoria(Long usuarioId, String categoria) {
        this.validaUsuarioAdmin(usuarioId);
        List<Reclamacao> aux = repositorioReclamacoes.getByCategoria(categoria);
        int totalReclamacoes = aux.size();
        int totalReclamacoesResolvidas = (int) aux.stream()
            .filter(r -> r.getStatus() == StatusReclamacoes.RESOLVIDA)
            .count();
        return (100.0 * totalReclamacoesResolvidas / totalReclamacoes);
    }
    
    public double getPercentualResolvidoByBairro(Long usuarioId, String bairro) {
        this.validaUsuarioAdmin(usuarioId);
        List<Reclamacao> aux = repositorioReclamacoes.getByBairro(bairro);
        int totalReclamacoes = aux.size();
        int totalReclamacoesResolvidas = (int) aux.stream()
            .filter(r -> r.getStatus() == StatusReclamacoes.RESOLVIDA)
            .count();
        return (100.0 * totalReclamacoesResolvidas / totalReclamacoes);
    }

    public double getPercentualEncerradoByCategoria(Long usuarioId, String categoria) {
        this.validaUsuarioAdmin(usuarioId);
        List<Reclamacao> aux = repositorioReclamacoes.getByCategoria(categoria);
        int totalReclamacoes = aux.size();
        int totalReclamacoesEncerradas = (int) aux.stream()
            .filter(r -> r.getStatus() == StatusReclamacoes.ENCERRADA)
            .count();
        return (100.0 * totalReclamacoesEncerradas / totalReclamacoes);
    }

    public double getPercentualEncerradoByBairro(Long usuarioId, String bairro) {
        this.validaUsuarioAdmin(usuarioId);
        List<Reclamacao> aux = repositorioReclamacoes.getByBairro(bairro);
        int totalReclamacoes = aux.size();
        int totalReclamacoesEncerradas = (int) aux.stream()
            .filter(r -> r.getStatus() == StatusReclamacoes.ENCERRADA)
            .count();
        return (100.0 * totalReclamacoesEncerradas / totalReclamacoes);
    }

    public double getPercentualRespondidoByUsersOficiais(Long usuarioId) {
        this.validaUsuarioAdmin(usuarioId);
        List<Reclamacao> aux = repositorioReclamacoes.getReclamacoes();
        int totalReclamacoes = aux.size();
        int totalReclamacoesRespondidas = (int) aux.stream()
            .filter(r -> r.getComentarios().stream().anyMatch(c -> c.getUsuario().getCategoriaDeUsuario() == CategoriaDeUsuario.USUARIO_OFICIAL))
            .count();
        return (100.0 * totalReclamacoesRespondidas / totalReclamacoes);
    }
    
    public PercentualRespondidoByUserOficialDTO getPercentualRespondidoByUserOficial(Long usuarioId, Long usuarioOficialId) {
    	this.validaUsuarioAdmin(usuarioId);
    	Usuario userOficial = repositorioUsuarios.getById(usuarioOficialId);
    	if (userOficial == null) {
    		throw new IllegalArgumentException("Usuario Oficial nao encontrado.");
    	}
    	if (userOficial.getCategoriaDeUsuario() != CategoriaDeUsuario.USUARIO_OFICIAL) {
    		throw new IllegalArgumentException("Usuario informado nao corresponde a um Usuario Oficial.");
    	}
        String nome = userOficial.getNome();
        List<Reclamacao> aux = repositorioReclamacoes.getReclamacoes();
        int totalReclamacoes = aux.size();
        int totalReclamacoesRespondidas = (int) aux.stream()
            .filter(r -> r.getComentarios().stream().anyMatch(c -> c.getUsuario().equals(userOficial)))
            .count();
        Double percentualRespondido = (100.0 * totalReclamacoesRespondidas / totalReclamacoes);
        return new PercentualRespondidoByUserOficialDTO(usuarioOficialId, nome, percentualRespondido);
    }

    public double getPercentualEncerradas(Long usuarioId) {
        this.validaUsuarioAdmin(usuarioId);
        List<Reclamacao> aux = repositorioReclamacoes.getReclamacoes();
        int totalReclamacoes = aux.size();
        int totalReclamacoesEncerradas = (int) aux.stream()
            .filter(r -> r.getStatus() == StatusReclamacoes.ENCERRADA)
            .count();
<<<<<<< HEAD
        return 100f * totalReclamacoesEncerradas / totalReclamacoes;
=======
        return (100.0 * totalReclamacoesEncerradas / totalReclamacoes);
>>>>>>> e5044b70d6b3031eec14cd162a8e7d705811353b
    }

    private void validaUsuarioAdmin(Long usuarioId) {
        if (repositorioUsuarios.getById(usuarioId).getCategoriaDeUsuario() != CategoriaDeUsuario.ADMINISTRADOR) {
            throw new IllegalArgumentException("Usuario sem permissao de acesso a funcao.");
        }
    }

}
