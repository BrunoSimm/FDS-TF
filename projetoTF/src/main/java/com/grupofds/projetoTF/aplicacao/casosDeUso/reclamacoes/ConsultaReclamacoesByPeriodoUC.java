package com.grupofds.projetoTF.aplicacao.casosDeUso.reclamacoes;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.negocio.servicos.ReclamacaoServico;

@Component
public class ConsultaReclamacoesByPeriodoUC {
	@Autowired
	private ReclamacaoServico reclamacaoServico;
	
	public void run(LocalDateTime periodoInicial, LocalDateTime periodoFinal) {
		this.reclamacaoServico.getReclamacoesByPeriodo(periodoInicial, periodoFinal);
	}
}
