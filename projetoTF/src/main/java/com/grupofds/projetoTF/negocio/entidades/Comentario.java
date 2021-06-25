package com.grupofds.projetoTF.negocio.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cometarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Usuario usuario;

    @Column
    private String descricao;

    @Column
    private String imagem;

    @Column
    private Long idReclamacao;
    
    public Comentario(Long id, Usuario usuario, String descricao, String imagem, Long idReclamacao) {
        this.id = id;
        this.usuario = usuario;
        this.descricao = descricao;
        this.imagem = imagem;
        this.idReclamacao = idReclamacao;
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
    public Long getIdReclamacao() {
        return idReclamacao;
    }
    public void setIdReclamacao(Long idReclamacao) {
        this.idReclamacao = idReclamacao;
    }
    
}
