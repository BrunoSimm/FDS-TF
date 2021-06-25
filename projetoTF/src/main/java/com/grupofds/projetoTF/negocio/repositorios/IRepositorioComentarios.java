package com.grupofds.projetoTF.negocio.repositorios;

import java.util.List;

import com.grupofds.projetoTF.negocio.entidades.Comentario;
import com.grupofds.projetoTF.negocio.entidades.STATUS_RECLAMACOES;

public interface IRepositorioComentarios {
    public Comentario addComentario(Long usuarioId, Long idReclamacao, String mensagem, String imagem, STATUS_RECLAMACOES status);
    public Comentario editComentario(Long idComentario, String mensagem , String imagem, STATUS_RECLAMACOES status);
    public boolean deleteComentario(Long idComentario);
    public Comentario getById(Long id);
    public List<Comentario> getByReclamacao(Long idReclamacao);
    public List<Comentario> getByUsuario(Long idUsuario);
    public List<Comentario> getByStatus(STATUS_RECLAMACOES status);
}
