package com.grupofds.projetoTF.negocio.repositorios;

import java.util.List;

public interface IRepositorioComentarios {
    public Comentario addComentario(long usuarioId, long idReclamacao, String mensagem, String imagem, STATUS_RECLAMACOES status);
    public Comentario editComentario(long idComentario, String mensagem , String imagem, STATUS_RECLAMACOES status);
    public boolean deleteComentario(long idComentario);
    public Comentario getById(long id);
    public Comentario getById(long id);
    public List<Comentario> getByReclamacao(long idReclamacao);
    public List<Comentario> getByUsuario(long idUsuario);
    public List<Comentario> getByStatus(STATUS_RECLAMACOES status);
}
