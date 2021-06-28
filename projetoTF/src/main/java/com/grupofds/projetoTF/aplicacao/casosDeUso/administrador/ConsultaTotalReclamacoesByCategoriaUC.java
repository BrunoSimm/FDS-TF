package com.grupofds.projetoTF.aplicacao.casosDeUso.administrador;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.aplicacao.servicos.ServicoRelatoriosAdmin;

@Component
public class ConsultaTotalReclamacoesByCategoriaUC {
	@Autowired
	private ServicoRelatoriosAdmin servicoRelatoriosAdmin;
	
	public Long run(Long usuarioId,String categoria, LocalDateTime periodoInicial, LocalDateTime periodoFinal) {
		return this.servicoRelatoriosAdmin.getTotalReclamacoesByCategoriaAndPeriodo(usuarioId, categoria, periodoInicial, periodoFinal);
	}
}
