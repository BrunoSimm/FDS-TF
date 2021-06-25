package com.grupofds.projetoTF.negocio.servicos;

import com.grupofds.projetoTF.negocio.entidades.Comentario;
import com.grupofds.projetoTF.negocio.entidades.StatusReclamacoes;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioComentarios;

import org.springframework.beans.factory.annotation.Autowired;

public class ComentariosServico {
    private IRepositorioComentarios repositorioComentarios;
    
    @Autowired
    public ComentariosServico(IRepositorioComentarios repositorioComentarios) {
        this.repositorioComentarios = repositorioComentarios;
    }

    public Comentario addComentario(Long usuarioId, Long idReclamacao, String mensagem, String imagem, StatusReclamacoes status) {
        //TODO: logica
        return this.repositorioComentarios.addComentario(usuarioId, idReclamacao, mensagem, imagem, status);
    }

    public Comentario editComentario(Long usuarioId, Long idComentario, String mensagem, String imagem, StatusReclamacoes status) {
        //TODO: logica 
        return this.repositorioComentarios.editComentario(idComentario, mensagem, imagem, status);
    }

    public boolean deleteComentario(Long usuarioId, Long idComentario) {
        //TODO: logica 
        return this.repositorioComentarios.deleteComentario(idComentario);
    }

}
