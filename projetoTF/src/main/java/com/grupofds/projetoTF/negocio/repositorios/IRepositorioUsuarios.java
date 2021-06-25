package com.grupofds.projetoTF.negocio.repositorios;

import com.grupofds.projetoTF.negocio.entidades.usuarios.Usuario;

public interface IRepositorioUsuarios {
    public Usuario getById(Long id);
}
