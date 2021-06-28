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
public class ComentariosServico {
    private IRepositorioComentarios repositorioComentarios;
    private IRepositorioReclamacoes repositorioReclamacoes;
    private IRepositorioUsuarios repositorioUsuarios;
    
    @Autowired
    public ComentariosServico(IRepositorioComentarios repositorioComentarios,
			IRepositorioReclamacoes repositorioReclamacoes, IRepositorioUsuarios repositorioUsuarios) {
		this.repositorioComentarios = repositorioComentarios;
		this.repositorioReclamacoes = repositorioReclamacoes;
		this.repositorioUsuarios = repositorioUsuarios;
	}

	public Comentario addComentario(Long usuarioId, Long idReclamacao, String mensagem, String imagem, StatusReclamacoes status) {
        this.validaUsuario(usuarioId);
        
        Reclamacao reclamacao = repositorioReclamacoes.getById(idReclamacao);
        
        if (reclamacao.getStatus() == StatusReclamacoes.ENCERRADA) {
            throw new IllegalArgumentException("Impossivel adicionar Comentario. Reclamacao com status ENCERRADA.");
        }
        
        Usuario usuario = repositorioUsuarios.getById(usuarioId);
        
        if (status == StatusReclamacoes.ENCERRADA
                && usuario.getCategoriaDeUsuario() != CategoriaDeUsuario.USUARIO_OFICIAL) {
            throw new IllegalArgumentException("Usuario sem permissao para encerrar a Reclamacao.");
        }
        
        Comentario comentario = new Comentario(usuario, mensagem, LocalDateTime.now(), imagem, reclamacao);
        
        return this.repositorioComentarios.addComentario(comentario);
    }

    public Comentario editComentario(Long usuarioId, Long idComentario, String mensagem, String imagem, StatusReclamacoes status) {
        this.validaUsuario(usuarioId);
        
        Comentario comentario = repositorioComentarios.getById(idComentario);
        Usuario usuario = repositorioUsuarios.getById(usuarioId);
        
        if (!usuario.equals(comentario.getUsuario())) {
            throw new IllegalArgumentException("Usuario sem permissao para alterar o Comentario.");
        }
        
        Reclamacao reclamacao = repositorioReclamacoes.getById(comentario.getReclamacao().getId());
        
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
        
        comentario.getReclamacao().setStatus(status);
        this.repositorioReclamacoes.updateReclamacao(reclamacao); //Atualizando status da reclamacação.
        
        //Atualizando comentario.
        return this.repositorioComentarios.editComentario(comentario);
    }

/*     public boolean deleteComentario(Long usuarioId, Long idComentario) {
        this.validaUsuario(usuarioId);
        if (!repositorioUsuarios.getById(usuarioId).equals(repositorioComentarios.getById(idComentario).getUsuario())) {
            throw new IllegalArgumentException("Usuario sem permissao para apagar o Comentario.");
        }
        if (repositorioUsuarios.getById(usuarioId).getCategoriaDeUsuario() != CategoriaDeUsuario.USUARIO_OFICIAL) {
            if (repositorioComentarios.getById(idComentario).getReclamacao().getStatus() == StatusReclamacoes.ENCERRADA) {
                throw new IllegalArgumentException("Impossivel apagar Comentario. Reclamacao com status ENCERRADA.");
            }
        }

        // TODO: DELETAR (ÚLTIMO OU ALGUM) COMENTARIO, ALTERA STATUS PARA STATUS ANTERIOR OU ABERTO!?
        // Reclamacao updatedR = repositorioComentarios.getById(idComentario).getReclamacao();
        // updatedR.setStatus(StatusReclamacoes.ABERTA);
        // repositorioReclamacoes.updateReclamacao(updatedR);

        return this.repositorioComentarios.deleteComentario(idComentario);
    } */

    private void validaUsuario(Long usuarioId) {
        if (repositorioUsuarios.getById(usuarioId).getCategoriaDeUsuario() != CategoriaDeUsuario.CIDADAO
                && repositorioUsuarios.getById(usuarioId).getCategoriaDeUsuario() != CategoriaDeUsuario.USUARIO_OFICIAL) {
            throw new IllegalArgumentException("Usuario sem permissao de acesso a funcao.");
        }
    }

}
