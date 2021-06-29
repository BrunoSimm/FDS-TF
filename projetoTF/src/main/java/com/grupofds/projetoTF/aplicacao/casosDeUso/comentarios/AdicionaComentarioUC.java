package com.grupofds.projetoTF.aplicacao.casosDeUso.comentarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.aplicacao.dtos.requisicoes.CriarComentarioRequisicaoDTO;
import com.grupofds.projetoTF.negocio.entidades.Comentario;
import com.grupofds.projetoTF.negocio.servicos.ComentarioServico;

@Component
public class AdicionaComentarioUC {
	private ComentarioServico comentarioServico;
	
	@Autowired
	public AdicionaComentarioUC(ComentarioServico comentarioServico) {
		this.comentarioServico = comentarioServico;
	}
	
	public Comentario run(CriarComentarioRequisicaoDTO criarRequisicaoDTO) {
		return comentarioServico.addComentario(criarRequisicaoDTO);
	}
	
}
