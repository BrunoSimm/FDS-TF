package com.grupofds.projetoTF.aplicacao.dtos;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.negocio.entidades.Endereco;

public class ReclamacaoRequisicaoDTO {
	
	@NotBlank(message = "usuario_id deve ser preenchido")
	private Long usuario_id;
	
	@NotBlank(message = "Titulo deve ser preenchido.")
	private String titulo;
	
	@NotBlank(message = "Descrição deve ser preenchido.")
	private String descricao;
	
	@NotBlank(message = "Endereço deve ser preenchido.")
	private Endereco endereco;
	
	private String imagem;
	
	@NotBlank(message = "Categoria deve ser preenchida.")
	private String categoria;

	public ReclamacaoRequisicaoDTO(@NotBlank(message = "usuario_id deve ser preenchido") Long usuario_id,
			@NotBlank(message = "Titulo deve ser preenchido.") String titulo,
			@NotBlank(message = "Descrição deve ser preenchido.") String descricao,
			@NotBlank(message = "Endereço deve ser preenchido.") Endereco endereco, String imagem,
			@NotBlank(message = "Categoria deve ser preenchida.") String categoria) {
		this.usuario_id = usuario_id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.endereco = endereco;
		this.imagem = imagem;
		this.categoria = categoria;
	}

	public Long getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
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
		return "ReclamacaoRequisicaoDTO [usuario_id=" + usuario_id + ", titulo=" + titulo + ", descricao=" + descricao
				+ ", endereco=" + endereco + ", imagem=" + imagem + ", categoria=" + categoria + "]";
	}
	
}
