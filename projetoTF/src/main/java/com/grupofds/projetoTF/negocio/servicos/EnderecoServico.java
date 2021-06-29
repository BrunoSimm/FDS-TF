package com.grupofds.projetoTF.negocio.servicos;

import com.grupofds.projetoTF.negocio.entidades.Endereco;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioEnderecos;

import org.springframework.beans.factory.annotation.Autowired;

public class EnderecoServico {
    private IRepositorioEnderecos repositorioEnderecos;
    
    @Autowired
    public EnderecoServico(IRepositorioEnderecos repositorioEnderecos) {
        this.repositorioEnderecos = repositorioEnderecos;
    }

    public Endereco getById(Long enderecoId) {
        return repositorioEnderecos.getById(enderecoId);
    }
    
    public Endereco getByReclamacaoId(Long reclamacaoId) {
        return repositorioEnderecos.getByReclamacaoId(reclamacaoId);
    }

}
