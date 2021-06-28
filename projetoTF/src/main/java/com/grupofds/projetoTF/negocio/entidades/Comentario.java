package com.grupofds.projetoTF.negocio.entidades;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.grupofds.projetoTF.negocio.entidades.usuarios.Usuario;

@Entity
@Table(name = "comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario_fk", nullable = false)
    private Usuario usuario;

    @Column
    @NotBlank(message = "Descrição deve sere preenchida.")
    private String descricao;

    @Column
	private LocalDateTime data;
	
    @Column(nullable = true)
    private String imagem;

    @JoinColumn(name = "reclamacao_id")
    private Long reclamacaoId;
    
	public Comentario(Long id, Usuario usuario, @NotBlank(message = "Descrição deve sere preenchida.") String descricao,
			LocalDateTime data, String imagem, Long reclamacao) {
		this.id = id;
		this.usuario = usuario;
		this.descricao = descricao;
		this.data = data;
		this.imagem = imagem;
		this.reclamacaoId = reclamacao;
	}
	
	public Comentario(Usuario usuario, @NotBlank(message = "Descrição deve sere preenchida.") String descricao,
			LocalDateTime data, String imagem, Long reclamacao) {
		this.usuario = usuario;
		this.descricao = descricao;
		this.data = data;
		this.imagem = imagem;
		this.reclamacaoId = reclamacao;
	}
	
	public Comentario () {}
	
	public Long getReclamacaoId() {
		return reclamacaoId;
	}
	public void setReclamacaoId(Long reclamacao) {
		this.reclamacaoId = reclamacao;
	}
	public LocalDateTime getData() {
        return data;
    }
    public void setData(LocalDateTime data) {
        this.data = data;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", usuario=" + usuario + ", descricao=" + descricao + ", data=" + data
				+ ", imagem=" + imagem +"]";
	}
}
