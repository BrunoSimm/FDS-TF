package com.grupofds.projetoTF.negocio.servicos;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    			if (user.getId() == reclamacao.getUsuario().getId()) {
    				return repositorioReclamacoes.updateReclamacao(novosDadosReclamacao);
    			} else throw new IllegalArgumentException("Usuário de Id" + user.getId() +"não possui permissão para atualizar esta reclamacação.");
    		}
    	} else throw new IllegalArgumentException("ERRO! Usuário não encontrado. Indique um Id válido."); //TODO -> UserNotFoundException
    }

    public Reclamacao createReclamacao(Reclamacao reclamacao) {
        return repositorioReclamacoes.createReclamacao(reclamacao);
    }

    public Reclamacao encerraReclamacao(Long usuarioOficialId, Long reclamacaoId) {
    	Usuario user = repositorioUsuarios.getById(usuarioOficialId);
    	if ((user != null)) {
    		if (user.getCategoriaDeUsuario() == CategoriaDeUsuario.USUARIO_OFICIAL) {
    			throw new IllegalArgumentException("ERRO! Usuário não possui as permissões necessárias para encerrar esta Reclamação."); //TODO -> PermissoesException
    		} else {
    			Reclamacao reclamacao = repositorioReclamacoes.getById(reclamacaoId);
        		if ((reclamacao == null)) {
        			throw new IllegalArgumentException("ERRO! Reclamação não encontrada. Indique um Id válido."); //TODO -> ReclamacaoNotFoundException
        		} else {
        			reclamacao.setStatus(StatusReclamacoes.ENCERRADA);
        			return repositorioReclamacoes.updateReclamacao(reclamacao);
        		}
    		}
    		
    	} else throw new IllegalArgumentException("ERRO! Usuário não encontrado. Indique um Id válido."); //TODO -> UserNotFoundException
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
}
