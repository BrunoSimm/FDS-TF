package com.grupofds.projetoTF.adaptadores.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupofds.projetoTF.aplicacao.casosDeUso.reclamacoes.AtualizaReclamacaoUC;
import com.grupofds.projetoTF.aplicacao.casosDeUso.reclamacoes.ConsultaReclamacaoByIdUC;
import com.grupofds.projetoTF.aplicacao.casosDeUso.reclamacoes.ConsultaReclamacoesByBairroUC;
import com.grupofds.projetoTF.aplicacao.casosDeUso.reclamacoes.ConsultaReclamacoesByCategoriaUC;
import com.grupofds.projetoTF.aplicacao.casosDeUso.reclamacoes.ConsultaReclamacoesByUsuarioUC;
import com.grupofds.projetoTF.aplicacao.casosDeUso.reclamacoes.CriaReclamacaoUC;
import com.grupofds.projetoTF.aplicacao.casosDeUso.reclamacoes.ListaTodasReclamacoesUC;
import com.grupofds.projetoTF.aplicacao.dtos.requisicoes.CriarReclamacaoRequisicaoDTO;
import com.grupofds.projetoTF.aplicacao.dtos.requisicoes.EditarReclamacaoRequisicaoDTO;
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
	private ListaTodasReclamacoesUC listaTodasReclamacoesUC;
	
	@Autowired
	public ReclamacaoController(AtualizaReclamacaoUC atualizaReclamacaoUC,
			ConsultaReclamacaoByIdUC consultaReclamacaoByIdUC,
			ConsultaReclamacoesByBairroUC consultaReclamacoesByBairroUC,
			ConsultaReclamacoesByCategoriaUC consultaReclamacoesByCategoriaUC,
			ConsultaReclamacoesByUsuarioUC consultaReclamacoesByUsuarioUC,
			CriaReclamacaoUC criaReclamacaoUC,
			ListaTodasReclamacoesUC listaTodasReclamacoesUC) {
		this.atualizaReclamacaoUC = atualizaReclamacaoUC;
		this.consultaReclamacaoByIdUC = consultaReclamacaoByIdUC;
		this.consultaReclamacoesByBairroUC = consultaReclamacoesByBairroUC;
		this.consultaReclamacoesByCategoriaUC = consultaReclamacoesByCategoriaUC;
		this.consultaReclamacoesByUsuarioUC = consultaReclamacoesByUsuarioUC;
		this.criaReclamacaoUC = criaReclamacaoUC;
		this.listaTodasReclamacoesUC = listaTodasReclamacoesUC;
	}

	@PutMapping(value = "/id/{idReclamacao}") // /id/3?idUsuario=11
	public Reclamacao atualizaReclamacao(@PathVariable Long idReclamacao, @RequestParam Long idUsuario, @RequestBody EditarReclamacaoRequisicaoDTO reclamacao) {
		System.out.println(reclamacao);
		return atualizaReclamacaoUC.run(idUsuario, idReclamacao, reclamacao);
	}
	
	@GetMapping(value = "/id")
	public Reclamacao consultaReclamacaoById(@RequestParam Long id) {
		return consultaReclamacaoByIdUC.run(id);
	}
	
	@GetMapping(value = "/bairro")
	public List<Reclamacao> consultaReclamacoesByBairro(@RequestParam String bairro){
		return consultaReclamacoesByBairroUC.run(bairro);
	}
	
	@GetMapping(value = "/categoria")
	public List<Reclamacao> consultaReclamacoesByCategoria(@RequestParam String categoria){
		return consultaReclamacoesByCategoriaUC.run(categoria);
	}
	
	@GetMapping(value = "/usuario/{idUsuario}")
	public List<Reclamacao> consultaReclamacoesByUsuario(@PathVariable Long idUsuario) {
		return consultaReclamacoesByUsuarioUC.run(idUsuario);
	}
	
	@PostMapping
	public Reclamacao criaReclamacao(@RequestBody CriarReclamacaoRequisicaoDTO reclamacaoDTO) {
		return criaReclamacaoUC.run(reclamacaoDTO);
	}
	
	@GetMapping
	public List<Reclamacao> findAll(){
		return listaTodasReclamacoesUC.run();
	}
	
}
