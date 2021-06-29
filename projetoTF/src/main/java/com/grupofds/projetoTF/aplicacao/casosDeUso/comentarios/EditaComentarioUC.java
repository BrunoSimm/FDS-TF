package com.grupofds.projetoTF.aplicacao.casosDeUso.comentarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.aplicacao.dtos.requisicoes.EditarComentarioRequisicaoDTO;
import com.grupofds.projetoTF.negocio.entidades.Comentario;
import com.grupofds.projetoTF.negocio.entidades.StatusReclamacoes;
import com.grupofds.projetoTF.negocio.servicos.ComentariosServico;

@Component
public class EditaComentarioUC {
	private ComentariosServico comentariosServico;

	@Autowired
	public EditaComentarioUC(ComentariosServico comentariosServico) {
		this.comentariosServico = comentariosServico;
	}
	
	public Comentario run(EditarComentarioRequisicaoDTO editarComentarioDTO) {
		return this.comentariosServico.editComentario(editarComentarioDTO.getUsuario_id(), editarComentarioDTO.getIdComentario(), editarComentarioDTO.getDescricao(), editarComentarioDTO.getImagem(), editarComentarioDTO.getStatus());
	}
	
}
