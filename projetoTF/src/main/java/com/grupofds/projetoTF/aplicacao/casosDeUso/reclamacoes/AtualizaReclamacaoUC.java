package com.grupofds.projetoTF.aplicacao.casosDeUso.reclamacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.negocio.entidades.Endereco;
import com.grupofds.projetoTF.negocio.entidades.Reclamacao;
import com.grupofds.projetoTF.negocio.servicos.ReclamacaoServico;

@Component
public class AtualizaReclamacaoUC {

	private ReclamacaoServico reclamacaoServico;
	
	@Autowired
	public AtualizaReclamacaoUC(ReclamacaoServico reclamacaoServico) {
		this.reclamacaoServico = reclamacaoServico;
	}

	public Reclamacao run(Long usuarioId, Long reclamacaoId, 
			String titulo, String descricao, Endereco endereco, String imagem, String categoria) {
		return this.reclamacaoServico.updateReclamacao(usuarioId, reclamacaoId,titulo,descricao,endereco,imagem,categoria);
	}
	
}
