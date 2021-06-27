package com.grupofds.projetoTF.negocio.repositorios;

import java.time.LocalDateTime;
import java.util.List;

import com.grupofds.projetoTF.negocio.entidades.Reclamacao;
import com.grupofds.projetoTF.negocio.entidades.StatusReclamacoes;

public interface IRepositorioReclamacoes {
    Reclamacao createReclamacao(Reclamacao reclamacao);
    Reclamacao updateReclamacao(Reclamacao reclamacao);
    Reclamacao getById(Long id);
    List<Reclamacao> getByUsuario(Long id);
    List<Reclamacao> getReclamacoesByStatus(StatusReclamacoes status);
    List<Reclamacao> getByCategoria(String categoria);
    List<Reclamacao> getByBairro(String bairro);
    List<Reclamacao> getByPeriodo(LocalDateTime periodoInicial, LocalDateTime periodoFinal);
    List<Reclamacao> getReclamacoes();
}
