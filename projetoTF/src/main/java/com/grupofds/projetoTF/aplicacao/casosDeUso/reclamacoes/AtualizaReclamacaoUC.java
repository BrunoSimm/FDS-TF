package com.grupofds.projetoTF.aplicacao.casosDeUso.reclamacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.aplicacao.dtos.requisicoes.EditarReclamacaoRequisicaoDTO;
import com.grupofds.projetoTF.negocio.entidades.Reclamacao;
import com.grupofds.projetoTF.negocio.servicos.ReclamacaoServico;

@Component
public class AtualizaReclamacaoUC {

	private ReclamacaoServico reclamacaoServico;
	
	@Autowired
	public AtualizaReclamacaoUC(ReclamacaoServico reclamacaoServico) {
		this.reclamacaoServico = reclamacaoServico;
	}

	public Reclamacao run(Long usuarioId, Long reclamacaoId, EditarReclamacaoRequisicaoDTO reclamacao) {
		return this.reclamacaoServico.updateReclamacao(usuarioId, reclamacaoId, reclamacao);
	}
	
}
