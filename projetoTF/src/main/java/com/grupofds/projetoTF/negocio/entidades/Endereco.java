package com.grupofds.projetoTF.negocio.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "enderecos")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "reclamacao_id", referencedColumnName = "id")
	private Long id;
	
	@Column
	@NotBlank(message = "Bairro deve ser preenchido.")
	private String bairro;
	
	@Column
	@NotBlank(message = "Logradouro deve ser preenchido.")
	private String logradouro;
	
	@Column(nullable = true)
	@Positive(message = "Numero deve ser positivo.")
	private int numero;
	
	@Column
	@NotBlank(message = "Cidade deve ser preenchido.")
	private String cidade;
	
	@Column
	@NotBlank(message = "Estado deve ser preenchido.")
	private String estado;
	
	//private Long reclamacaoId;

	public Endereco(Long id, @NotBlank(message = "Bairro deve ser preenchido.") String bairro,
			@NotBlank(message = "Logradouro deve ser preenchido.") String logradouro,
			@Positive(message = "Numero deve ser positivo.") int numero,
			@NotBlank(message = "Cidade deve ser preenchido.") String cidade,
			@NotBlank(message = "Estado deve ser preenchido.") String estado, Long reclamacao) {
		this.id = id;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		//this.reclamacaoId = reclamacao;
	}
	
	public Endereco() {}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", bairro=" + bairro + ", logradouro=" + logradouro + ", numero=" + numero
				+ ", cidade=" + cidade + ", estado=" + estado +"]";
	}
	
}
