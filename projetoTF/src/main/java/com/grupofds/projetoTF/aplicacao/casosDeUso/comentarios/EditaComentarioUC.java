package com.grupofds.projetoTF.aplicacao.casosDeUso.comentarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.negocio.entidades.StatusReclamacoes;
import com.grupofds.projetoTF.negocio.servicos.ComentariosServico;

@Component
public class EditaComentarioUC {
	private ComentariosServico comentariosServico;

	@Autowired
	public EditaComentarioUC(ComentariosServico comentariosServico) {
		this.comentariosServico = comentariosServico;
	}
	
	public void run(Long usuarioId, Long idComentario, String mensagem, String imagem, StatusReclamacoes status) {
		this.comentariosServico.editComentario(usuarioId,idComentario, mensagem, imagem, status);
	}
	
}
