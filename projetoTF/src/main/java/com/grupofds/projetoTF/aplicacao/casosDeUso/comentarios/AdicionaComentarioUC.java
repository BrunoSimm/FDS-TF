package com.grupofds.projetoTF.aplicacao.casosDeUso.comentarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.aplicacao.dtos.requisicoes.CriarComentarioRequisicaoDTO;
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
	
	public Comentario run(CriarComentarioRequisicaoDTO criarRequisicaoDTO) {
		return comentariosServico.addComentario(criarRequisicaoDTO);
	}
	
}
