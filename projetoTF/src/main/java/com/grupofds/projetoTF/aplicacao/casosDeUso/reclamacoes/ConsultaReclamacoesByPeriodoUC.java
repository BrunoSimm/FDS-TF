package com.grupofds.projetoTF.aplicacao.casosDeUso.reclamacoes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.negocio.entidades.Reclamacao;
import com.grupofds.projetoTF.negocio.servicos.ReclamacaoServico;

@Component
public class ConsultaReclamacoesByPeriodoUC {
	@Autowired
	private ReclamacaoServico reclamacaoServico;
	
	public List<Reclamacao> run(LocalDateTime periodoInicial, LocalDateTime periodoFinal) {
		return this.reclamacaoServico.getReclamacoesByPeriodo(periodoInicial, periodoFinal);
	}
}
