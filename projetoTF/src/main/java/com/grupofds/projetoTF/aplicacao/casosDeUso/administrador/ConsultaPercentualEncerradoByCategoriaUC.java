package com.grupofds.projetoTF.aplicacao.casosDeUso.administrador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.aplicacao.servicos.ServicoRelatoriosAdmin;

@Component
public class ConsultaPercentualEncerradoByCategoriaUC {
	@Autowired
	private ServicoRelatoriosAdmin servicoRelatoriosAdmin;
	
	public void run(Long usuarioId,String categoria) {
		this.servicoRelatoriosAdmin.getPercentualEncerradoByCategoria(usuarioId, categoria);
	}
}