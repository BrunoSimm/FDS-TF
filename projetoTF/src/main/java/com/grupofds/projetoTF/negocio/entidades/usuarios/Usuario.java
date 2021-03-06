package com.grupofds.projetoTF.negocio.entidades.usuarios;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    //@NotBlank(message = "Nome inválido")
    private String nome;
    
    @Column(nullable = false)
    //@Email(message = "E-mail inválido")
    private String email;

    @Enumerated(EnumType.STRING)
    //@NotNull(message = "Categoria inválida")
    @Column(nullable = false)
    private CategoriaDeUsuario categoriaDeUsuario;
	
	public Usuario(Long id, @NotBlank(message = "Nome inválido") String nome,
			@Email(message = "E-mail inválido") String email,
			@NotNull(message = "Categoria inválida") CategoriaDeUsuario categoriaDeUsuario) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.categoriaDeUsuario = categoriaDeUsuario;
	}
	
	public Usuario() {}

	public CategoriaDeUsuario getCategoriaDeUsuario() {
		return categoriaDeUsuario;
	}
	
	public void setCategoriaDeUsuario(CategoriaDeUsuario categoriaDeUsuario) {
        this.categoriaDeUsuario = categoriaDeUsuario;
	}

	public void setId(Long id) {
        this.id = id;
	}

	public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
