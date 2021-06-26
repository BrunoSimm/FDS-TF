package com.grupofds.projetoTF.adaptadores.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupofds.projetoTF.aplicacao.casosDeUso.reclamacoes.AtualizaReclamacaoUC;
import com.grupofds.projetoTF.aplicacao.casosDeUso.reclamacoes.ConsultaReclamacaoByIdUC;
import com.grupofds.projetoTF.aplicacao.casosDeUso.reclamacoes.ConsultaReclamacoesByBairroUC;
import com.grupofds.projetoTF.aplicacao.casosDeUso.reclamacoes.ConsultaReclamacoesByCategoriaUC;
import com.grupofds.projetoTF.aplicacao.casosDeUso.reclamacoes.ConsultaReclamacoesByUsuarioUC;
import com.grupofds.projetoTF.aplicacao.casosDeUso.reclamacoes.CriaReclamacaoUC;
import com.grupofds.projetoTF.aplicacao.casosDeUso.reclamacoes.EncerraReclamacaoUC;
import com.grupofds.projetoTF.aplicacao.casosDeUso.reclamacoes.ListaTodasReclamacoes;
import com.grupofds.projetoTF.negocio.entidades.Reclamacao;

@RestController
@RequestMapping("/reclamacoes")
public class ReclamacaoController {

	private AtualizaReclamacaoUC atualizaReclamacaoUC;
	private ConsultaReclamacaoByIdUC consultaReclamacaoByIdUC;
	private ConsultaReclamacoesByBairroUC consultaReclamacoesByBairroUC;
	private ConsultaReclamacoesByCategoriaUC consultaReclamacoesByCategoriaUC;
	private ConsultaReclamacoesByUsuarioUC consultaReclamacoesByUsuarioUC;
	private CriaReclamacaoUC criaReclamacaoUC;
	private EncerraReclamacaoUC encerraReclamacaoUC;
	private ListaTodasReclamacoes listaTodasReclamacoesUC;
	
	@Autowired
	public ReclamacaoController(AtualizaReclamacaoUC atualizaReclamacaoUC,
			ConsultaReclamacaoByIdUC consultaReclamacaoByIdUC,
			ConsultaReclamacoesByBairroUC consultaReclamacoesByBairroUC,
			ConsultaReclamacoesByCategoriaUC consultaReclamacoesByCategoriaUC,
			ConsultaReclamacoesByUsuarioUC consultaReclamacoesByUsuarioUC, CriaReclamacaoUC criaReclamacaoUC,
			EncerraReclamacaoUC encerraReclamacaoUC, ListaTodasReclamacoes listaTodasReclamacoesUC) {
		this.atualizaReclamacaoUC = atualizaReclamacaoUC;
		this.consultaReclamacaoByIdUC = consultaReclamacaoByIdUC;
		this.consultaReclamacoesByBairroUC = consultaReclamacoesByBairroUC;
		this.consultaReclamacoesByCategoriaUC = consultaReclamacoesByCategoriaUC;
		this.consultaReclamacoesByUsuarioUC = consultaReclamacoesByUsuarioUC;
		this.criaReclamacaoUC = criaReclamacaoUC;
		this.encerraReclamacaoUC = encerraReclamacaoUC;
		this.listaTodasReclamacoesUC = listaTodasReclamacoesUC;
	}

	@PutMapping(value = "/id/{idReclamacao}")
	public Reclamacao atualizaReclamacao(@PathVariable Long idReclamacao, @RequestBody Long idUsuario  ,@RequestBody Reclamacao reclamacao) { // TODO => Fazer DTO para Reclamacao??
		return atualizaReclamacaoUC.run(idUsuario, idReclamacao, reclamacao);
	}
	
	@GetMapping(value = "/id/{idReclamacao}")
	public Reclamacao consultaReclamacaoById(@PathVariable Long idReclamacao) {
		return consultaReclamacaoByIdUC.run(idReclamacao);
	}
	
	@GetMapping(value = "/bairro/{bairro}")
	public List<Reclamacao> consultaReclamacoesByBairro(@PathVariable String bairro){
		return consultaReclamacoesByBairroUC.run(bairro);
	}
	
	@GetMapping(value = "/categoria/{categoria}")
	public List<Reclamacao> consultaReclamacoesByCategoria(@PathVariable String categoria){
		return consultaReclamacoesByCategoriaUC.run(categoria);
	}
	
	@GetMapping(value = "/usuario/{idUsuario}")
	public List<Reclamacao> consultaReclamacoesByUsuario(@PathVariable Long idUsuario) {
		return consultaReclamacoesByUsuarioUC.run(idUsuario);
	}
	
	@PostMapping
	public Reclamacao criaReclamacao(@RequestBody Reclamacao reclamacao) {
		return criaReclamacaoUC.run(reclamacao);
	}
	
	@PostMapping(value = "/id/{idReclamacao}")
	public Reclamacao encerraReclamacao(@PathVariable Long idReclamacao, @RequestBody Long idUsuarioOficial) {
		return encerraReclamacaoUC.run(idUsuarioOficial, idReclamacao);
	}
	
	@GetMapping
	public List<Reclamacao> findAll(){
		return listaTodasReclamacoesUC.run();
	}
	
}
