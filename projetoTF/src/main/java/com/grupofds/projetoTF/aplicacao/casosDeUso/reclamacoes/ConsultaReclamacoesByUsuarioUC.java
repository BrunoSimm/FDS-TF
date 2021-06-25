package com.grupofds.projetoTF.aplicacao.casosDeUso.reclamacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.negocio.servicos.ReclamacaoServico;

@Component
public class ConsultaReclamacoesByUsuarioUC {
	@Autowired
	private ReclamacaoServico reclamacaoServico;
	
	public void run(Long idUsuario) {
		this.reclamacaoServico.getReclamacoesByUsuario(idUsuario);
	}
}
