package com.grupofds.projetoTF.negocio.entidades;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.grupofds.projetoTF.negocio.entidades.usuarios.Usuario;

@Entity
@Table(name = "reclamacoes")
public class Reclamacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuario;
	
	@Column
	@NotBlank(message = "Titulo deve ser preenchido.")
	private String titulo;
	
	@Column
	@NotBlank(message = "Descrição deve ser preenchido.")
	private String descricao;
	
	@Column
	@NotBlank(message = "Data deve ser preenchida.")
	private LocalDateTime data;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
	@NotBlank(message = "Endereço deve ser preenchido.")
	private Endereco endereco;
	
	@Column
	@NotBlank
	private String imagem;
	
	@Column
	@NotBlank(message = "Categoria deve ser preenchida.")
	private String categoria;
	
	@Column
	@NotBlank(message = "O status deve ser definido como ABERTA, RESOLVIDA ou ENCERRADA")
	@Enumerated(EnumType.STRING)
	private StatusReclamacoes status;
	
	@OneToMany(mappedBy = "reclamacao")
	private List<Comentario> comentarios;
	
	public Reclamacao(Long id, Usuario usuario, @NotBlank(message = "Titulo deve ser preenchido.") String titulo,
			@NotBlank(message = "Descrição deve ser preenchido.") String descricao,
			@NotBlank(message = "Data deve ser preenchida.") LocalDateTime data,
			@NotBlank(message = "Endereço deve ser preenchido.") Endereco endereco, @NotBlank String imagem,
			@NotBlank(message = "Categoria deve ser preenchida.") String categoria,
			@NotBlank(message = "O status deve ser definido como ABERTA, RESOLVIDA ou ENCERRADA") StatusReclamacoes status,
			List<Comentario> comentarios) {
		this.id = id;
		this.usuario = usuario;
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.endereco = endereco;
		this.imagem = imagem;
		this.categoria = categoria;
		this.status = status;
		this.comentarios = comentarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public StatusReclamacoes getStatus() {
		return status;
	}
	public void setStatus(StatusReclamacoes status) {
		this.status = status;
	}
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	
}
