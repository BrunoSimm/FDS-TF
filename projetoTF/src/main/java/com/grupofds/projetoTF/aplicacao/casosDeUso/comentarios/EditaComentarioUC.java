package com.grupofds.projetoTF.aplicacao.casosDeUso.comentarios;

import com.grupofds.projetoTF.negocio.entidades.Comentario;
import com.grupofds.projetoTF.negocio.entidades.StatusReclamacoes;
import com.grupofds.projetoTF.negocio.servicos.ComentarioServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EditaComentarioUC {
	private ComentarioServico comentarioServico;

	@Autowired
	public EditaComentarioUC(ComentarioServico comentarioServico) {
		this.comentarioServico = comentarioServico;
	}
	
	public Comentario run(Long usuario_id, Long idComentario, String descricao, String imagem, StatusReclamacoes status) {
		return this.comentarioServico.editComentario(usuario_id,idComentario, descricao,imagem,status);
	}
	
}
