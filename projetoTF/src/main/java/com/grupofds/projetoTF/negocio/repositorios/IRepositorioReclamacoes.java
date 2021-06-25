package com.grupofds.projetoTF.negocio.repositorios;

import java.time.LocalDateTime;
import java.util.List;

import com.grupofds.projetoTF.negocio.entidades.Reclamacao;

public interface IRepositorioReclamacoes {
    public Reclamacao createReclamacao(Reclamacao reclamacao);
    public Reclamacao atualizaReclamacao(Reclamacao reclamacao);
    public Reclamacao getById(Long id);
    public List<Reclamacao> getByUsuario(Long id);
    public List<Reclamacao> getByCategoria(String categoria);
    public List<Reclamacao> getByBairro(String bairro);
    public List<Reclamacao> getByPeriodo(LocalDateTime periodo);
}
