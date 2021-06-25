package com.grupofds.projetoTF.negocio.repositorios;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.negocio.entidades.Comentario;
import com.grupofds.projetoTF.negocio.entidades.Reclamacao;
import com.grupofds.projetoTF.negocio.entidades.StatusReclamacoes;

@Component
public interface IRepositorioReclamacoes {
    public Reclamacao createReclamacao(Reclamacao reclamacao);
    public Reclamacao updateReclamacao(Reclamacao reclamacao);
    public Reclamacao getById(Long id);
    public List<Reclamacao> getByUsuario(Long id);
    List<Reclamacao> getReclamacoesByStatus(StatusReclamacoes status);
    public List<Reclamacao> getByCategoria(String categoria);
    public List<Reclamacao> getByBairro(String bairro);
    public List<Reclamacao> getByPeriodo(LocalDateTime periodoInicial, LocalDateTime periodoFinal);
    public List<Reclamacao> getReclamacoes();
    List<Comentario> getAllComentarios(Reclamacao reclamacao);
}
