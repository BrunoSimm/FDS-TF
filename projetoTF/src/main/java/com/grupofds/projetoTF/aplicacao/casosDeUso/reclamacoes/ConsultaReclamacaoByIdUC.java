package com.grupofds.projetoTF.aplicacao.casosDeUso.reclamacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.negocio.entidades.Reclamacao;
import com.grupofds.projetoTF.negocio.servicos.ReclamacaoServico;

@Component
public class ConsultaReclamacaoByIdUC {
	
	@Autowired
	private ReclamacaoServico reclamacaoServico;
	
	public Reclamacao run(Long reclamacaoId) {
		return this.reclamacaoServico.getReclamacaoById(reclamacaoId);
	}
}
