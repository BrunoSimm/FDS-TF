package com.grupofds.projetoTF.aplicacao.casosDeUso.comentarios;

import com.grupofds.projetoTF.aplicacao.dtos.requisicoes.EditarComentarioRequisicaoDTO;
import com.grupofds.projetoTF.negocio.entidades.Comentario;
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
	
	public Comentario run(EditarComentarioRequisicaoDTO editarComentarioDTO) {
		return this.comentarioServico.editComentario(editarComentarioDTO.getUsuario_id(), editarComentarioDTO.getIdComentario(), editarComentarioDTO.getDescricao(), editarComentarioDTO.getImagem(), editarComentarioDTO.getStatus());
	}
	
}
