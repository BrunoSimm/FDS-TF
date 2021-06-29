package com.grupofds.projetoTF.aplicacao.casosDeUso.comentarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.negocio.entidades.Comentario;
import com.grupofds.projetoTF.negocio.entidades.StatusReclamacoes;
import com.grupofds.projetoTF.negocio.servicos.ComentarioServico;

@Component
public class AdicionaComentarioUC {
	private ComentarioServico comentarioServico;
	
	@Autowired
	public AdicionaComentarioUC(ComentarioServico comentarioServico) {
		this.comentarioServico = comentarioServico;
	}
	
	public Comentario run(Long usuario_id, String descricao, String imagem, Long reclamacao_id, StatusReclamacoes status) {
		return comentarioServico.addComentario(usuario_id, descricao, imagem, reclamacao_id, status);
	}
	
}
