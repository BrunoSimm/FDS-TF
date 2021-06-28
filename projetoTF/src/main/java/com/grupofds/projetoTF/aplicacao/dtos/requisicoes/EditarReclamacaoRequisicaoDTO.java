package com.grupofds.projetoTF.aplicacao.dtos.requisicoes;

import com.grupofds.projetoTF.negocio.entidades.Endereco;

public class EditarReclamacaoRequisicaoDTO {
	
	private String titulo;

	private String descricao;
	
	private Endereco endereco;
	
	private String imagem;
	
	private String categoria;
	
	public EditarReclamacaoRequisicaoDTO(String titulo, String descricao, Endereco endereco, String imagem,
			String categoria) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.endereco = endereco;
		this.imagem = imagem;
		this.categoria = categoria;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "EditarReclamacaoRequisicaoDTO [titulo=" + titulo + ", descricao=" + descricao + ", endereco=" + endereco
				+ ", imagem=" + imagem + ", categoria=" + categoria + "]";
	}
	
	
}
