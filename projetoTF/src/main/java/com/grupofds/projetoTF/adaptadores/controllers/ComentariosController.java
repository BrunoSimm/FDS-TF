package com.grupofds.projetoTF.adaptadores.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupofds.projetoTF.aplicacao.casosDeUso.comentarios.AdicionaComentarioUC;
import com.grupofds.projetoTF.aplicacao.casosDeUso.comentarios.EditaComentarioUC;
import com.grupofds.projetoTF.aplicacao.dtos.requisicoes.CriarComentarioRequisicaoDTO;
import com.grupofds.projetoTF.negocio.entidades.Comentario;


@RestController
@RequestMapping("/comentarios")
public class ComentariosController {
	
	private AdicionaComentarioUC adicionaComentarioUC;
	private EditaComentarioUC editaComentarioUC;
	
	@Autowired
	public ComentariosController(AdicionaComentarioUC adicionaComentarioUC, EditaComentarioUC editaComentarioUC) {
		this.adicionaComentarioUC = adicionaComentarioUC;
		this.editaComentarioUC = editaComentarioUC;
	}
	
	@PostMapping
	public Comentario adicionaComentarioUC(@RequestBody CriarComentarioRequisicaoDTO comentarioDTO) {
		System.out.println(comentarioDTO);
		return adicionaComentarioUC.run(comentarioDTO);
	}
	
	

}