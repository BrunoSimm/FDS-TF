package com.grupofds.projetoTF.aplicacao.casosDeUso.reclamacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.negocio.servicos.ReclamacaoServico;

@Component
public class ConsultaReclamacaoByIdUC {
	
	@Autowired
	private ReclamacaoServico reclamacaoServico;
	
	public void run(Long reclamacaoId) {
		this.reclamacaoServico.getReclamacaoById(reclamacaoId);
	}
}
