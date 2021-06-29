package com.grupofds.projetoTF.aplicacao.casosDeUso.administrador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.aplicacao.servicos.relatoriosAdminServico;

@Component
public class ConsultaPercentualResolvidoByCategoriaUC {
	@Autowired
	private relatoriosAdminServico relatoriosAdminServico;
	
	public Double run(Long usuarioId, String categoria) {
		return this.relatoriosAdminServico.getPercentualResolvidoByCategoria(usuarioId, categoria);
	}
}
