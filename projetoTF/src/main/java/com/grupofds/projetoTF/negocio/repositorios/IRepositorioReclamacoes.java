package com.grupofds.projetoTF.negocio.repositorios;

import java.time.LocalDateTime;

import com.grupofds.projetoTF.negocio.entidades.Reclamacao;

public interface IRepositorioReclamacoes {
    public Reclamacao createReclamacao(Reclamacao reclamacao);
    public Reclamacao atualizaReclamacao(Reclamacao reclamacao);
    public Reclamacao getById(long id);
    public List<Reclamacao> getByUsuario(long id);
    public List<Reclamacao> getByCategoria(long idCategoria);
    public List<Reclamacao> getByBairro(String bairro);
    public List<Reclamacao> getByPeriodo(LocalDateTime periodo);
}
