package com.grupofds.projetoTF.negocio.repositorios;

import java.util.List;

import org.springframework.stereotype.Component;

import com.grupofds.projetoTF.negocio.entidades.usuarios.CategoriaDeUsuario;
import com.grupofds.projetoTF.negocio.entidades.usuarios.Usuario;

@Component
public interface IRepositorioUsuarios {
    public Usuario getById(Long id);
    public List<Usuario> getUsuariosByCategoria(CategoriaDeUsuario categoriaDeUsuario);
}
