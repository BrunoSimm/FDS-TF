package com.grupofds.projetoTF.negocio.servicos;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupofds.projetoTF.aplicacao.dtos.requisicoes.CriarReclamacaoRequisicaoDTO;
import com.grupofds.projetoTF.aplicacao.dtos.requisicoes.EditarReclamacaoRequisicaoDTO;
import com.grupofds.projetoTF.negocio.entidades.Endereco;
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

    public Reclamacao createReclamacao(CriarReclamacaoRequisicaoDTO reclamacaoDTO) {
    	if (reclamacaoDTO.getUsuario_id() == null) {
			throw new IllegalArgumentException("ERRO! Usuário Id não pode ser null.");
		}

		Usuario usuario = repositorioUsuarios.getById(reclamacaoDTO.getUsuario_id());
		if((usuario.getId() == null)) {
			throw new IllegalArgumentException("ERRO! Usuário não encontrado. Indique um Id válido.");
		}
		if (usuario.getCategoriaDeUsuario() != CategoriaDeUsuario.CIDADAO) {
			throw new IllegalArgumentException("ERRO! Usuário não possui permissão para criar nova Reclamação.");
		}

		Reclamacao reclamacao = new Reclamacao(null, usuario, reclamacaoDTO.getTitulo(), reclamacaoDTO.getDescricao(), LocalDateTime.now(), 
				reclamacaoDTO.getEndereco() , reclamacaoDTO.getImagem(), reclamacaoDTO.getCategoria(), StatusReclamacoes.ABERTA, null);
		return repositorioReclamacoes.createReclamacao(reclamacao);
    }

	public Reclamacao updateReclamacao(Long usuarioId, Long reclamacaoId, EditarReclamacaoRequisicaoDTO reclamacaoDTO) {
		Usuario user = repositorioUsuarios.getById(usuarioId);
    	if (user == null) {
			throw new IllegalArgumentException("ERRO! Usuário não encontrado. Indique um Id válido.");
		}

		Reclamacao reclamacao = repositorioReclamacoes.getById(reclamacaoId);
		if (reclamacao == null) {
			throw new IllegalArgumentException("ERRO! Reclamação não encontrada. Indique um Id válido.");
		}
		if (!user.equals(reclamacao.getUsuario())) {
			throw new IllegalArgumentException("Usuário de Id " + user.getId() +" não possui permissão para atualizar esta Reclamação.");
		}

		//Valida novos dados da Reclamacao.
		String novoTitulo = reclamacaoDTO.getTitulo();
		if (novoTitulo != null && !novoTitulo.isBlank() && !novoTitulo.isEmpty()) {
			reclamacao.setTitulo(novoTitulo);
		}

		String novaDescricao = reclamacaoDTO.getDescricao();
		if (novaDescricao != null && !novaDescricao.isBlank() && !novaDescricao.isEmpty()) {
			reclamacao.setDescricao(novaDescricao);
		}

		Endereco novoEndereco = reclamacaoDTO.getEndereco();
		if (novoEndereco != null) {
			//TODO: verificar persistencia no banco de dados.
			reclamacao.setEndereco(novoEndereco);
		}

		String novaImagem = reclamacaoDTO.getImagem();
		reclamacao.setImagem(novaImagem);
		
		String novaCategoria = reclamacaoDTO.getCategoria();
		if (novaCategoria != null && !novaCategoria.isBlank() && !novaCategoria.isEmpty()) {
			reclamacao.setCategoria(novaCategoria);
		}

		return repositorioReclamacoes.updateReclamacao(reclamacao);
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
