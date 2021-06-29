package com.grupofds.projetoTF.aplicacao.casosDeUso.reclamacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.negocio.entidades.Endereco;
import com.grupofds.projetoTF.negocio.entidades.Reclamacao;
import com.grupofds.projetoTF.negocio.servicos.ReclamacaoServico;

@Component
public class CriaReclamacaoUC {

	@Autowired
	private ReclamacaoServico reclamacaoServico;
	
	public Reclamacao run(Long usuario_id,String titulo, String descricao, Endereco endereco, String imagem, String categoria) {
		return reclamacaoServico.createReclamacao(usuario_id,titulo, descricao, endereco, imagem, categoria);
	}
}
