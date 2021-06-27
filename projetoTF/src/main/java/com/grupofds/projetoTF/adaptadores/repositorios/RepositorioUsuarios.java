package com.grupofds.projetoTF.adaptadores.repositorios;

import java.util.List;

import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grupofds.projetoTF.negocio.entidades.usuarios.CategoriaDeUsuario;
import com.grupofds.projetoTF.negocio.entidades.usuarios.Usuario;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioUsuarios;

@Repository
@SQLInsert(sql = "INSERT INTO usuarios (nome, email, categoria_de_usuario) VALUES ('BRUNO','TESTE@EMAIL.COM','ADMINISTRADOR')")
public interface RepositorioUsuarios extends JpaRepository<Usuario, Long>, IRepositorioUsuarios {
	Usuario getById(Long id);
	
	@Query(value = "select * from usuarios where usuarios.categoria_de_usuario = :categoria", nativeQuery = true)
    List<Usuario> getUsuariosByCategoria(@Param("categoria") CategoriaDeUsuario categoriaDeUsuario);
}
