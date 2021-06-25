package com.grupofds.projetoTF.negocio.entidades;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reclamacoes")
public class Reclamacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String titulo;
	
	@Column
	private String descricao;
	
	@Column
	private LocalDateTime data;
	
	@Column
	private Endereco endereco;
	
	@Column
	private String imagem;
	
	@Column
	private Categoria categoria;
	
	@Column
	private STATUS_RECLAMACOES status;
	
	private List<Comentario> comentarios;
	
	public Reclamacao(Long id, String titulo, String descricao, LocalDateTime data, Endereco endereco, String imagem,
			Categoria categoria, STATUS_RECLAMACOES status, List<Comentario> comentarios) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.endereco = endereco;
		this.imagem = imagem;
		this.categoria = categoria;
		this.status = status;
		this.comentarios = comentarios;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
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
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public STATUS_RECLAMACOES getStatus() {
		return status;
	}
	public void setStatus(STATUS_RECLAMACOES status) {
		this.status = status;
	}
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	
}