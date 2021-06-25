package com.grupofds.projetoTF.aplicacao.casosDeUso.administrador;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.aplicacao.servicos.ServicoRelatoriosAdmin;

@Component
public class ConsultaTotalReclamacoesByBairroUC {
	@Autowired
	private ServicoRelatoriosAdmin servicoRelatoriosAdmin;
	
	public void run(Long usuarioId,String bairro, LocalDateTime periodoInicial, LocalDateTime periodoFinal) {
		this.servicoRelatoriosAdmin.getTotalReclamacoesByBairroAndPeriodo(usuarioId, bairro, periodoInicial, periodoFinal);
	}
}
