package com.grupofds.projetoTF.aplicacao.casosDeUso.administrador;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.aplicacao.servicos.ServicoRelatoriosAdmin;

@Component
public class ConsultaNumeroMedioComentariosByPeriodoUC {
	@Autowired
	private ServicoRelatoriosAdmin servicoRelatoriosAdmin;
	
	public void run(Long usuarioId, LocalDateTime periodoInicial, LocalDateTime periodoFinal) {
		this.servicoRelatoriosAdmin.getNumeroMedioComentariosByPeriodo(usuarioId, periodoInicial, periodoFinal);
	}
}
