package com.grupofds.projetoTF.negocio.repositorios;

import com.grupofds.projetoTF.negocio.entidades.Endereco;

public interface IRepositorioEnderecos {
    Endereco createEndereco(Endereco endereco);
    Endereco updateEndereco(Endereco endereco);
    Endereco getById(Long id);
    Endereco getByReclamacaoId(Long idReclamacao);
}
