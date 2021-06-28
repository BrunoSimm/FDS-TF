package com.grupofds.projetoTF.aplicacao.dtos.requisicoes;

import javax.validation.constraints.NotBlank;

import com.grupofds.projetoTF.negocio.entidades.StatusReclamacoes;

public class CriarComentarioRequisicaoDTO {
	
	@NotBlank
    private Long usuario_id;

	@NotBlank
    private String descricao;
	
    private String imagem;

    @NotBlank
    private Long reclamacao_id;
    
    private StatusReclamacoes status;

	public CriarComentarioRequisicaoDTO(@NotBlank Long usuario_id, @NotBlank String descricao, String imagem,
			@NotBlank Long reclamacao_id, StatusReclamacoes status) {
		this.usuario_id = usuario_id;
		this.descricao = descricao;
		this.imagem = imagem;
		this.reclamacao_id = reclamacao_id;
		this.status = status;
	}

	public Long getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
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

	public Long getReclamacao_id() {
		return reclamacao_id;
	}

	public void setReclamacao_id(Long reclamacao_id) {
		this.reclamacao_id = reclamacao_id;
	}

	public StatusReclamacoes getStatus() {
		return status;
	}

	public void setStatus(StatusReclamacoes status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CriarComentarioRequisicaoDTO [usuario_id=" + usuario_id + ", descricao=" + descricao + ", imagem="
				+ imagem + ", reclamacao_id=" + reclamacao_id + ", status=" + status + "]";
	}
	
	
}
