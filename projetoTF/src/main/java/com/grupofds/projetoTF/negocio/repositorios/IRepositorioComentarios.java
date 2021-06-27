package com.grupofds.projetoTF.negocio.repositorios;

import java.time.LocalDateTime;
import java.util.List;

import com.grupofds.projetoTF.negocio.entidades.Comentario;
import com.grupofds.projetoTF.negocio.entidades.StatusReclamacoes;

public interface IRepositorioComentarios {
    Comentario addComentario(Comentario comentario);
    Comentario editComentario(Comentario comentario);
    boolean deleteComentario(Long idComentario);
    Comentario getById(Long id);
    List<Comentario> getByReclamacao(Long idReclamacao);
    List<Comentario> getByUsuario(Long idUsuario);
    List<Comentario> getByStatus(StatusReclamacoes status);
    List<Comentario> getByPeriodo(LocalDateTime periodoInicial, LocalDateTime periodoFinal);
}
