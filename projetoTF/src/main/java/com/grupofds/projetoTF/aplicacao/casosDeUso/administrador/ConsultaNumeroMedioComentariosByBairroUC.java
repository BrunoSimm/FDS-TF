package com.grupofds.projetoTF.aplicacao.casosDeUso.administrador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.aplicacao.servicos.RelatoriosAdminServico;

@Component
public class ConsultaNumeroMedioComentariosByBairroUC {

	@Autowired
	private RelatoriosAdminServico relatoriosAdminServico;
	
	public Double run(Long usuarioId, String bairro) {
		return this.relatoriosAdminServico.getNumeroMedioComentariosByBairro(usuarioId, bairro);
	}
	
}
