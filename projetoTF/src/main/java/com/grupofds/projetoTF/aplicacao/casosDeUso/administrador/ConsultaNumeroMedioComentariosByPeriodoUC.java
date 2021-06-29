package com.grupofds.projetoTF.aplicacao.casosDeUso.administrador;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.aplicacao.servicos.RelatoriosAdminServico;

@Component
public class ConsultaNumeroMedioComentariosByPeriodoUC {
	@Autowired
	private RelatoriosAdminServico relatoriosAdminServico;
	
	public Double run(Long usuarioId, LocalDateTime periodoInicial, LocalDateTime periodoFinal) {
		return this.relatoriosAdminServico.getNumeroMedioComentariosByPeriodo(usuarioId, periodoInicial, periodoFinal);
	}
}
