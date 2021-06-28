package com.grupofds.projetoTF.negocio.servicos;

import com.grupofds.projetoTF.negocio.entidades.Endereco;
import com.grupofds.projetoTF.negocio.entidades.Reclamacao;
import com.grupofds.projetoTF.negocio.entidades.usuarios.Usuario;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioEnderecos;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioReclamacoes;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioUsuarios;

import org.springframework.beans.factory.annotation.Autowired;

public class EnderecoServico {
    private IRepositorioReclamacoes repositorioReclamacoes;
    private IRepositorioUsuarios repositorioUsuarios;
    private IRepositorioEnderecos repositorioEnderecos;
    
    @Autowired
    public EnderecoServico(IRepositorioReclamacoes repositorioReclamacoes,IRepositorioUsuarios repositorioUsuarios) {
		this.repositorioReclamacoes = repositorioReclamacoes;
		this.repositorioUsuarios = repositorioUsuarios;
	}

	public Endereco updateEndereco(Long usuarioId, Long reclamacaoId, Endereco novoEndereco) {
    	Usuario user = repositorioUsuarios.getById(usuarioId);
    	if (user == null) {
            throw new IllegalArgumentException("ERRO! Usuário não encontrado. Indique um Id de Usuário válido."); //TODO -> UserNotFoundException
        } 
        Reclamacao reclamacao = repositorioReclamacoes.getById(reclamacaoId);
        if (reclamacao == null) {
            throw new IllegalArgumentException("ERRO! Reclamação não encontrada. Indique um Id de Reclamação válido."); //TODO -> ReclamacaoNotFoundException
        }
        if (!user.equals(repositorioReclamacoes.getById(reclamacaoId).getUsuario_id())) {
            throw new IllegalArgumentException("Usuário de Id " + user.getId() + " não possui permissão para atualizar esta Reclamação.");
        } 
        return repositorioEnderecos.updateEndereco(novoEndereco);
    }

    public Endereco createEndereco(Endereco endereco) {
        return repositorioEnderecos.createEndereco(endereco);
    }

    public Endereco getById(Long enderecoId) {
        return repositorioEnderecos.getById(enderecoId);
    }
    
    public Endereco getByReclamacaoId(Long reclamacaoId) {
        return repositorioEnderecos.getByReclamacaoId(reclamacaoId);
    }

}
