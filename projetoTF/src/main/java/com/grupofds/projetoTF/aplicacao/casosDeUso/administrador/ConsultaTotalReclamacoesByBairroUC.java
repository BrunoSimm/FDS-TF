package com.grupofds.projetoTF.aplicacao.casosDeUso.administrador;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.aplicacao.servicos.RelatoriosAdminServico;

@Component
public class ConsultaTotalReclamacoesByBairroUC {
	@Autowired
	private RelatoriosAdminServico relatoriosAdminServico;
	
	public Long run(Long usuarioId,String bairro, LocalDateTime periodoInicial, LocalDateTime periodoFinal) {
		return this.relatoriosAdminServico.getTotalReclamacoesByBairroAndPeriodo(usuarioId, bairro, periodoInicial, periodoFinal);
	}
}
