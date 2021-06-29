package com.grupofds.projetoTF.aplicacao.casosDeUso.administrador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.aplicacao.dtos.PercentualRespondidoByUserOficialDTO;
import com.grupofds.projetoTF.aplicacao.servicos.relatoriosAdminServico;

@Component
public class ConsultaPercentualRespondidoByUserOficialUC {
	@Autowired
	private relatoriosAdminServico relatoriosAdminServico;
	
	public PercentualRespondidoByUserOficialDTO run(Long usuarioId, Long idUsuarioOficial) {
		return this.relatoriosAdminServico.getPercentualRespondidoByUserOficial(usuarioId, idUsuarioOficial);
	}
}
