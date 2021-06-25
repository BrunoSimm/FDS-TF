package com.grupofds.projetoTF.aplicacao.casosDeUso.comentarios;

import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.negocio.servicos.ComentariosServico;

@Component
public class ExcluiComentarioUC {
	private ComentariosServico comentariosServico;

	public ExcluiComentarioUC(ComentariosServico comentariosServico) {
		this.comentariosServico = comentariosServico;
	}
	
	public void run(Long usuarioId,Long idComentario) {
		this.comentariosServico.deleteComentario(usuarioId, idComentario);
	}
}
