package com.grupofds.projetoTF.negocio.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.grupofds.projetoTF.negocio.entidades.usuarios.Usuario;

@Entity
@Table(name = "cometarios")
public class Comentario {

<<<<<<< HEAD
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Usuario usuario;

    @Column
    private String descricao;

    @Column(nullable = true)
    private String imagem;

    @ManyToOne
    @JoinColumn(name = "id_reclamacao_fk")
    private Reclamacao reclamacao;
    
    public Comentario(Long id, Usuario usuario, String descricao, String imagem, Reclamacao reclamacao) {
        this.id = id;
        this.usuario = usuario;
        this.descricao = descricao;
        this.imagem = imagem;
        this.reclamacao = reclamacao;
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
    public Reclamacao getIdReclamacao() {
        return reclamacao;
    }
    public void setIdReclamacao(Reclamacao reclamacao) {
        this.reclamacao = reclamacao;
    }
    
=======
	
>>>>>>> 831bcb8f7d29960ac5c80dd9d6f7247b653df398
}
