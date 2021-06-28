package com.grupofds.projetoTF.negocio.servicos;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupofds.projetoTF.aplicacao.dtos.requisicoes.CriarReclamacaoRequisicaoDTO;
import com.grupofds.projetoTF.negocio.entidades.Reclamacao;
import com.grupofds.projetoTF.negocio.entidades.StatusReclamacoes;
import com.grupofds.projetoTF.negocio.entidades.usuarios.CategoriaDeUsuario;
import com.grupofds.projetoTF.negocio.entidades.usuarios.Usuario;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioReclamacoes;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioUsuarios;

@Service
public class ReclamacaoServico {

    private IRepositorioReclamacoes repositorioReclamacoes;
    private IRepositorioUsuarios repositorioUsuarios;
    
    @Autowired
    public ReclamacaoServico(IRepositorioReclamacoes repositorioReclamacoes,IRepositorioUsuarios repositorioUsuarios) {
		this.repositorioReclamacoes = repositorioReclamacoes;
		this.repositorioUsuarios = repositorioUsuarios;
	}

	public Reclamacao updateReclamacao(Long usuarioId, Long reclamacaoId, Reclamacao novosDadosReclamacao) {
    	Usuario user = repositorioUsuarios.getById(usuarioId);
    	if (user != null) {
    		Reclamacao reclamacao = repositorioReclamacoes.getById(reclamacaoId);
    		if ((reclamacao == null)) {
    			throw new IllegalArgumentException("ERRO! Reclamação não encontrada. Indique um Id válido."); //TODO -> ReclamacaoNotFoundException
    		} else {
    			if (user.getId() == reclamacao.getUsuario_id().getId()) {
    				return repositorioReclamacoes.updateReclamacao(novosDadosReclamacao);
    			} else throw new IllegalArgumentException("Usuário de Id" + user.getId() +"não possui permissão para atualizar esta Reclamação.");
    		}
    	} else throw new IllegalArgumentException("ERRO! Usuário não encontrado. Indique um Id válido."); //TODO -> UserNotFoundException
    }

    public Reclamacao createReclamacao(CriarReclamacaoRequisicaoDTO reclamacaoDTO) {
    	if (reclamacaoDTO.getUsuario_id() != null) {
    		
    		Usuario usuario = repositorioUsuarios.getById(reclamacaoDTO.getUsuario_id());
    		
    		if((usuario.getId() != null)) {
    			if (usuario.getCategoriaDeUsuario() == CategoriaDeUsuario.CIDADAO) {
    				Reclamacao reclamacao = new Reclamacao(null, usuario, reclamacaoDTO.getTitulo(), reclamacaoDTO.getDescricao(), LocalDateTime.now(), 
        	    			reclamacaoDTO.getEndereco() , reclamacaoDTO.getImagem(), reclamacaoDTO.getCategoria(), StatusReclamacoes.ABERTA, null);
        	    	return repositorioReclamacoes.createReclamacao(reclamacao);
    			} else throw new IllegalArgumentException("ERRO! Usuário não possui permissão para criar nova reclamação.");
    			
    		} else throw new IllegalArgumentException("ERRO! Usuário não encontrado. Indique um Id válido.");
    		
    	} else throw new IllegalArgumentException("ERRO! Usuário não encontrado. Indique um Id válido.");
    }

    public Reclamacao getReclamacaoById(Long reclamacaoId) {
        return repositorioReclamacoes.getById(reclamacaoId);
    }

    public List<Reclamacao> getReclamacoesByCategoria(String categoria) {
        return repositorioReclamacoes.getByCategoria(categoria);
    }
    
    public List<Reclamacao> getReclamacoesByUsuario(Long idUsuario) {
        return repositorioReclamacoes.getByUsuario(idUsuario);
    }

    public List<Reclamacao> getReclamacoesByPeriodo(LocalDateTime periodoInicial, LocalDateTime periodoFinal) {
        return repositorioReclamacoes.getByPeriodo(periodoInicial, periodoFinal);
    }

    public List<Reclamacao> getReclamacoesByBairro(String bairro) {
        return repositorioReclamacoes.getByBairro(bairro);
    }

	public List<Reclamacao> getReclamacoes() {
		return repositorioReclamacoes.getReclamacoes();
	}
}
