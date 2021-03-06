package com.grupofds.projetoTF.negocio.servicos;

import com.grupofds.projetoTF.negocio.entidades.Comentario;
import com.grupofds.projetoTF.negocio.entidades.Reclamacao;
import com.grupofds.projetoTF.negocio.entidades.StatusReclamacoes;
import com.grupofds.projetoTF.negocio.entidades.usuarios.CategoriaDeUsuario;
import com.grupofds.projetoTF.negocio.entidades.usuarios.Usuario;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioComentarios;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioReclamacoes;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioUsuarios;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioServico {
    private IRepositorioComentarios repositorioComentarios;
    private IRepositorioReclamacoes repositorioReclamacoes;
    private IRepositorioUsuarios repositorioUsuarios;
    
    @Autowired
    public ComentarioServico(IRepositorioComentarios repositorioComentarios,
			IRepositorioReclamacoes repositorioReclamacoes, IRepositorioUsuarios repositorioUsuarios) {
		this.repositorioComentarios = repositorioComentarios;
		this.repositorioReclamacoes = repositorioReclamacoes;
		this.repositorioUsuarios = repositorioUsuarios;
	}


	public Comentario addComentario(Long usuario_id, String descricao, String imagem, Long reclamacao_id, StatusReclamacoes status) {//REFATORAR P ATRIBUTO
        this.validaPermissaoDeUsuario(usuario_id);
    
        Reclamacao reclamacao = repositorioReclamacoes.getById(reclamacao_id);
        
        if (reclamacao.getStatus() == StatusReclamacoes.ENCERRADA) {
            throw new IllegalArgumentException("Impossivel adicionar Comentario. Reclamacao com status ENCERRADA.");
        }
        
        Usuario usuario = repositorioUsuarios.getById(usuario_id);
        
        if (status == StatusReclamacoes.ENCERRADA
                && usuario.getCategoriaDeUsuario() != CategoriaDeUsuario.USUARIO_OFICIAL) {
        	throw new IllegalArgumentException("Usuario sem permissao para encerrar a Reclamacao.");
        } else {
        	reclamacao.setStatus(StatusReclamacoes.ENCERRADA); //Hibernate j?? IR?? ATUALIZAR o registro.
        }
        
        if (status == StatusReclamacoes.RESOLVIDA && (usuario.getCategoriaDeUsuario() == CategoriaDeUsuario.CIDADAO || usuario.getCategoriaDeUsuario() == CategoriaDeUsuario.USUARIO_OFICIAL)) {
        	reclamacao.setStatus(StatusReclamacoes.RESOLVIDA); //Hibernate j?? ir?? atualizar o registro.
        } else {
        	throw new IllegalArgumentException("Usuario sem permissao para Resolver a Reclamacao.");
        }
        
        Comentario comentario = new Comentario(usuario, descricao, LocalDateTime.now(), imagem, reclamacao.getId());
        
        return this.repositorioComentarios.addComentario(comentario);
    }

    public Comentario editComentario(Long usuarioId, Long idComentario, String mensagem, String imagem, StatusReclamacoes status) {
        this.validaPermissaoDeUsuario(usuarioId);
        
        Comentario comentario = repositorioComentarios.getById(idComentario);
        Usuario usuario = repositorioUsuarios.getById(usuarioId);
        
        if (!usuario.equals(comentario.getUsuario())) {
            throw new IllegalArgumentException("Usuario sem permissao para alterar o Comentario.");
        }
        
        Reclamacao reclamacao = repositorioReclamacoes.getById(comentario.getReclamacaoId());
        
        if (usuario.getCategoriaDeUsuario() != CategoriaDeUsuario.USUARIO_OFICIAL) {
            if (reclamacao.getStatus() == StatusReclamacoes.ENCERRADA) {
                throw new IllegalArgumentException("Impossivel alterar Comentario. Reclamacao com status ENCERRADA.");
            }
            if (status == StatusReclamacoes.ENCERRADA) {
                throw new IllegalArgumentException("Usuario sem permissao para encerrar a Reclamacao.");
            }
        }
        
        comentario.setDescricao(mensagem);
        comentario.setImagem(imagem);
        comentario.setData(LocalDateTime.now());
        
        //Atualizando status da reclamaca????o.
        reclamacao.setStatus(status);
        //this.repositorioReclamacoes.updateReclamacao(reclamacao);
        
        //Atualizando comentario.
        return this.repositorioComentarios.editComentario(comentario);
    }

    private void validaPermissaoDeUsuario(Long usuarioId) {
        if (repositorioUsuarios.getById(usuarioId).getCategoriaDeUsuario() != CategoriaDeUsuario.CIDADAO
                && repositorioUsuarios.getById(usuarioId).getCategoriaDeUsuario() != CategoriaDeUsuario.USUARIO_OFICIAL) {
            throw new IllegalArgumentException("Usuario sem permissao de acesso a funcao.");
        }
    }

}
