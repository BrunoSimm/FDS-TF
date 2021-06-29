package com.grupofds.projetoTF.aplicacao.dtos.requisicoes;

import javax.validation.constraints.NotBlank;

import com.grupofds.projetoTF.negocio.entidades.StatusReclamacoes;

public class EditarComentarioRequisicaoDTO {
	
	@NotBlank
    private Long usuario_id;
	
	@NotBlank
	private Long idComentario;

    private String descricao;
	
    private String imagem;
    
    private StatusReclamacoes status;

	public EditarComentarioRequisicaoDTO(@NotBlank Long usuario_id, @NotBlank Long idComentario, String descricao,
			String imagem, StatusReclamacoes status) {
		this.usuario_id = usuario_id;
		this.idComentario = idComentario;
		this.descricao = descricao;
		this.imagem = imagem;
		this.status = status;
	}

	public Long getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
	}

	public Long getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(Long idComentario) {
		this.idComentario = idComentario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public StatusReclamacoes getStatus() {
		return status;
	}

	public void setStatus(StatusReclamacoes status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "EditarComentarioRequisicaoDTO [usuario_id=" + usuario_id + ", idComentario=" + idComentario
				+ ", descricao=" + descricao + ", imagem=" + imagem + ", status=" + status + "]";
	}
	
}
