package com.grupofds.projetoTF.aplicacao.casosDeUso.comentarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.negocio.entidades.Comentario;
import com.grupofds.projetoTF.negocio.entidades.StatusReclamacoes;
import com.grupofds.projetoTF.negocio.servicos.ComentariosServico;

@Component
public class AdicionaComentarioUC {
	private ComentariosServico comentariosServico;
	
	@Autowired
	public AdicionaComentarioUC(ComentariosServico comentariosServico) {
		this.comentariosServico = comentariosServico;
	}
	
	public void run(Comentario comentario, Long usuarioId, Long idReclamacao, String mensagem, String imagem, StatusReclamacoes status) {
		comentariosServico.addComentario(usuarioId,idReclamacao,mensagem,imagem,status);
	}
	
}