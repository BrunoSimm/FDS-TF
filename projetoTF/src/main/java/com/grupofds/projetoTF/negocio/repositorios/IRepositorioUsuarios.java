package com.grupofds.projetoTF.negocio.repositorios;

import java.util.List;


import com.grupofds.projetoTF.negocio.entidades.usuarios.CategoriaDeUsuario;
import com.grupofds.projetoTF.negocio.entidades.usuarios.Usuario;

public interface IRepositorioUsuarios {
    Usuario getById(Long id);
    List<Usuario> getUsuariosByCategoria(CategoriaDeUsuario categoriaDeUsuario);
}
