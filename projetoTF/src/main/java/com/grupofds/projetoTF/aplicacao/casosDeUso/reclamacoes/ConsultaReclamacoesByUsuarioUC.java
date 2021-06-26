package com.grupofds.projetoTF.aplicacao.casosDeUso.reclamacoes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.negocio.entidades.Reclamacao;
import com.grupofds.projetoTF.negocio.servicos.ReclamacaoServico;

@Component
public class ConsultaReclamacoesByUsuarioUC {
	@Autowired
	private ReclamacaoServico reclamacaoServico;
	
	public List<Reclamacao> run(Long idUsuario) {
		return this.reclamacaoServico.getReclamacoesByUsuario(idUsuario);
	}
}
