package com.grupofds.projetoTF.negocio.repositorios;

import java.time.LocalDateTime;
import java.util.List;

import com.grupofds.projetoTF.negocio.entidades.Comentario;
import com.grupofds.projetoTF.negocio.entidades.StatusReclamacoes;

public interface IRepositorioComentarios {
    public Comentario addComentario(Long usuarioId, Long idReclamacao, String mensagem, String imagem, StatusReclamacoes status);
    public Comentario editComentario(Long idComentario, String mensagem , String imagem, StatusReclamacoes status);
    public boolean deleteComentario(Long idComentario);
    public Comentario getById(Long id);
    public List<Comentario> getByReclamacao(Long idReclamacao);
    public List<Comentario> getByUsuario(Long idUsuario);
    public List<Comentario> getByStatus(StatusReclamacoes status);
    public List<Comentario> getByPeriodo(LocalDateTime periodoInicial, LocalDateTime periodoFinal);
}
