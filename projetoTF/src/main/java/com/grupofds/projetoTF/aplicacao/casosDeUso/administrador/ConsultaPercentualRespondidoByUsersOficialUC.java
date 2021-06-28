package com.grupofds.projetoTF.aplicacao.casosDeUso.administrador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.aplicacao.servicos.ServicoRelatoriosAdmin;

@Component
public class ConsultaPercentualRespondidoByUsersOficialUC {

	@Autowired
	private ServicoRelatoriosAdmin servicoRelatoriosAdmin;
	
	public Double run(Long usuarioId) {
		return this.servicoRelatoriosAdmin.getPercentualRespondidoByUsersOficiais(usuarioId);
	}
	
}
